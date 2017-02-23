package edu.hm.ba.kongo.shop.shoppingcart.service.test.contracts

import org.springframework.cloud.contract.spec.Contract


/**
 * Contract for GET on the base endpoint
 */
Contract.make {
    request {
        method 'POST'
        url '/businessActions/addToCart'
        headers {
            contentType(applicationJson())
        }
        body("""{}""")
    }
    response {
        status 422
        body("""
{
  "error": "Illegal Argument Exception",
  "message": "Expected values in body: String productID, Long quantity - Missing [productID, quantity]",
  "status": 422
}
""")
    }
}