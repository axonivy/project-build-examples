package ch.ivyteam.test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import com.axonivy.ivy.supplements.IvySelenide;
import com.axonivy.ivy.supplements.engine.EngineUrl;
import com.axonivy.ivy.supplements.primeui.tester.PrimeUi;
import com.axonivy.ivy.supplements.primeui.tester.widget.SelectOneMenu;
import com.codeborne.selenide.*;

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
  
  /**
   * Show how the different selectors can be used.
   * Be aware that if you use the css selector with JSF you need to write "\\:" instead of ":".
   * @see Selenide#$(String)
   * @see Selenide#$(String, int)
   * @see Selenide#$(By)
   * @see Selenide#$(By, int)
   * @see Selenide#$$(String)
   * @see Selenide#$$(By)
   */
  @Test
  void showSelectorPossibilities()
  {
    addProductToOrder("Table", 1);
    addProductToOrder("Table", 1);
    addProductToOrder("Table", 1);
    addProductToOrder("Chair", 1);
    addProductToOrder("Chair", 1);
    
    //single element with css selector
    $("#form").shouldBe(visible);          //by id
    $("form").shouldBe(visible);           //by tag
    $(".ui-datatable").shouldBe(visible);  //by class
    $x("//form").shouldBe(visible);        //by xpath
    //single element with By selector
    $(By.id("form")).shouldBe(visible);
    $(By.tagName("form")).shouldBe(visible);
    $(By.className("ui-datatable")).shouldBe(visible);
    $(By.xpath("//form")).shouldBe(visible);
    
    //nth element of multiple
    $("label", 2).shouldHave(text("Amount"));
    $(By.tagName("label"), 3).shouldHave(text("Single Price"));
    
    //all elements with css selector
    $$("label").shouldHave(size(4));           //by tag
    $$(".ui-outputlabel").shouldHave(size(3)); //by class
    $$x("//label").shouldHave(size(4));        //by xpath
    //all elements with By selector
    $$(By.tagName("label")).shouldHave(size(4));
    $$(By.className("ui-outputlabel")).shouldHave(size(3));
    $$(By.xpath("//label")).shouldHave(size(4));
    
    //complex css selectors
    //single element css class inside id
    $("#form\\:amount .ui-inputfield").shouldHave(value("1"));
    $(By.id("form:amount")).find(By.className("ui-inputfield")).shouldHave(value("1"));
    //all labels inside id
    $$("#form\\:orderTable tbody tr").shouldHave(size(5));
    $(By.id("form:orderTable")).find(By.tagName("tbody")).findAll(By.tagName("tr")).shouldHave(size(5));
    //all table rows which contains "Table"
    $$("tbody tr").filter(text("Table")).shouldHave(sizeGreaterThanOrEqual(3));
    $(By.tagName("tbody")).findAll("tr").filter(text("Chair")).shouldHave(sizeLessThanOrEqual(2));
  }
  
  /**
   * show possible assertions/conditions which can be tested.
   * @see SelenideElement#should(Condition...)
   * @see ElementsCollection#shouldBe(CollectionCondition...)
   */
  @Test
  void showAssertionPossibilities()
  {
    //assertions can have multiple conditions or they can be stacked
    $(By.id("form:addProduct")).shouldBe(visible, exist);
    $(By.id("form:addProduct")).shouldBe(visible).should(exist);
    //you can create conditions for your need
    Condition clickable = and("should be clickable", visible, exist);
    $(By.id("form:addProduct")).shouldBe(clickable);
    //they can be inverted
    $(By.id("notExistingElement")).shouldNotBe(exist);
    $(By.id("notExistingElement")).shouldBe(not(exist));
    //they can exist but are hidden
    $(By.id("form:product_input")).should(exist, not(visible));
    $(By.id("form:product_input")).shouldBe(hidden);
    
    //conditions on multiple elements
    $$(By.className("ui-outputlabel")).shouldBe(texts("Product", "Amount", "Single Price"));
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
