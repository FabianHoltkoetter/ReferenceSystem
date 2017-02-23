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
        body([
                productID: '123',
                quantity: 1
        ])
    }
    response {
        status 500
        body("""
{
  "error": "Unsupported Operation Exception",
  "message": "The BusinessAction addtocart is not yet implemented!",
  "status": 500
}
""")
    }
}