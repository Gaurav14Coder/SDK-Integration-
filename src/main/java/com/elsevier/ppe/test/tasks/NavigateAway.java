package com.elsevier.ppe.test.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NavigateAway implements Task {

  public final Logger LOGGER = LoggerFactory.getLogger(getClass());

  private String url;

  public NavigateAway(String url) {
    this.url = url;
  }

  @Override
  @Step("{0} Logs out and clears previous session")
  public <T extends Actor> void performAs(T theActor) {
    // Handle any unsaved alert warnings
    theActor.attemptsTo(Navigate.toURL(url));

  }

  public static NavigateAway ppeSession(String url) {
    return instrumented(NavigateAway.class, url);
  }
}
