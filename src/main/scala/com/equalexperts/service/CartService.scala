/**
  * Author : Manjunath Davanam <manjunathdavanam@gmail.com>
  */
package com.equalexperts.service

import com.equalexperts.interfaces.Cart
import com.equalexperts.models.{Bill, Item}

import scala.collection.mutable.ArrayBuffer

/**
  * CartService which will facilitates the purchase of a product or service
  */
class CartService extends Cart {
  /**
    * Method used to add item to cart
    *
    * @param identifier - Identifier of the Item/Product
    * @param units      - Number of items, Need to remove from the cart.
    * @return - Boolean
    */
  override def addItem(identifier: String, units: Int): Unit = {
    val catalogItem: Item = ItemService.getItem(identifier) // Get the Item from the catalog
    if (catalogItem.isAvailable) { // Check the item is available for the sell or not.
      val cartItem = this.getItem(identifier)
      if (null != cartItem) {
        // If user is adding same item then just update the units
        cart.foreach(item => item.units = Some(item.units.getOrElse(0) + units))
      } else {
        catalogItem.units = Option(units)
        cart += catalogItem
      }
    }
  }

  /**
    * Method to show the all the items from the cart
    *
    * @return List of items
    */
  override def showItems(): ArrayBuffer[Item] = {
    this.cart
  }

  /**
    * Method used to get the item MetaData information
    *
    * @param identifier - Identifier of the Item/Product
    * @return - Map[String, String], MetaData of the Item.
    */
  override def getItem(identifier: String): Item = {
    val item = this.cart.filter(i => i.identifier == identifier)
    if (item.nonEmpty) item.head else null
  }


  /**
    * Method used to validate cart is empty of not.
    *
    * @return - Boolean
    */
  override def isCartEmpty: Boolean = {
    if (cart.isEmpty) true else false
  }

  /**
    * This Method is used to clear the cart items.
    *
    * @return - Cart of type ListBuffer[String]
    */
  override def clearCart: ArrayBuffer[Item] = {
    cart.clear()
    cart
  }

  /**
    * Which get the billing information of the items which are available in the cart.
    *
    * @return - Billing information
    *         Example: {items : Array[item], taxPercentage:12  totalTax: 145, totalAmount: 1500}
    */
  override def getBillDetails: Bill = {
    CalculateService.getTotalPrice(cart)
  }


  /**
    * Method used to remove the specific item from the cart.
    *
    * @param item  - Identifier of the Item/Product
    * @param units - Number of items, Need to remove from the cart.
    * @return - Boolean
    */
  override def removeItem(item: String, units: Int): Boolean = ???

}
