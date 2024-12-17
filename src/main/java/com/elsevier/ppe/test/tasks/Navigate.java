package com.elsevier.ppe.test.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.elsevier.ppe.test.ui.BrowserStackHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.annotations.Step;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

public class Navigate implements Task {

  private BrowserStackHomePage applicationHomePage;
  private String url;

  public Navigate(String url) {
    this.url = url;
  }

  @Override
  @Step("{0} navigates to URL #url")
  public <T extends Actor> void performAs(T theActor) {

    // Slightly different behaviour between IE, Edge and Chrome
    if (System.getProperty("profileId").contains("ie")) {
      SerenityWebdriverManager.inThisTestThread().getCurrentDriver().navigate()
          .to(url);

    } else {
      applicationHomePage.evaluateJavascript("window.location = '" + url + "';");
    }
  }

  public static Navigate toURL(String url) {
    return instrumented(Navigate.class, url);
  }
}
