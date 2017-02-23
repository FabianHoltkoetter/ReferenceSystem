import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        urlPath('/orderingItems/search/findByOrderedOn') {
            queryParameters {
                parameter 'orderedOn': '2010-10-10'
            }
        }
    }

    response {
        status 200
        body("""
{
  "_embedded": {
    "orderingItems": []
  }
}
""")
    }
}