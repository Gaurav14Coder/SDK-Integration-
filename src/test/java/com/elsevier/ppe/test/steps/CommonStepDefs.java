package com.elsevier.ppe.test.steps;


import static com.elsevier.ppe.test.ui.BrowserStackHomePage.BROWSER_STACK_LOGO;
import static com.elsevier.ppe.test.utilities.SessionContextStaticWrapper.getTestProperties;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import com.elsevier.ppe.test.browserstack.BrowserStackHelper;
import com.elsevier.ppe.test.config.Environment;
import com.elsevier.ppe.test.data.service.AuthenticationServiceHelper;
import com.elsevier.ppe.test.exceptions.DriverRequiresResetException;
import com.elsevier.ppe.test.exceptions.ItemNotFoundException;
import com.elsevier.ppe.test.tasks.NavigateAway;
import com.elsevier.ppe.test.utilities.LocalStorage;
import com.elsevier.ppe.test.utilities.SessionStorage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
 import io.cucumber.java.en.Given;
 import io.cucumber.java.en.Then;
 import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import net.thucydides.core.webdriver.WebdriverManager;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.springframework.stereotype.Component;

@Component
public class CommonStepDefs extends StepDefinitionBase {

  private EnvironmentVariables envVariables = SystemEnvironmentVariables
      .createEnvironmentVariables();

  @Before
  public void set_the_stage(Scenario scenario) throws Exception {

    Serenity.setSessionVariable("scenario").to(scenario.getName());

//    AuthenticationServiceHelper.generatePpeJwt(projectConfiguration.getLdapUsername(),
//        projectConfiguration.getLdapPassword());
//
//    if ((getTestProperties().getEnvironment().equals(Environment.LOCAL.getValue())
//        || getTestProperties().isLocalWebapp()) &&
//        System.getProperty("profileId").contains("browserstack")) {
//      BrowserStackHelper.startBrowserStackLocal(envVariables);
//    }

    OnStage.setTheStage(new OnlineCast()).shineSpotlightOn("Joan");

    setupBrowserWithRetries(8);
  }


  private void setupBrowserWithRetries(int retryCount) throws ItemNotFoundException {
    try {
      addBrowserStorageTokens();
    } catch (DriverRequiresResetException e) {
      resetWebDriver();
      if (retryCount > 0) {
        try {
          Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        setupBrowserWithRetries(--retryCount);
      } else {
        throw new RuntimeException("Failed to assign PPE Jwt to browser");
      }
    }
  }

  private void resetWebDriver() {
    WebdriverManager webdriverManager = Serenity.getWebdriverManager();
    webdriverManager.clearCurrentDriver();
    webdriverManager.getWebdriver();
  }

  private void addBrowserStorageTokens()
      throws ItemNotFoundException, DriverRequiresResetException {
//    new LocalStorage(
//        SerenityWebdriverManager.inThisTestThread().getCurrentDriver())
//        .addPpeJwtToLocalPPEStorage();

    new SessionStorage(SerenityWebdriverManager.inThisTestThread().getCurrentDriver())
        .removeItemGroupWarningFlagFromStorage();
  }

  @After
  public void tearDown() {
//    new LocalStorage(
//        SerenityWebdriverManager.inThisTestThread().getCurrentDriver())
//        .removePpeJwtFromStorage();

    new SessionStorage(SerenityWebdriverManager.inThisTestThread().getCurrentDriver())
        .removeItemGroupWarningFlagFromStorage();

  }

  @Given("^Joan has done prerequisites$")
  public void joanHasDonePrerequisites() {
  }


  @When("^she is viewing the web page$")
  public void sheIsViewingTheWebPage() {
    theActorInTheSpotlight().attemptsTo(
        NavigateAway.ppeSession("https://www.browserstack.com/"));
  }


  @Then("^the page is displayed$")
  public void thePageIsDisplayed() {
    theActorInTheSpotlight().should(seeThat(the(BROWSER_STACK_LOGO), isVisible()));
  }
}