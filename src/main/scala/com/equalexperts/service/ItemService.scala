/**
  * Author : Manjunath Davanam <manjunathdavanam@gmail.com>
  */

package com.equalexperts.service

import com.equalexperts.models.Item

import scala.collection.mutable.ArrayBuffer


object ItemService {
  /**
    * Catalog - Which contains all the items, Where admin can add items to catalog.
    * Then item will be available in the website.
    */
  private var catalogList: ArrayBuffer[Item] = ArrayBuffer()

  /**
    * To get the price of the particular item
    *
    * @param identifier - Item Identifier
    * @return - Item Price
    */
  def getPrice(identifier: String): Double = {
    catalogList.filter(x => x.identifier == identifier).head.price
  }

  /**
    * Get the Metadata of the item from the catalog
    *
    * @param identifier - Item Identifier
    * @return
    */
  def getItem(identifier: String): Item = {
    catalogList.filter(x => x.identifier == identifier).head
  }

  /**
    * Check the status of the item
    *
    * @param identifier - Item Identifier
    * @return
    */
  def isAvailable(identifier: String): Boolean = {
    val item = catalogList.filter(x => x.identifier == identifier)
    if (item.nonEmpty) item.head.isAvailable else false
  }

  /**
    * Update the item catalog from admin.- Expose this method only to admin.
    *
    * @param items - List of items need to add into catalog.
    */
  def updateCatalog(items: Array[Item]): Unit = {
    catalogList = (catalogList ++ items).distinct
  }

}
