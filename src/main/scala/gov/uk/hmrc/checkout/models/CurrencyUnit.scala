package gov.uk.hmrc.checkout.models

sealed trait CurrencyUnit

object CurrencyUnit {

  case object Penny extends CurrencyUnit

  case object Pound extends CurrencyUnit

}
