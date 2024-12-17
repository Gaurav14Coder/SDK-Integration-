package com.elsevier.ppe.test.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionStorage {

  public static final String SPLIT_ITEM_GROUP_WARNING_FLAG = "splitItemGroupWarningIgnored";
  public final Logger LOGGER = LoggerFactory.getLogger(getClass());
  private JavascriptExecutor jsExecutor;
  private WebDriver driver;

  public SessionStorage(WebDriver driver) {
    this.driver = driver;
    this.jsExecutor = (JavascriptExecutor) driver;
  }

  private void setItemInLocalStorage(String item, String value) {
    try {
      LOGGER.info("Adding {} to session storage on URL {}", item, driver.getCurrentUrl());
      jsExecutor.executeScript(String.format(
          "window.sessionStorage.setItem('%s','%s');", item, value));

    } catch (WebDriverException e) {
      LOGGER.error("JavaScript Error: {}", e.getMessage());
    }
  }

  private void removeItemFromSessionStorage(String item) {
    LOGGER.info("Removing {} from session storage on URL {}", item, driver.getCurrentUrl());
    // IE occasionally throws an exception during JavaScript execution
    try {
      jsExecutor.executeScript(String.format(
          "window.sessionStorage.removeItem('%s');", item));

    } catch (WebDriverException e) {
      LOGGER.error("JavaScript Error: {}", e.getMessage());
    }
  }

  public void removeItemGroupWarningFlagFromStorage() {
    removeItemFromSessionStorage(SPLIT_ITEM_GROUP_WARNING_FLAG);
  }

}