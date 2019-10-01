package com.equalexperts.service

import scala.collection.mutable.ListBuffer

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
case class Item(identifier: String,
                name: String,
                description: String,
                price: String,
                discount: String,
                isAvailable: Boolean
               )

object ItemService {
  /**
    * Catalog - Which contains all the items, Where admin can add items to catalog.
    * Then item will be available in the website.
    */
  private var catalogList: ListBuffer[Item] = ListBuffer()

  /**
    * To get the price of the particular item
    *
    * @param identifier - Item Identifier
    * @return - Item Price
    */
  def getPrice(identifier: String): Long = {
    catalogList.map(item => {
      item.price
    })
    null
  }

  /**
    * Get the Metadata of the item from the catalog
    *
    * @param identifier - Item Identifier
    * @return
    */
  def getMetaData(identifier: String): Map[String, Map[String, String]] = {
    null
  }

  /**
    * Check the status of the item
    *
    * @param identifier - Item Identifier
    * @return
    */
  def isAvailable(identifier: String): Boolean = {
    null
  }

  /**
    * Update the item catalog from admin.- Expose this method only to admin.
    *
    * @param items - List of items need to add into catalog.
    */
  def updateCatalog(items: List[Item]): Unit = {
    catalogList = ListBuffer.concat(catalogList, items)
  }

}
