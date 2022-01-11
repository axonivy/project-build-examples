package ch.ivyteam.crm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ch.ivyteam.ivy.environment.Ivy;
import crm.Product;

public class OrderUtil
{
  public static List<Product> getProducts()
  {
    List<Product> products = new ArrayList<>();
    products.add(initProduct(Ivy.cms().co("/Project/Products/Table"), Double.parseDouble(Ivy.var().get("table")), ClearanceLevel.HEAD));
    products.add(initProduct(Ivy.cms().co("/Project/Products/Chair"), Double.parseDouble(Ivy.var().get("chair")), ClearanceLevel.AGENT));
    return products;
  }

  public static List<Product> getProductsWithClearance()
  {
    return getProducts().stream()
            .filter(prod -> ClearanceLevel.getClearance() >= prod.getRequiredClearance())
            .collect(Collectors.toList());
  }

  private static Product initProduct(String name, double price, int clearance)
  {
    Product product = new Product();
    product.setName(name);
    product.setSinglePrice(price);
    product.setRequiredClearance(clearance);
    return product;
  }

  public static class ClearanceLevel
  {
    public static int HEAD = 3;
    public static int AGENT = 1;
    public static int NO_CLEARANCE = 0;

    public static int getClearance()
    {
      if (Ivy.session().has().role("Head"))
      {
        return HEAD;
      }
      if (Ivy.session().has().role("Agent"))
      {
        return AGENT;
      }
      return NO_CLEARANCE;
    }
  }

}
