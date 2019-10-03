package com.equalexperts.interfaces

import com.equalexperts.service.{Item, Bill}

import scala.collection.mutable.ArrayBuffer

/**
  * Interface which defines the any shopping cart implement with this spec.
  */
trait Cart {
  /**
    * Cart - Which holds the items, Items are added by the user.
    */
  var cart: ArrayBuffer[Item] = ArrayBuffer()

  /**
    * Method which is used to add the items into cart.
    * Any shopping cart class can implement this
    *
    * @param item  - Item need to add into cart
    * @param units - No.of same item need to add into cart.
    */
  def addItem(item: String, units: Int): Unit

  /**
    * Display all available items in the cart.
    * Any cart class can implement this.
    *
    * @return - List of items
    */
  def showItems(): ArrayBuffer[Item]

  /**
    * Remove the particular item form the cart.
    *
    * @param item  - Item which need to remove from the cart.
    * @param units - No.of same item need to remove.
    * @return - Boolean
    */
  def removeItem(item: String, units: Int): Boolean

  /**
    * Get the particular item spec detail from the cart.
    *
    * @param item - Item identifier.
    * @return - Item spec (name, identifier, price, description....etc,.)
    */
  def getItem(item: String): Item

  /**
    * Which gives the information about cart status - empty or not.
    *
    * @return - Boolean
    */
  def isCartEmpty: Boolean

  /**
    * Clear all the items which is available in the cart
    *
    * @return
    */
  def clearCart: ArrayBuffer[Item]

  /** Get the billing information of the items (items, percentageOf tax, totalTax, totalAmount)
    *
    * @return Billing information
    */
  def getBillDetails: Bill

}