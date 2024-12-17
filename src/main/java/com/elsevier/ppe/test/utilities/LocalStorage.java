package com.elsevier.ppe.test.utilities;


import static com.elsevier.ppe.test.utilities.SessionContextStaticWrapper.getTestProperties;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.elsevier.ppe.test.data.service.AuthenticationServiceHelper;
import com.elsevier.ppe.test.exceptions.DriverRequiresResetException;
import com.elsevier.ppe.test.exceptions.ItemNotFoundException;
import com.elsevier.ppe.test.tasks.NavigateAway;
import java.util.Optional;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalStorage {
//
//  public static final String PPE_JWT = "ppeJwt";
//  public final Logger LOGGER = LoggerFactory.getLogger(getClass());
//  private JavascriptExecutor jsExecutor;
//  private WebDriver driver;
//
//  public LocalStorage(WebDriver driver) {
//    this.driver = driver;
//    this.jsExecutor = (JavascriptExecutor) driver;
//  }
//
//  private void setItemInLocalStorage(String item, String value) throws DriverRequiresResetException {
//    try {
//      LOGGER.info("Adding {} to local storage on URL {}", item, driver.getCurrentUrl());
//      jsExecutor.executeScript(String.format(
//          "window.localStorage.setItem('%s','%s');", item, value));
//
//    } catch (WebDriverException e) {
//      LOGGER.error("Error occurred while setting JWT to local storage, {}", e.getMessage());
//      try {
//        Thread.sleep(500);
//      } catch (InterruptedException ex) {
//
//      }
//      throw new DriverRequiresResetException();
//    }
//  }
//
//  private void removeItemFromLocalStorage(String item) {
//    LOGGER.info("Removing {} from local storage on URL {}", item, driver.getCurrentUrl());
//    // IE occasionally throws an exception during JavaScript execution
//    try {
//    jsExecutor.executeScript(String.format(
//          "window.localStorage.removeItem('%s');", item));
//    // ((WebStorage) driver).getLocalStorage().removeItem(item);
//
//    } catch (WebDriverException e) {
//      LOGGER.error("JavaScript Error removeItemFromLocalStorage: {}", e.getMessage());
//      try {
//        Thread.sleep(500);
//      } catch (InterruptedException ex) {
//      }
//    }
//  }
//
//  private void removeItemWithRetryFromLocalStorage(String item, int retryCount){
//    do{
//      removeItemFromLocalStorage(item);
//      LOGGER.info("Removing Item from Local Strorage Retry: " + retryCount);
//    }while(getPpeJwtFromStorage().isPresent() && retryCount-- > 0);
//  }
//
//  public void addPpeJwtToLocalPPEStorage()
//      throws ItemNotFoundException, DriverRequiresResetException {
//    removeItemWithRetryFromLocalStorage(PPE_JWT,8);
//    theActorInTheSpotlight().attemptsTo(
//        NavigateAway.ppeSession(getTestProperties().getPpeWebAppUrl()));
//
//    setJwtWithRetries(8);
//  }
//
//  private void setJwtWithRetries(int retryCount)
//      throws ItemNotFoundException, DriverRequiresResetException {
//    do {
//      setItemInLocalStorage(PPE_JWT, AuthenticationServiceHelper.getPPE_JWT());
//    }
//    while (!getPpeJwtFromStorage().isPresent() && retryCount-- > 0);
//
//    if (!getPpeJwtFromStorage().isPresent()) {
//      throw new ItemNotFoundException("Could not locate ppeJwt in browser");
//    }
//  }
//
//  public void removePpeJwtFromStorage() {
//    removeItemWithRetryFromLocalStorage(PPE_JWT,8);
//  }
//
//  public Optional<String> getPpeJwtFromStorage() {
//    Optional<String> ppeJwt = Optional.empty();
//    try {
//      LOGGER.info("Getting {} from local storage on URL {}", PPE_JWT, driver.getCurrentUrl());
//      String ppeJwtFromBroswer = (String) jsExecutor.executeScript(String.format(
//          "return window.localStorage.getItem('%s');", PPE_JWT));
//
//      ppeJwt = Optional.ofNullable(ppeJwtFromBroswer);
//
//    } catch (WebDriverException e) {
//      LOGGER.error("JavaScript Error: {}", e.getMessage());
//    } finally {
//      return ppeJwt;
//    }
//
//
//  }

}