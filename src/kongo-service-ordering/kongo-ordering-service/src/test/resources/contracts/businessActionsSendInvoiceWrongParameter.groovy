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
        body("""{}""")
    }
    response {
        status 422
        body("""
{
  "error": "Illegal Argument Exception",
  "message": "Expected values in body: String orderID - Missing [orderID]",
  "status": 422
}
""")
    }
}