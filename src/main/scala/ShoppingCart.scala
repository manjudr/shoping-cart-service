import com.equalexperts.service.{CartService, ItemService}

object ShoppingCart {
  def main(args: Array[String]): Unit = {
    val ITEM_ID = "DOVE"
    val cartService = new CartService()
    val isItemAvailable = ItemService.isAvailable(ITEM_ID)
    if (isItemAvailable) {
      cartService.addItem(ITEM_ID, 5)
    }

  }
}