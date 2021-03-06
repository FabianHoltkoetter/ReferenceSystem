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
        body("""
{
  "error": "Unsupported Operation Exception",
  "message": "The BusinessAction sendinvoice is not yet implemented!",
  "status": 500
}
""")
    }
}