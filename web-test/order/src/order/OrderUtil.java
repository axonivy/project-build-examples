package order;

import java.util.ArrayList;
import java.util.List;

import ch.ivyteam.ivy.project.demo.ci.order.Product;

public class OrderUtil {

  public static List<Product> getProducts()
  {
    List<Product> products = new ArrayList<>();
    products.add(initProduct("Table", 375.50));
    products.add(initProduct("Chair", 89.60));
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
