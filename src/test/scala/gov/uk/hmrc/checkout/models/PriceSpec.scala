package gov.uk.hmrc.checkout.models

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PriceSpec extends AnyWordSpec with Matchers {
  "Price" should {
    "be able to be compared with different currency units" in {
      Price(10, CurrencyUnit.Penny) shouldBe(Price(0.1, CurrencyUnit.Pound))
    }

    "be able to be added" in {
      Price(10, CurrencyUnit.Penny) + Price(0.9, CurrencyUnit.Pound) shouldBe(Price(1, CurrencyUnit.Pound))
    }

    "be able to be converted from Pound to Penny" in {
      Price(2.34, CurrencyUnit.Pound).inPennies() shouldBe(Price(234, CurrencyUnit.Penny))
    }

    "be able to be converted from Penny to Pound" in {
      Price(124, CurrencyUnit.Penny).inPounds() shouldBe(Price(1.24, CurrencyUnit.Pound))
    }
  }

}
