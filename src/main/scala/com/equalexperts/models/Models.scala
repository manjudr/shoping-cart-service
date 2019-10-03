package com.equalexperts.models

import java.io.Serializable

import scala.collection.mutable.ArrayBuffer

class Models extends Serializable {}

/**
  * Item/Product meta data
  *
  * @param identifier  - Item identifier
  * @param name        - Item Name
  * @param description - Item Description
  * @param price       - Item price
  * @param discount    - Item discount
  * @param isAvailable - Item status
  */
case class Item(var identifier: String,
                var name: String,
                var description: String,
                var price: Double,
                var discount: String,
                var isAvailable: Boolean,
                var units: Option[Int]
               )

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