package gov.uk.hmrc.checkout.service

import gov.uk.hmrc.checkout.models.Item.{Apple, Orange}
import gov.uk.hmrc.checkout.models.{CurrencyUnit, Price}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CheckoutServiceSpec extends AnyWordSpec with Matchers {

  "CheckoutService" should {
    "output the total cost" in {

      val checkoutService = new CheckoutService
      checkoutService.calculateTotalPrice(List(Apple, Apple, Orange, Apple)) shouldBe Price(2.05, CurrencyUnit.Pound)
    }
  }
}
