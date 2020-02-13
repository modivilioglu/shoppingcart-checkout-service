package gov.uk.hmrc.checkout.models

import gov.uk.hmrc.checkout.models.Item.{Apple, Orange}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ItemSpec extends AnyWordSpec with Matchers {
  "Apples" should {
    "cost 60 p" in {
      Apple.price shouldBe Price(60, CurrencyUnit.Penny)
    }
  }

  "Oranges" should {
    "cost 25 p" in {
      Orange.price shouldBe Price(25, CurrencyUnit.Penny)
    }
  }

}
