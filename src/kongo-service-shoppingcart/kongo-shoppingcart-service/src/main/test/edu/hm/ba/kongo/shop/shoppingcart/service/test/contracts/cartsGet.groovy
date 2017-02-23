package edu.hm.ba.kongo.shop.shoppingcart.service.test.contracts

import org.springframework.cloud.contract.spec.Contract


/**
 * Contract for GET on the base endpoint
 */
Contract.make {
    request {
        method 'GET'
        url '/carts'
    }
    response {
        status 200
        body("""
{
  "_embedded": {
    "carts": []
  },
  "_links": {
    "self": {
      "href": "http://localhost/carts"
    },
    "profile": {
      "href": "http://localhost/profile/carts"
    },
    "search": {
      "href": "http://localhost/carts/search"
    }
  }
}
  """)
    }
}