import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path}
import java.util

import sbt.Keys._
import sbt.{Def, _}
import sbtassembly.AssemblyKeys._
import sbtassembly.MergeStrategy

import scala.io.{Codec, Source}


object PublishSettings {

  lazy val env: util.Map[String, String] = System.getenv()

  val updateLogbackComponentVersionTask = taskKey[Unit]("Update COMPONENT_VERSION in logback.xml")

  private def updateLogbackComponentVersion(): Def.Initialize[Path] = Def.setting {
    val logbackXml = baseDirectory.value / "src" / "main" / "resources" / "logback.xml"
    val lines: List[String] = Source.fromFile(logbackXml)(Codec.UTF8).getLines().toList
    val markerText = "PROJECT_VERSION"
    val lineNumberOfMarker = lines.indexWhere(_.contains(markerText))

    if (lineNumberOfMarker == -1) {
      throw new RuntimeException(s"Could not find marker '$markerText' in file '${logbackXml.getPath}'")
    }

    val newLine = s"""<property name="COMPONENT_VERSION" value="${version.value}"/>""""
    val newContent = lines.updated(lineNumberOfMarker, newLine).mkString("\n")

    Files.write(logbackXml.toPath, newContent.getBytes(StandardCharsets.UTF_8))
  }

  lazy val publishSettings: Seq[Def.Setting[_]] = Seq(
    updateLogbackComponentVersionTask := updateLogbackComponentVersion(),
    test in assembly := {},
    mainClass in assembly := Some("com.github.rojanu.app.Main"),
    assemblyJarName in assembly := s"calendaring-${version.value}.jar",
    assemblyMergeStrategy in assembly := {
      case "logback.xml" => MergeStrategy.first
      case x => val oldStrategy = (assemblyMergeStrategy in assembly).value
        oldStrategy(x)
    },
    artifact in(Compile, assembly) := {
      val art = (artifact in(Compile, assembly)).value
      art.withClassifier(Some("dist"))
    },
    publishArtifact in(Compile, packageDoc) := false,
    publishArtifact in packageDoc := false,
    sources in(Compile, doc) := Seq.empty,
    //    publishSettings
    publishTo := Some(
      if (isSnapshot.value)
        Opts.resolver.sonatypeSnapshots
      else
        Opts.resolver.sonatypeStaging
    ),
    credentials += Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", env.get("SONATYPE_USER"), env.get("SONATYPE_TOKEN")),
    publishMavenStyle := true
  )

  lazy val assemblyArtifact: Def.SettingsDefinition = addArtifact(artifact in(Compile, assembly), assembly)
}
