package com.elsevier.ppe.test.data;


//import com.elsevier.ppe.test.config.ProjectConfiguration;
import com.elsevier.ppe.test.data.service.exceptions.ServiceResponseException;
import java.io.IOException;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;

public class DynamicDataGenerationStrategy {

//  @Autowired
//  public ProjectConfiguration projectConfiguration;

  private String issuePII;

  public DynamicDataGenerationStrategy()
      throws IOException, SQLException, ServiceResponseException {

  }

}
