import sbt.{Resolver, _}

object Dependencies extends DependencyUtils {

  val resolutionRepos = Seq(
    Resolver.mavenLocal,
    Resolver.sonatypeRepo("snapshots"),
    Resolver.sonatypeRepo("releases"),
    "Flyway" at "http://flywaydb.org/repo"
  )

  private object Version {
    val akkaHttp: String = "10.0.10"
    val cucumber: String = "1.2.5"
    val javaMail: String = "1.6.0"
    val json4s: String = "3.5.2"
    val slick: String = "3.2.1"
  }

  val akkaHttpSprayJson: ModuleID = "com.typesafe.akka" %% "akka-http-spray-json" % Version.akkaHttp
  val flyWayCore: ModuleID = "org.flywaydb" % "flyway-core" % "4.2.0"
  val guava: ModuleID = "com.google.guava" % "guava" % "23.0"
  val hikariCP: ModuleID = "com.zaxxer" % "HikariCP" % "2.6.3"
  val ical = "org.mnode.ical4j" % "ical4j" % "1.0.2"
  val javaMail = "com.sun.mail" % "javax.mail" % Version.javaMail
  val json4sNative = "org.json4s" %% "json4s-native" % Version.json4s
  val json4sJackson = "org.json4s" %% "json4s-jackson" % Version.json4s
  val logbackClassic: ModuleID = "ch.qos.logback" % "logback-classic" % "1.2.3"
  val mysql: ModuleID = "mysql" % "mysql-connector-java" % "5.1.43"
  val slickCodeGen: ModuleID = "com.typesafe.slick" %% "slick-codegen" % Version.slick
  val scalaGuice: ModuleID = "net.codingwell" %% "scala-guice" % "4.1.0"
  val slickHikarico: ModuleID = "com.typesafe.slick" %% "slick-hikaricp" % Version.slick
  val scalaLogging: ModuleID = "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2"

  //TEST DEPENDENCIES
  val akkaHttp: ModuleID = "com.typesafe.akka" %% "akka-http" % Version.akkaHttp
  val akkaHttpTestKit: ModuleID = "com.typesafe.akka" %% "akka-http-testkit" % Version.akkaHttp
  val cucumberJunit: ModuleID = "info.cukes" % "cucumber-junit" % Version.cucumber
  val cucumberScala: ModuleID = "info.cukes" %% "cucumber-scala" % Version.cucumber
  val h2: ModuleID = "com.h2database" % "h2" % "1.4.195"
  val jUnitInterface: ModuleID = "com.novocode" % "junit-interface" % "0.11"
  val pegdown: ModuleID = "org.pegdown" % "pegdown" % "1.6.0"
  val scalaMock: ModuleID = "org.scalamock" %% "scalamock-scalatest-support" % "3.6.0"
  val wireMock: ModuleID = "com.github.tomakehurst" % "wiremock" % "2.15.0"


  val calDependencyOverrides = Seq(
    "com.google.code.findbugs" % "jsr305" % "3.0.1",
    "com.google.guava" % "guava" % "23.0",
    "com.fasterxml.jackson.core" % "jackson-annotations" % "2.9.2",
    "com.fasterxml.jackson.core" % "jackson-core" % "2.9.2",
    "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.2",
    "com.typesafe" % "config" % "1.3.2",
    "commons-codec" % "commons-codec" % "1.10",
    "commons-logging" % "commons-logging" % "1.2",
    hikariCP,
    "junit" % "junit" % "4.12",
    "org.ow2.asm" % "asm" % "5.0.4",
    "org.scala-lang.modules" %% "scala-xml" % "1.0.6",
    "org.slf4j" % "slf4j-api" % "1.7.25"
  )
}
