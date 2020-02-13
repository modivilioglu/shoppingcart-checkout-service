package gov.uk.hmrc.checkout.service

import gov.uk.hmrc.checkout.models.Item.{Apple, Orange}
import gov.uk.hmrc.checkout.models.Offer.{OrangeThreeForPriceOfTwo, AppleBuyOneGetOneFree}
import gov.uk.hmrc.checkout.models.{CurrencyUnit, Price}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CheckoutServiceSpec extends AnyWordSpec with Matchers {

  "CheckoutService" should {
    "output the total cost" in {
      val offers = Nil
      val checkoutService = new CheckoutService(offers)
      checkoutService.calculateTotalPrice(List(Apple, Apple, Orange, Apple)) shouldBe Price(2.05, CurrencyUnit.Pound)
    }

    "output the total cost considering the offer for apples" in {
      val offers = List(AppleBuyOneGetOneFree)
      val checkoutService = new CheckoutService(offers)
      checkoutService.calculateTotalPrice(List(Apple, Orange, Apple)) shouldBe Price(0.85, CurrencyUnit.Pound)
    }

    "output the total cost considering the offer for oranges" in {
      val offers = List(OrangeThreeForPriceOfTwo)
      val checkoutService = new CheckoutService(offers)
      checkoutService.calculateTotalPrice(List(Orange, Apple, Orange, Orange)) shouldBe Price(1.1, CurrencyUnit.Pound)
    }
  }
}
