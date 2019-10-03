/**
  * Author : Manjunath Davanam <manjunathdavanam@gmail.com>
  */

package com.equalexperts.service

import com.equalexperts.models.Item
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.scalatest.FreeSpec

class BaseSpec extends FreeSpec {
  def prepareTest(): Unit = {
    val mapper = new ObjectMapper
    mapper.registerModule(DefaultScalaModule)
    val items: Array[Item] = mapper.readValue(AppConfig.getConfig("com.cart.catlog.list"), classOf[Array[Item]])
    ItemService.updateCatalog(items)

  }
}
