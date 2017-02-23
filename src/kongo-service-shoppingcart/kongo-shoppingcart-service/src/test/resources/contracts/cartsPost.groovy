import org.springframework.cloud.contract.spec.Contract

/**
 * Contract for POST on the base endpoint to create an entity
 */
Contract.make {
    request {
        method 'POST'
        url '/carts'
        body("""
{
    "userID": "123",
    "totalPrice": 15.5,
    "items": [
        {
            "product": "123",
            "quantity": 1
        }
    ]
}
        """)
    }

    response {
        status 201
        body("""
{
    "items": [
        {
            "product": "123",
            "quantity": 1
        }
    ],
    "userID": "123",
    "totalPrice": 15.5
}
        """)
    }
}