package com.elsevier.ppe.test.config;

import static com.elsevier.ppe.test.utilities.SessionContextStaticWrapper.getTestProperties;



import lombok.Getter;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

//@Configuration
//public class ProjectConfiguration implements DisposableBean {
//
//  private static final Logger LOGGER = LoggerFactory.getLogger(ProjectConfiguration.class);
//
//
//  private String ldapUsername;
//  private String ldapPassword;
//
//  @Autowired
//  Environment env;
//
//  @EventListener(ApplicationReadyEvent.class)
//  public void doSomethingAfterStartup() {
//    CloudProperties cloudProperties = new CloudProperties(
//        env.getProperty("db.url"),
//        env.getProperty("db.driver"),
//        env.getProperty("db.username"),
//        env.getProperty("db.password"),
//        env.getProperty("ldap.standard.username"),
//        env.getProperty("ldap.standard.password"),
//        env.getProperty("ldap.feature.username"),
//        env.getProperty("ldap.feature.password"),
//        env.getProperty("ldap.unauthorised.username"),
//        env.getProperty("ldap.unauthorised.password")
//    );
//
//
//    if (!getTestProperties().isLocalWebapp()) {
//      // Set the correct LDAP username and password to use based on the build type
//      if (getTestProperties().isFeatureToggle()) {
//        ldapUsername = cloudProperties.getLdapFeatureUsername();
//        ldapPassword = cloudProperties.getLdapFeaturePassword();
//      } else {
//        ldapUsername = cloudProperties.getLdapStandardUsername();
//        ldapPassword = cloudProperties.getLdapStandardPassword();
//      }
//
//    } else {
//      ldapUsername = "testuser";
//      ldapPassword = RandomStringUtils.random(8, true, false);
//    }
//
//    // Required otherwise you get an error when trying to access the clipboard
//    System.setProperty("java.awt.headless", "false");
//  }
//
//
//  public String getLdapUsername() {
//    return ldapUsername;
//  }
//
//  public String getLdapPassword() {
//    return ldapPassword;
//  }
//
//
//  public void destroy() {
//
//  }
//}