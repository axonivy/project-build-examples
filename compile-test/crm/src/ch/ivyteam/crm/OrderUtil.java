package ch.ivyteam.crm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.security.IRole;
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
    IRole role = Ivy.session().getSessionUser().getRoles().get(1);
    return getProducts().stream()
            .filter(prod -> ClearanceLevel.getClearance(role) >= prod.getRequiredClearance())
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
    
    public static int getClearance(IRole role)
    {
      if ("Head".equals(role.getName()))
      {
        return HEAD;
      }
      
      if ("Agent".equals(role.getName()))
      {
        return AGENT;
      }
      return 0;
    }
  }
  
}
