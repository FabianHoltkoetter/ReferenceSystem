package edu.hm.ba.kongo.shop.shoppingcart.service.test.contracts

import org.springframework.cloud.contract.spec.Contract


/**
 * Contract for GET on the base endpoint
 */
Contract.make {
    request {
        method 'GET'
        url '/businessActions/testdatenErzeugen'
    }
    response {
        status 200
        producer(execute('isDataCreated()'))
    }
}