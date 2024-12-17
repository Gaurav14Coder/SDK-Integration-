package com.elsevier.ppe.test.steps;

//import com.elsevier.ppe.test.config.ProjectConfiguration;
import com.elsevier.ppe.test.config.RestTemplateConfig;
import com.elsevier.ppe.test.config.TestProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(properties ={"spring.main.allow-bean-definition-overriding=true"})
@TestPropertySource("classpath:bootstrap-${environment}.properties")
@PropertySource({"classpath:application-${environment}.properties"})
@Configuration
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public abstract class StepDefinitionBase {

  public final Logger LOGGER = LoggerFactory.getLogger(getClass());

  @Autowired
  public TestProperties testProperties;

//  @Autowired
//  public ProjectConfiguration projectConfiguration;

  @Lazy
  @Autowired
  public CommonStepDefs commonStepDefs;

  @Autowired
  public RestTemplateConfig restTemplate;

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfig() {
    return new PropertySourcesPlaceholderConfigurer();
  }

}
