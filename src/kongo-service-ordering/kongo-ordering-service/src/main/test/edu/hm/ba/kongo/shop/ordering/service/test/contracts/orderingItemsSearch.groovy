package edu.hm.ba.kongo.shop.ordering.service.test.contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        urlPath('/orderingItems/search/findByCart') {
            queryParameters {
                parameter 'cart': '123'
            }
        }
    }

    response {
        status 404
    }
}