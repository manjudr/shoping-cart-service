package com.equalexperts.service

import scala.collection.mutable.ArrayBuffer

/**
  * Which defines the billing spec
  *
  * @param items           - Items which is purchased.
  * @param taxInPercentage - Total tax amount in percentage.
  * @param totalTax        - Total tax amount for the purchasing items
  * @param totalAmount     - Total Amount including tax (Tax + purchasedItemAmount)
  */
case class Bill(items: ArrayBuffer[Item],
                taxInPercentage: Double,
                totalTax: Double,
                totalAmount: Double
               )

/**
  * Service which helps to provide detail spec of the billing information
  */
object CalculateService {

  /**
    * Which is used to get the total billing amount of the items which is in cart.
    *
    * @param item - List of items
    * @return - Billing information
    */
  def getTotalPrice(item: ArrayBuffer[Item]): Bill = {
    val price = item.map(x => x.price * x.units.getOrElse(0)).sum
    val taxInPercent = this.getCurrentTax
    val totalTax = this.computeTax(price, taxInPercent)
    val totalAmount = Math.round(totalTax + price * 100.0) / 100.0
    Bill(item, taxInPercent, totalTax, totalAmount)
  }

  /**
    * Which return the current tax amount
    *
    * @return - Tax amount in percentage.
    */
  def getCurrentTax: Double = {
    AppConfig.getConfig("com.tax.rate").toDouble
  }

  /**
    * Which computes the tax amount for the items in the cart.
    *
    * @param amount       - Total Items Amount
    * @param taxInPercent - Taxable amount in percentage
    * @return - Total tax amount for the certain amount
    */
  def computeTax(amount: Double, taxInPercent: Double): Double = {
    val totalTax = (taxInPercent * 0.01) * amount
    totalTax
  }


}
