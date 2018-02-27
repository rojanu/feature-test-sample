package com.github.rojanu.app.feature.steps

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

/** AddAndMultiplySteps */
class MultiplicationSteps extends ScalaDsl with EN with Matchers {
  var x: Int = 0
  var y: Int = 0
  var z: Int = 0

  Given("""^a variable x with value (\d+)$""") { (arg0: Int) =>
    x = arg0
  }

  Given("""^a variable y with value (\d+)$""") { (arg0: Int) =>
    y = arg0
  }

  When("""^I multiply x \* y$""") { () =>
    z = x * y
  }

  Then("""^I get (\d+)$""") { (arg0: Int) =>
    z should be(arg0)
  }
}