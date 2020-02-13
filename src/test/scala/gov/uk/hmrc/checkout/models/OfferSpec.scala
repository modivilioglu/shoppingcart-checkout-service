package gov.uk.hmrc.checkout.models

import gov.uk.hmrc.checkout.models.Offer.{AppleBuyOneGetOneFree, OrangeThreeForPriceOfTwo}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class OfferSpec extends AnyWordSpec with Matchers {
  "BuyOneGetOneFree for Apples should give the right discount" in {
    AppleBuyOneGetOneFree.getDiscount(List(Item.Apple, Item.Orange, Item.Apple)) shouldBe Price(60, CurrencyUnit.Penny)
  }

  "ThreeForTwo for Oranges should give the right discount" in {
    OrangeThreeForPriceOfTwo.getDiscount(List(Item.Orange, Item.Orange, Item.Apple, Item.Orange)) shouldBe Price(25, CurrencyUnit.Penny)
  }
}
