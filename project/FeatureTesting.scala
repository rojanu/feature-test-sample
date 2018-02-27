import sbt._

object FeatureTesting {
  lazy val FeatureTests = config("ft") extend(Test)
  lazy val featureSettings = Seq(inConfig(FeatureTests)(Defaults.testSettings) : _*)
}
