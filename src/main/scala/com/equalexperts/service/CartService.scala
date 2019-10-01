package com.equalexperts.service

import com.equalexperts.interfaces.Cart
import scala.collection.mutable.ListBuffer

/**
  * CartService which will facilitates the purchase of a product or service
  */
class CartService extends Cart {
  override var cart = new ListBuffer[String]()


  /**
    * Method used to add item to cart
    *
    * @param item  - Identifier of the Item/Product
    * @param count - Number of items, Need to remove from the cart.
    * @return - Boolean
    */
  override def addItem(item: String, count: Int): Boolean = {
    false
  }

  /**
    * Method used to get the item MetaData information
    *
    * @param item - Identifier of the Item/Product
    * @return - Map[String, String], MetaData of the Item.
    */
  override def getItem(item: String): Map[String, String] = {
    null
  }

  /**
    * Method used to remove the specific item from the cart.
    *
    * @param item  - Identifier of the Item/Product
    * @param count - Number of items, Need to remove from the cart.
    * @return - Boolean
    */
  override def removeItem(item: String, count: Int): Boolean = {
    true
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
  override def clearCart: ListBuffer[String] = {
    cart.clear()
    cart
  }

}
