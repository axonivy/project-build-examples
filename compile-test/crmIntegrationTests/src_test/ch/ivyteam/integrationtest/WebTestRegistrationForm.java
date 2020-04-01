package ch.ivyteam.integrationtest;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.axonivy.ivy.webtest.IvyWebTest;
import com.axonivy.ivy.webtest.engine.EngineUrl;

/**
 * Simple browser-based (selenium) integration test. <br/>
 * Tests the functionality of the Registration
 * <code>crm.CustomerRegistrationForm</code>.
 */
@IvyWebTest
public class WebTestRegistrationForm
{

  @Test
  public void registerNewCustomer()
  {
    //You can use the EngineUrl utility to get to the info page of you engine:
    open(EngineUrl.base());
    
    //Search for the process start link and click it
    $(By.linkText("customer/register.ivp")).shouldBe(visible).click();
    
    //Fill in new customer
    $(By.id("form:firstname")).sendKeys("Unit");
    $(By.id("form:lastname")).sendKeys("Test");
    
    //Check that the submit button is enabled, before click it.
    $(By.id("form:submit")).shouldBe(enabled).click();
    
    //Check that the registration was successful.
    $(By.id("form:newCustomer")).shouldBe(visible, text("Unit Test"));
  }

}
