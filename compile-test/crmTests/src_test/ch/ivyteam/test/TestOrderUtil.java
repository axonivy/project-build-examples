package ch.ivyteam.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Locale;

import javax.inject.Named;

import org.junit.jupiter.api.Test;

import ch.ivyteam.crm.OrderUtil;
import ch.ivyteam.ivy.environment.AppFixture;
import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.environment.IvyTest;
import ch.ivyteam.ivy.security.IUser;
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
  @SuppressWarnings("removal")
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
     * We can test that by switching the Locale on the session.
     * After the test execution we switch the locale back to its default value. */
    Locale defaultLocale = Ivy.session().getContentLocale();
    try
    {
      Ivy.session().setContentLocale(Locale.GERMAN);

      assertThat(OrderUtil.getProducts()).hasSize(2);
      Product table = OrderUtil.getProducts().get(0);
      Product chair = OrderUtil.getProducts().get(1);

      assertThat(table.getName()).isEqualTo("Tisch");
      assertThat(chair.getName()).isEqualTo("Stuhl");
    }
    finally
    {
      /* Regardless of the tests success or failure we revert the content locale
       * of the session to its default value. */
      Ivy.session().setContentLocale(defaultLocale);
    }
  }

  @Test
  void products_userLogin(AppFixture fixture, @Named("M") IUser user)
  {
    /* Login with a username */
    fixture.loginUser("James Bond");
    var products = OrderUtil.getProductsWithClearance();

    /* James Bond can only order chairs */
    assertThat(products).hasSize(1);
    assertThat(products.get(0).getName()).isEqualTo("Chair");

    /* Login with an IUser object that we injected as a parameter */
    fixture.loginUser(user);
    products = OrderUtil.getProductsWithClearance();

    /* M can order tables and chairs */
    assertThat(products).hasSize(2);
    assertThat(products.get(0).getName()).isEqualTo("Table");
    assertThat(products.get(1).getName()).isEqualTo("Chair");
  }
}
