package ch.ivyteam.crm;

import java.util.ArrayList;
import java.util.List;

import ch.ivyteam.ivy.environment.Ivy;
import crm.Product;

public class OrderUtil {

  public static List<Product> getProducts()
  {
    List<Product> products = new ArrayList<>();
    products.add(initProduct(Ivy.cms().co("/Project/Products/Table"), Double.parseDouble(Ivy.var().get("table"))));
    products.add(initProduct(Ivy.cms().co("/Project/Products/Chair"), Double.parseDouble(Ivy.var().get("chair"))));
    return products;
  }
  
  private static Product initProduct(String name, double price)
  {
    Product product = new Product();
    product.setName(name);
    product.setSinglePrice(price);
    return product;
  }
  
}
