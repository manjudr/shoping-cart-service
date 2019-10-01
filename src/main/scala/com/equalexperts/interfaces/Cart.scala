package com.equalexperts.interfaces

import scala.collection.mutable.ListBuffer

trait Cart {
  var cart = new ListBuffer[String]()

  def addItem(item: String, count: Int): Boolean

  def removeItem(item: String, count: Int): Boolean

  def getItem(item: String): Map[String, String]

  def isCartEmpty: Boolean

  def clearCart: ListBuffer[String]

}