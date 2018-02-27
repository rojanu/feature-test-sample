import sbt.Keys._
import sbt._

object BuildSettings {
  lazy val basicSettings = Seq(
    //    projectSettings
    name := "feature-test-sample",
    description := "feature-test-sample",
    organization := "com.github.rojanu",
    organizationHomepage := Some(new URL("http://rojanu.github.com")),
    homepage := Some(new URL("https://github.com/rojanu/feature-test-sample")),
    scalaVersion := "2.11.8",
    crossPaths := false,
    javacOptions ++= Seq("-encoding", "UTF-8"),
    scalacOptions := Seq(
      "-encoding", "utf8",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-target:jvm-1.8",
      "-language:_",
      "-Xlog-reflective-calls",
      "-Ywarn-adapted-args"
    ),
    //    testSettings
    testOptions in Test ++= Seq(
      Tests.Argument(TestFrameworks.ScalaTest, "-oD"),
      Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/scalatest-report")
    ),
    parallelExecution in Test := false,
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")
  )
}
