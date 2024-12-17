package com.elsevier.ppe.test.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class BrowserStackHomePage extends PageObject {

  private BrowserStackHomePage() {}

  public static final Target BROWSER_STACK_LOGO = Target
      .the("BrowserStack Logo")
      .locatedBy("//a[@class='bstack-mm-logo']");

}
