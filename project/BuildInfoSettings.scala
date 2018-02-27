import com.typesafe.sbt.GitPlugin.autoImport.git
import sbt.Keys._
import sbt.{Compile, Package}
import sbtbuildinfo.BuildInfoPlugin.autoImport._

object BuildInfoSettings {
  lazy val buildInfoSettings = Seq(
    buildInfoOptions += BuildInfoOption.ToJson,
    buildInfoPackage := "com.mdsol.buildutils",
    buildInfoObject := "CalendaringBuildInfo",
    buildInfoKeys := Seq[BuildInfoKey](
      name,
      version,
      scalaVersion,
      sbtVersion,
      BuildInfoKey.action("buildDate") {
        new java.util.Date().toString
      },
      BuildInfoKey.action("gitCommit") {
        "git rev-parse HEAD".trim
      },
      BuildInfoKey.action("travisBuildNum") {
        val travisBuildNum = "TRAVIS_BUILD_NUMBER"
        val env = System.getenv()
        if (env.containsKey(travisBuildNum)) {
          env.get(travisBuildNum)
        } else {
          "<Not built on Travis>"
        }
      }
    ),
    packageOptions in(Compile, packageBin) += Package.ManifestAttributes("Git-Commit" -> git.gitHeadCommit.value.get)
  )
}
