import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        urlPath('/carts/search/findByUserID') {
            queryParameters {
                parameter 'userID': '123'
            }
        }
    }

    response {
        status 200
        body("""
{
  "_embedded": {
    "carts": []
  }
}
""")
    }
}