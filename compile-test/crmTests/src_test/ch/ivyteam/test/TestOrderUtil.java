package ch.ivyteam.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import ch.ivyteam.crm.OrderUtil;
import ch.ivyteam.ivy.environment.AppFixture;
import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.environment.IvyTest;
import crm.Product;

@IvyTest
public class TestOrderUtil
{

  @Test
  void products()
  {
    assertThat(OrderUtil.getProducts()).hasSize(2);
    Product table = OrderUtil.getProducts().get(0);
    Product chair = OrderUtil.getProducts().get(1);
    assertThat(table.getName()).isEqualTo("Table");
    assertThat(table.getSinglePrice()).isEqualByComparingTo(375.5);
    assertThat(chair.getName()).isEqualTo("Chair");
    assertThat(chair.getSinglePrice()).isEqualByComparingTo(89.60);
  }
  
  @Test
  void products_testEnv(AppFixture fixure)
  {
    fixure.environment("test-env");
    assertThat(OrderUtil.getProducts()).hasSize(2);
    Product table = OrderUtil.getProducts().get(0);
    Product chair = OrderUtil.getProducts().get(1);
    assertThat(table.getSinglePrice()).isEqualByComparingTo(500.0);
    assertThat(chair.getSinglePrice()).isEqualByComparingTo(50.0);
  }
  
  @Test
  void products_langDE()
  {
    Ivy.session().setContentLocale(Locale.GERMAN);
    assertThat(OrderUtil.getProducts()).hasSize(2);
    Product table = OrderUtil.getProducts().get(0);
    Product chair = OrderUtil.getProducts().get(1);
    assertThat(table.getName()).isEqualTo("Tisch");
    assertThat(chair.getName()).isEqualTo("Stuhl");
  }
}
