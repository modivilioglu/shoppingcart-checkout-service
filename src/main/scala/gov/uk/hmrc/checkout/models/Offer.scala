package gov.uk.hmrc.checkout.models

import gov.uk.hmrc.checkout.models.Item.{Apple, Orange}

sealed trait Offer {
  def getDiscount(items: List[Item]): Price
}

object Offer {

  case object AppleBuyOneGetOneFree extends Offer {
    private def getApples(items: List[Item]): List[Item] =
      items.filter(item => item match {
        case Apple => true
        case _ => false
      })

    override def getDiscount(items: List[Item]): Price = {
      val totalApples = getApples(items).size
      val applesInTwos: Int = totalApples / 2
      Apple.price * applesInTwos
    }
  }

  case object OrangeThreeForPriceOfTwo extends Offer {
    private def getOranges(items: List[Item]): List[Item] =
      items.filter(item => item match {
        case Orange => true
        case _ => false
      })

    override def getDiscount(items: List[Item]): Price = {
      val totalOranges = getOranges(items).size
      val orangesInThree: Int = totalOranges / 3
      Orange.price * orangesInThree
    }
  }
}



