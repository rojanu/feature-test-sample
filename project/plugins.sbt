resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

conflictManager := ConflictManager.strict

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.3")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.6")
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.7.0")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")
addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.9.3")

dependencyOverrides ++= Seq(
  "com.jcraft" % "jsch" % "0.1.53",
  "com.google.guava" % "guava" % "20.0",
  "org.apache.ant" % "ant" % "1.10.1",
  "org.apache.httpcomponents" % "httpclient" % "4.5",
  "org.apache.maven" % "maven-plugin-api" % "3.3.9",
  "org.codehaus.plexus" % "plexus-utils" % "3.0.17",
  "org.eclipse.sisu" % "org.eclipse.sisu.plexus" % "0.3.2",
  "org.ow2.asm" % "asm" % "6.0",
  "org.ow2.asm" % "asm-commons" % "6.0",
  "org.ow2.asm" % "asm-tree" % "6.0",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.6",
  "org.scala-sbt" %% "io" % "1.0.2",
  "org.slf4j" % "slf4j-api" % "1.7.22"
)
