import org.scalatest.{Matchers, WordSpec}


class CalculatorSpec extends WordSpec with Matchers {

  "Banknotes " should {

    "return " when {

      "no one" in {

        Calculator.returnNotes(0) should be(Map[Int,Int]())
      }

      "one five" in {

        Calculator.returnNotes(1) should be(Map(1->5))
      }

      "one ten" in {
        Calculator.returnNotes(7) should be(Map(1->10))
      }

      "one twenty" in {
        Calculator.returnNotes(17) should be(Map(1->20))
      }

      "one ten one five" in {
        Calculator.returnNotes(11) should be(Map(1->10,1->5))
      }
    }
  }

}
