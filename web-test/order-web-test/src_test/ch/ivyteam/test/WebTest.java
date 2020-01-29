package ch.ivyteam.test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.axonivy.ivy.supplements.IvySelenide;
import com.axonivy.ivy.supplements.engine.EngineUrl;

/**
 * Test class shows how to test a basic process.
 */
@IvySelenide
public class WebTest
{

  @Test
  void myFirstWebTest()
  {
    //If e.g your start process url looks as follows:
    //http://localhost:8081/ivy/pro/designer/order/16FF0CCD2C4FE02D/start.ivp
    //You can use the EngineUrl Util to start the process:
    open(EngineUrl.process() + "/order/16FF0CCD2C4FE02D/start.ivp");
    
    //Check that the input field is visible, before clear it and add fill in some data.
    String input = "I'm a test";
    $(By.id("form:input")).shouldBe(visible).clear();
    $(By.id("form:input")).sendKeys(input);
    
    //Check that the submit button is enabled, before click it.
    $(By.id("form:submit")).shouldBe(enabled).click();
    
    //Check that the input was successful.
    $(By.id("form:check")).shouldBe(exactText(input));
  }
  
}
