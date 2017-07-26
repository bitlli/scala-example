
import org.scalatest.{Matchers, WordSpec}

class TextSuite extends WordSpec with Matchers {


  "TimeZoneParser" should {

    "pass short time zone" when {

      "calculate tax without costs" in {
        val tax = new Tax(income = 100, costs = 0, rate = 18)
        tax.calculate shouldEqual 118.0f
      }

      "calculate tax with costs" in {
        val tax = new Tax(income = 100, costs = 50, rate = 18)
        tax.calculate  shouldEqual 59.0f
      }

    }
  }

}
