package com.github.rojanu.app.feature

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith
import org.junit.{AfterClass, BeforeClass}

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("classpath:features"),
  glue = Array("com.github.rojanu.app.feature.steps"),
  plugin = Array("pretty", "html:target/cucumber-report/html", "usage:target/cucumber-report/usage.json"),
  strict = true,
  tags = Array("@my-tag", "~@wip")
)
class RunCucumber {
}

object RunCucumber {
}