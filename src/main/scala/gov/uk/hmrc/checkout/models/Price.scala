package gov.uk.hmrc.checkout.models

import scala.util.Try

final case class Price(amount: BigDecimal, unit: CurrencyUnit) {

  def +(otherPrice: Price): Price = Price(inPennies().amount + otherPrice.inPennies().amount, CurrencyUnit.Penny)

  def inPennies(): Price = unit match {
    case CurrencyUnit.Penny => this
    case CurrencyUnit.Pound => Price(amount * 100, CurrencyUnit.Penny)
  }

  def inPounds(): Price = unit match {
    case CurrencyUnit.Penny => Price(amount / 100.0, CurrencyUnit.Pound)
    case CurrencyUnit.Pound => this
  }

  override def equals(obj: Any): Boolean = {
    Try(inPennies().amount == obj.asInstanceOf[Price].inPennies().amount).getOrElse(false)
  }
}
