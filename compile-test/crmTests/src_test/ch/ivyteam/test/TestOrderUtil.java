package ch.ivyteam.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import ch.ivyteam.crm.OrderUtil;
import ch.ivyteam.ivy.environment.AppFixture;
import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.environment.IvyTest;
import crm.Product;

/**
 * Here we are testing the OrderUtil class which uses the Ivy environment.
 * To be able to test the class with conventional JUnit 5 tests we have to
 * annotate our test class with the @IvyTest annotation.
 * @see ch.ivyteam.crm.OrderUtil
 */
@IvyTest
public class TestOrderUtil
{

  /**
   * The @IvyTest annotation ensures that the Ivy environment is properly set up.
   * Without it we wouldn't be able to test the OrderUtil.
   */
  @Test
  void products()
  {
    assertThat(OrderUtil.getProducts()).hasSize(2);
    Product table = OrderUtil.getProducts().get(0);
    Product chair = OrderUtil.getProducts().get(1);
    
    assertThat(table.getName()).isEqualTo("Table");
    assertThat(table.getSinglePrice()).isEqualTo(375.5);
    
    assertThat(chair.getName()).isEqualTo("Chair");
    assertThat(chair.getSinglePrice()).isEqualTo(89.60);
  }
  
  /**
   * This parameterized test uses the AppFixture to set a different
   * ivy environment.
   * @see ch.ivyteam.ivy.environment.AppFixture
   */
  @Test
  void products_testEnv(AppFixture fixture)
  {
    /* We can switch the used environment with the AppFixture. */
    fixture.environment("test-env");
    
    assertThat(OrderUtil.getProducts()).hasSize(2);
    Product table = OrderUtil.getProducts().get(0);
    Product chair = OrderUtil.getProducts().get(1);
    
    /* The test-env provides different values as global variables. */
    assertThat(table.getSinglePrice()).isEqualTo(500.0);
    assertThat(chair.getSinglePrice()).isEqualTo(50.0);
  }
  
  @Test
  void products_globalVariable(AppFixture fixture)
  {
    /* The AppFixture can also manipulate global variables. */
    fixture.var("table", "799.95");
    
    assertThat(OrderUtil.getProducts()).hasSize(2);
    Product table = OrderUtil.getProducts().get(0);
    
    /* The test-env provides different values for the global variables. */
    assertThat(table.getSinglePrice()).isEqualTo(799.95);
  }
  
  @Test
  void products_langDE()
  {
    /* German users want to see the product descriptions in their native language.
     * We can test that by switching the Locale on the session. */
    Ivy.session().setContentLocale(Locale.GERMAN);
    
    assertThat(OrderUtil.getProducts()).hasSize(2);
    Product table = OrderUtil.getProducts().get(0);
    Product chair = OrderUtil.getProducts().get(1);
    
    assertThat(table.getName()).isEqualTo("Tisch");
    assertThat(chair.getName()).isEqualTo("Stuhl");
  }
}
