package edu.hm.ba.kongo.shop.ordering.service.test.contracts

import org.springframework.cloud.contract.spec.Contract

/**
 * Contract for POST on the base endpoint to create an entity
 */
Contract.make {
    request {
        method 'POST'
        url '/orderingItems'
        body([
                cart     : "123",
                orderedOn: "2010-10-10"
        ])
    }

    response {
        status 201
        body([
                cart     : '123',
                orderedOn: '2010-10-10'
        ])
    }
}