package com.elsevier.ppe.test.utilities;

//import com.elsevier.ppe.test.config.ProjectConfiguration;
import com.elsevier.ppe.test.config.TestProperties;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SessionContextStaticWrapper {

  private static TestProperties testProperties;
//  private static ProjectConfiguration projectConfiguration;
  private static RestTemplate restTemplateConfig;

  @Autowired
  private TestProperties testProps;

//  @Autowired
//  private ProjectConfiguration projectConfig;

  @Autowired
  private RestTemplate restTemplate;

  @PostConstruct
  private void initStaticTestProperties() {
    testProperties = this.testProps;
 //   projectConfiguration = this.projectConfig;
    restTemplateConfig = this.restTemplate;

  }

  public static TestProperties getTestProperties() {
    return testProperties;
  }

//  public static ProjectConfiguration getProjectConfiguration() {
//    return projectConfiguration;
//  }


  public static RestTemplate getRestTemplate() {
    return restTemplateConfig;
  }



}
