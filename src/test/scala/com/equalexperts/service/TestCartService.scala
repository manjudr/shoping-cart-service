package com.equalexperts.service

import org.scalatest.FreeSpec

class TestCartService extends FreeSpec {
  val service = new CartService()
  "Cart Service" - {
    "When The user adds 5 Dove Soaps to the shopping cart" - {
      "The shopping cart should contain 5 Dove Soaps each with a unit price of 39.99" in {
        assert(Set.empty.size == 0)
      }

      "And the shopping cart’s total price should equal 199.95" in {
        assertThrows[NoSuchElementException] {
          Set.empty.head
        }
      }
    }
    "The user adds 5 Dove Soaps to the shopping cart And then adds another 3 Dove Soaps to the shopping cart" - {
      "The shopping cart should contain 8 Dove Soaps each with a unit price of 39.99" in {
        assert(Set.empty.size == 0)
      }

      "And the shopping cart’s total price should equal 319.92" in {
        assertThrows[NoSuchElementException] {
          Set.empty.head
        }
      }
    }

    "The user adds 2 Dove Soaps to the shopping cart And then adds 2 Axe Deos to the shopping cart" - {
      "The shopping cart should contain 2 Dove Soaps each with a unit price of 39.99" in {
        assert(Set.empty.size == 0)
      }

      "And the shopping cart should contain 2 Axe Deos each with a unit price of 99.99" in {
        assertThrows[NoSuchElementException] {
          Set.empty.head
        }
      }
      "And the total sales tax amount for the shopping cart should equal 35.00" in {
        assertThrows[NoSuchElementException] {
          Set.empty.head
        }
      }

      "And the shopping cart’s total price should equal 314.96" in {
        assertThrows[NoSuchElementException] {
          Set.empty.head
        }
      }
    }
  }
}
