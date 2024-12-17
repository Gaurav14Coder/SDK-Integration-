Feature: Feature file for adding tags for UI branches that don't need a serenity test


  @sonar @PPE-NONTEST @PPE-99999
  Scenario: New UI Branch that doesn't need any serenity tests
    When a UI Git Branch that doesn't need any serenity tests
    Then the build should not fail because of a missing serenity test
