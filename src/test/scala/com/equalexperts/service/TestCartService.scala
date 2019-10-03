/**
  * Author : Manjunath Davanam <manjunathdavanam@gmail.com>
  */

package com.equalexperts.service

class TestCartService extends BaseSpec {
  val CartService = new CartService()
  val DOVE_SOAP_IDENTIFIER = "DOVE"
  val DXE_DEO_IDENTIFIER = "AXE_DEO"
  /**
    * Prepare test method Which loads the items into catalog.
    * Then user can add the items into cart from catalog using cartService.
    */
  prepareTest()

  "Cart Service" - {
    /**
      * GIVEN:
      *  1.An empty shopping cart
      *  2.A product, Dove Soap with a unit price of 39.99
      */
    CartService.clearCart

    "When The user adds 5 Dove Soaps to the shopping cart" - {
      "The shopping cart should contain 5 Dove Soaps each with a unit price of 39.99" in {
        CartService.addItem(DOVE_SOAP_IDENTIFIER, 5)
        val items = CartService.showItems()
        assert(items.head.units.getOrElse(0) === 5)
        assert(items.head.price === 39.99)
      }

      "And the shopping cart’s total price should equal 199.95" in {
        val totalBill = CartService.getBillDetails
        assert(totalBill.totalAmount === 199.95)
      }
    }
    "The user adds 5 Dove Soaps to the shopping cart And then adds another 3 Dove Soaps to the shopping cart" - {
      "The shopping cart should contain 8 Dove Soaps each with a unit price of 39.99" in {
        CartService.clearCart
        CartService.addItem(DOVE_SOAP_IDENTIFIER, 5)
        CartService.addItem(DOVE_SOAP_IDENTIFIER, 3)
        val item = CartService.getItem(DOVE_SOAP_IDENTIFIER)
        assert(item.price === 39.99)

      }

      "And the shopping cart’s total price should equal 319.92" in {
        val totalPrice = CartService.getBillDetails
        assert(totalPrice.totalAmount === 319.92)
      }
    }

    "The user adds 2 Dove Soaps to the shopping cart And then adds 2 Axe Deos to the shopping cart" - {
      "The shopping cart should contain 2 Dove Soaps each with a unit price of 39.99" in {
        CartService.clearCart
        CartService.addItem(DOVE_SOAP_IDENTIFIER, 2)
        CartService.addItem(DXE_DEO_IDENTIFIER, 2)
        val doveSoap = CartService.getItem(DOVE_SOAP_IDENTIFIER)
        assert(doveSoap.price === 39.99)
      }

      "And the shopping cart should contain 2 Axe Deos each with a unit price of 99.99" in {
        val deo = CartService.getItem(DXE_DEO_IDENTIFIER)
        assert(deo.price === 99.99)
      }
      "And the total sales tax amount for the shopping cart should equal 35.00" in {
        val totalBill = CartService.getBillDetails
        assert(totalBill.totalTax === 35.00)
      }

      "And the shopping cart’s total price should equal 314.96" in {
        val totalBill = CartService.getBillDetails
        assert(totalBill.totalAmount === 314.96)
      }
    }
  }
}
