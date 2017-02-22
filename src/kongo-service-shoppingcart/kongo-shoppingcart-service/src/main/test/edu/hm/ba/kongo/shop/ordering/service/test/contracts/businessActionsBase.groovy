package edu.hm.ba.kongo.shop.ordering.service.test.contracts

import org.springframework.cloud.contract.spec.Contract


/**
 * Contract for GET on the base endpoint
 */
Contract.make {
    request {
        method 'GET'
        url '/businessActions'
    }
    response {
        status 200
        body("""
{
  "_links": {
    "self": {
      "href": "http://localhost/businessActions"
    },
    "testdatenErzeugen": {
      "href": "http://localhost/businessActions/testdatenErzeugen"
    },
    "orderCart": {
      "href": "http://localhost/businessActions/orderCart"
    },
    "sendInvoice": {
      "href": "http://localhost/businessActions/sendInvoice"
    },
    "cancelOrder": {
      "href": "http://localhost/businessActions/cancelOrder"
    }
  }
}
  """)
    }
}