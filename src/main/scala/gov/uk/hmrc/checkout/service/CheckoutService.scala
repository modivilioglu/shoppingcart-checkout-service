package gov.uk.hmrc.checkout.service

import gov.uk.hmrc.checkout.models.{CurrencyUnit, Item, Price}

class CheckoutService {
  val zeroPrice = Price(0, CurrencyUnit.Pound)

  def calculateTotalPrice(items: List[Item]): Price = {
    items.foldLeft[Price](zeroPrice)((totalSoFar, currentItem) => totalSoFar + currentItem.price)
  }
}
