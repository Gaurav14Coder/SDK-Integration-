package com.elsevier.ppe.test.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class CloudProperties {

  private String url;
  private String driver;
  private String username;
  private String password;
  private String ldapStandardUsername;
  private String ldapStandardPassword;
  private String ldapFeatureUsername;
  private String ldapFeaturePassword;
  private String ldapUnauthorisedUsername;
  private String ldapUnauthorisedPassword;
}
