package ch.ivyteam.test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import com.axonivy.ivy.supplements.IvySelenide;
import com.axonivy.ivy.supplements.engine.EngineUrl;
import com.axonivy.ivy.supplements.primeui.tester.PrimeUi;
import com.axonivy.ivy.supplements.primeui.tester.widget.SelectOneMenu;

@IvySelenide(headless = false)
public class WebTestOrder
{
  
  @BeforeEach
  void startProcess()
  {
    //Start orderProduct process
    open(EngineUrl.process() + "/order/16FEC4E2785D3F8D/orderProduct.ivp");
  }

  @Test
  void testPriceUpdateAfterProductChanges()
  {
    //Use Testutil for PrimeFaces SelectOneMenu provided by the primeui-tester
    SelectOneMenu product = PrimeUi.selectOne(By.id("form:product"));
    //Check price for table
    product.selectItemByLabel("Table");
    $(By.id("form:price")).shouldBe(exactText("375.5"));
    //Select chair and check price has changed
    product.selectItemByLabel("Chair");
    $(By.id("form:price")).shouldBe(exactText("89.6"));
  }
  
  @Test
  void testAmountInputCanOnlyBeNumbersTo100()
  {
    //Test init value of amount
    $(By.id("form:amount_input")).shouldBe(exactValue("1"));
    //Test that only numbers to 100 can be placed into the amount input
    $(By.id("form:amount_input")).clear();
    $(By.id("form:amount_input")).sendKeys("100");
    $(By.id("form:amount_input")).shouldBe(exactValue("100"));
    $(By.id("form:amount_input")).clear();
    $(By.id("form:amount_input")).sendKeys("101");
    $(By.id("form:amount_input")).shouldBe(exactValue("10"));
  }
  
  @Test
  void testProductCanBeAdded()
  {
    orderIsEmpty();
    addProductToOrder("Table", 1);
    orderContains("Table");
  }
  
  @Test
  void testMultipleProductsCanBeAdded()
  {
    orderIsEmpty();
    addProductToOrder("Table", 1);
    addProductToOrder("Chair", 1);
    orderContains("Table");
    orderContains("Chair");
  }
  
  @Test
  void testPriceIsMultipliedByAmount()
  {
    addProductToOrder("Chair", 4);
    String expectedPrice = String.valueOf(4 * 89.6);
    orderContains("Chair");
    orderContains("4");
    orderContains(expectedPrice);
  }
  
  private void addProductToOrder(String product, int amount)
  {
    //Use Testutil for PrimeFaces SelectOneMenu provided by the primeui-tester
    PrimeUi.selectOne(By.id("form:product")).selectItemByLabel(product);
    //Set amount
    $(By.id("form:amount_input")).clear();
    $(By.id("form:amount_input")).sendKeys(String.valueOf(amount));
    //Add product to order
    $(By.id("form:addProduct")).click();
  }
  
  private void orderIsEmpty()
  {
    orderContains("No records found.");
  }
  
  private void orderContains(String contains)
  {
    //Use Testutil for PrimeFaces DataTable provided by the primeui-tester
    PrimeUi.table(By.id("form:orderTable")).contains(contains);
  }
}
