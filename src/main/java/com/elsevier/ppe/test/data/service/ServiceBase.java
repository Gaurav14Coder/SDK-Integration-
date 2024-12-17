package com.elsevier.ppe.test.data.service;

import com.elsevier.ppe.test.data.service.exceptions.ServiceResponseException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceBase {

  private static final Logger LOGGER = LoggerFactory.getLogger(ServiceBase.class);

  protected static Response getWithRetries(RequestSpecification request, String requestUrl)
      throws ServiceResponseException {
    Response response = null;
    for (int i = 0; i < 5; i++) {
      response = request.get(requestUrl);

      if (response.getStatusCode() == 200) {
        break;

      } else if (response.getStatusCode() == 502 || response.getStatusCode() == 504) {
        LOGGER.warn("Received HTTP {}: {} from {}. Retrying...",
            response.getStatusCode(), response.prettyPrint(), requestUrl);

        try {
          Thread.sleep(30000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      } else {
        throw new ServiceResponseException(
            "Request returned an error " + response.getStatusCode() + ": " + response
                .prettyPrint());
      }
    }
    return response;
  }

}
