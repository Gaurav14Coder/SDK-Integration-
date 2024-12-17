package com.elsevier.ppe.test.browserstack;

import com.browserstack.local.Local;
import java.util.HashMap;
import java.util.Map;
import net.thucydides.model.util.EnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserStackHelper {

  private static final Logger LOGGER = LoggerFactory.getLogger(BrowserStackHelper.class);

  private static final Local BS_LOCAL = new Local();
  private static final Thread CLOSE_THREAD = new Thread(() -> {
    try {
      LOGGER.info("Stopping BrowserStackLocal connection...");
      BS_LOCAL.stop();
    } catch (Exception e) {
      LOGGER.error("There was an error stopping BrowserStackLocal: {}", e.getMessage());
    }
  });

  public static void startBrowserStackLocal(EnvironmentVariables environmentVariables)
    throws Exception {
    // Start BrowserStackLocal tunnel if running a BrowserStack test and shutdown after completion
    if (System.getProperty("profileId").contains("browserstack") && !BS_LOCAL.isRunning()) {
      Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);

      LOGGER.info("Starting BrowserStackLocal connection...");

      String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
      if (accessKey == null) {
        accessKey = environmentVariables.getProperty("browserstack.key");
      }

      LOGGER
        .info(
          "browserstack.localIdentifier=" + System.getProperty("browserstack.localIdentifier"));

      Map<String, String> bsLocalArgs = new HashMap<String, String>();
      bsLocalArgs.put("key", accessKey);
      bsLocalArgs.put("onlyAutomate", "");
      bsLocalArgs.put("localIdentifier", System.getProperty("browserstack.localIdentifier"));
      BS_LOCAL.start(bsLocalArgs);
    }
  }
}