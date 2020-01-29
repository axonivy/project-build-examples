package ch.ivyteam.test;

import org.junit.jupiter.api.Test;

import com.axonivy.ivy.supplements.IvySelenide;
import com.axonivy.ivy.supplements.engine.EngineUrl;
import com.codeborne.selenide.Selenide;

/**
 * Test class shows how to start a process.
 */
@IvySelenide
public class WebTest
{

  @Test
  void myFirstWebTest()
  {
    //If e.g your start process url looks as follows:
    //http://localhost:8081/ivy/pro/designer/order/16FEC4E2785D3F8D/orderProduct.ivp
    //You can use the EngineUrl Util to start the process:
    Selenide.open(EngineUrl.process() + "/order/16FEC4E2785D3F8D/orderProduct.ivp");
  }
  
}
