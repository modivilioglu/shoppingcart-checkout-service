package gov.uk.hmrc.checkout.models

sealed trait Item {
  def price: Price
}

object Item {

  case object Apple extends Item {
    override val price: Price = Price(60, CurrencyUnit.Penny)
  }

  case object Orange extends Item {
    override val price: Price = Price(25, CurrencyUnit.Penny)
  }

}