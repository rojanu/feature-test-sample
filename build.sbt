import BuildInfoSettings.buildInfoSettings
import Dependencies._
import BuildSettings._
import FeatureTesting.{FeatureTests, featureSettings}
import PublishSettings.{assemblyArtifact, publishSettings}
import sbt.Resolver

conflictManager := ConflictManager.strict

// -------------------------------------------------------------------------------------------------------------------
// Root Project
// -------------------------------------------------------------------------------------------------------------------

lazy val calendaring = project.in(file("."))
  .enablePlugins(BuildInfoPlugin)
  .configs(FeatureTests)
  .settings(
    basicSettings,
    buildInfoSettings,
    featureSettings,
    publishSettings,
    assemblyArtifact,
    resolvers ++= Dependencies.resolutionRepos,
    resolvers += Resolver.mavenLocal,
    dependencyOverrides ++= Dependencies.calDependencyOverrides,
    libraryDependencies ++=
      Dependencies.compile(akkaHttpSprayJson, flyWayCore, logbackClassic, mysql, scalaGuice, scalaLogging,
        slickCodeGen, slickHikarico, ical, guava,
        json4sNative, json4sJackson, javaMail) ++
        Dependencies.test(akkaHttp, akkaHttpTestKit, cucumberScala, cucumberJunit, h2, jUnitInterface, scalaMock, wireMock, pegdown) ++
        Dependencies.provided(hikariCP)
  )
