package ch.ivyteam.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import ch.ivyteam.crm.CustomerRepo;
import ch.ivyteam.ivy.environment.AppFixture;
import ch.ivyteam.ivy.environment.IvyTest;
import crm.Customer;

@IvyTest
public class TestCustomerRepo
{
  @SuppressWarnings("removal")
  @Test
  public void findCustomerByZip(AppFixture fixture)
  {
    fixture.environment("test-env");

    CustomerRepo.persist(newCustomer("Caty", "6300"));
    CustomerRepo.persist(newCustomer("Reguel", "6210"));
    CustomerRepo.persist(newCustomer("Reto", "6403"));

    List<Customer> citizensOfSursee = CustomerRepo.findByZip("6210");
    assertThat(citizensOfSursee).hasSize(1);
    assertThat(citizensOfSursee.get(0).getFirstname()).isEqualTo("Reguel");
  }

  private static Customer newCustomer(String name, String zip)
  {
    Customer customer = new Customer();
    customer.setFirstname(name);
    customer.setZip(zip);
    return customer;
  }
}
