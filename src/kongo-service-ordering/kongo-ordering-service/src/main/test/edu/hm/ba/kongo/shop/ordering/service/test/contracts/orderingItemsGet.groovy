org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/orderingItems'
    }
    response {
        status 200
        body("""
{
  "_embedded": {
    "orderingItems": []
  },
  "_links": {
    "self": {
      "href": "http://localhost/orderingItems"
    },
    "profile": {
      "href": "http://localhost/profile/orderingItems"
    },
    "search": {
      "href": "http://localhost/orderingItems/search"
    }
  }
}
  """)
    }
}