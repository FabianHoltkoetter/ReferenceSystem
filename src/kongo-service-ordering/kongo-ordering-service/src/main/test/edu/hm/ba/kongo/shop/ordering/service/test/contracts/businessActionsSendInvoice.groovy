package edu.hm.ba.kongo.shop.ordering.service.test.contracts

import org.springframework.cloud.contract.spec.Contract


/**
 * Contract for GET on the base endpoint
 */
Contract.make {
    request {
        method 'POST'
        url '/businessActions/sendInvoice'
        headers {
            contentType(applicationJson())
        }
        body([
                orderID: '123'
        ])
    }
    response {
        status 500
        body('The BusinessAction sendinvoice is not yet implemented!')
    }
}