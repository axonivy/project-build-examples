package ch.ivyteam.crm;

import java.util.List;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.process.data.persistence.IIvyEntityManager;
import crm.Customer;

public class CustomerRepo
{
  public static Customer persist(Customer newCustomer)
  {
    return entityManager().persist(newCustomer);
  }

  public static List<Customer> getAll()
  {
    return entityManager().findAll(Customer.class);
  }

  private static IIvyEntityManager entityManager()
  {
    return Ivy.persistence().get("erp");
  }

  public static List<Customer> findByZip(String zip)
  {
    return entityManager().createQuery(
            "SELECT c FROM Customer c WHERE c.zip = :zip ")
            .setParameter("zip", zip)
            .getResults();
  }

}
