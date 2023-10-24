package ch.ivyteam.integrationtest;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.axonivy.ivy.webtest.IvyWebTest;
import com.axonivy.ivy.webtest.engine.EngineUrl;
import com.axonivy.ivy.webtest.engine.WebAppFixture;
import com.axonivy.ivy.webtest.primeui.PrimeUi;
import com.axonivy.ivy.webtest.primeui.widget.SelectOneMenu;

@IvyWebTest
public class WebTestOrderFormFixtureIT {

  @BeforeEach
  void init(WebAppFixture fixture) {
    fixture.var("table", "1000");
  }

  @AfterEach
  void cleanup(WebAppFixture fixture) {
    fixture.resetVar("table");
  }

  @Test
  void testPriceUpdateAfterProductChanges_updateVars() {
    open(EngineUrl.createProcessUrl("/crm/1700F6B9A99952AD/orderProduct.ivp"));
    SelectOneMenu product = PrimeUi.selectOne(By.id("form:product"));
    product.selectItemByLabel("Table");
    $(By.id("form:price")).shouldBe(exactText("1000.0"));
  }
}
