package ch.ivyteam.test.form;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.axonivy.ivy.supplements.IvySelenide;
import com.axonivy.ivy.supplements.engine.EngineUrl;

/**
 * Simple browser-based (selenium) integration test. <br/>
 * Tests the functionality of the Registration
 * <code>crm.CustomerRegistrationForm</code>.
 */
@IvySelenide
public class WebTestRegistrationForm
{

  @Test
  public void registerNewCustomer()
  {
    open(EngineUrl.base());
    assertThat(title()).contains("ivy");

    $(By.linkText("customer/register.ivp")).click();
    $(By.id("form:firstname")).sendKeys("Unit");
    $(By.id("form:lastname")).sendKeys("Test");
    $(By.id("form")).submit();
  }

}
