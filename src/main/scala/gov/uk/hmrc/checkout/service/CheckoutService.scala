package gov.uk.hmrc.checkout.service

import gov.uk.hmrc.checkout.models.{CurrencyUnit, Item, Offer, Price}

class CheckoutService(offers: List[Offer]) {
  val zeroPrice = Price(0, CurrencyUnit.Pound)

  private def calculateTotalItemsPrice(items: List[Item]): Price = {
    items.foldLeft[Price](zeroPrice)((totalSoFar, currentItem) => totalSoFar + currentItem.price)
  }

  private def calculateTotalDiscounts(items: List[Item]): Price = {
    val discounts = offers.map(_.getDiscount(items))
    discounts.foldLeft(zeroPrice)((totalSoFar, currentDiscount) => totalSoFar + currentDiscount)
  }

  def calculateTotalPrice(items: List[Item]): Price = {
    calculateTotalItemsPrice(items) - calculateTotalDiscounts(items)
  }
}
