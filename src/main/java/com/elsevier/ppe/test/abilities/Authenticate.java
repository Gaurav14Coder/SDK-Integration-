package com.elsevier.ppe.test.abilities;

import net.serenitybdd.screenplay.Actor;

public class Authenticate implements net.serenitybdd.screenplay.Ability {

  private final String username;
  private final String password;

  public static Authenticate with(
      String username,
      String password) {
    return new Authenticate(username, password);
  }

  public static Authenticate as(Actor actor) {
    return actor.abilityTo(Authenticate.class);
  }

  public String username() {
    return this.username;
  }

  public String password() {
    return this.password;
  }

  private Authenticate(String username, String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public String toString() {
    return "Authenticate with credentials";
  }
}