package com.elsevier.ppe.test.data;

public interface DataGenerationStrategy {

  String getISSN();

  String getIssuePII();

  String getJournalAcronym();

  void tearDown();

}
