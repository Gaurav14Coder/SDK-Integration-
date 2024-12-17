package com.elsevier.ppe.test.data.service;

import static com.elsevier.ppe.test.utilities.SessionContextStaticWrapper.getTestProperties;

import com.elsevier.ppe.test.data.service.exceptions.ServiceResponseException;
import com.elsevier.ppe.test.utilities.SessionContextStaticWrapper;
import io.restassured.path.json.JsonPath;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;

public class AuthenticationServiceHelper extends ServiceBase {
//
//  private static String user;
//  private static String pass;
//
//
//  @Getter
//  private static String PPE_JWT;
//
//  public static void generatePpeJwt(String username, String password)
//      throws ServiceResponseException {
//    user = username;
//    pass = password;
//    getJwtWithRetries(3);
//  }
//
//
//  private static void getJwtWithRetries(int retries) throws ServiceResponseException {
//
//    Map<String, String> requestBody = new HashMap<>();
//    requestBody.put("username", user);
//    requestBody.put("password", pass);
//
//    try {
//      ResponseEntity<String> restResponse = SessionContextStaticWrapper.getRestTemplate()
//          // .postForEntity(, requestBody, String.class);
//          .getForEntity(getTestProperties().getAuthenticationUrl(), String.class);
//
//
//      if (restResponse.getStatusCode().equals(HttpStatus.OK)) {
//
//        //PPE_JWT = new JsonPath(restResponse.getBody()).getString("jwt");
//        PPE_JWT = "someDummyTokenThisIs";
//
//      } else if (retries > 0) {
//
//        getJwtWithRetries(retries - 1);
//
//      } else {
//
//        throw new ServiceResponseException(
//            "Request returned an error " + restResponse.getStatusCode() + ": " + restResponse
//                .getBody());
//      }
//
//    } catch (ResourceAccessException e) {
//      if (retries == 0) {
//        throw new ServiceResponseException("Connection to auth service failed: " + e.getMessage());
//      } else {
//        getJwtWithRetries(retries - 1);
//      }
//    }
//
//
//  }
}