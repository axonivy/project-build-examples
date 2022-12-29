package ch.ivyteam.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import ch.ivyteam.crm.CustomerRepo;
import ch.ivyteam.ivy.environment.AppFixture;
import ch.ivyteam.ivy.environment.IvyTest;
import crm.Customer;

@IvyTest
class TestCustomerRepo {

  @Test
  void findCustomerByZip(AppFixture fixture) {
	fixture.config("Databases.exampleDb.Url", "jdbc:hsqldb:mem:acmeCRM");
	fixture.config("Databases.exampleDb.Driver", "org.hsqldb.jdbc.JDBCDriver");
	fixture.config("Databases.exampleDb.Username", "");

	CustomerRepo.persist(newCustomer("Caty", "6300"));
    CustomerRepo.persist(newCustomer("Reguel", "6210"));
    CustomerRepo.persist(newCustomer("Reto", "6403"));

    var citizensOfSursee = CustomerRepo.findByZip("6210");
    assertThat(citizensOfSursee).hasSize(1);
    assertThat(citizensOfSursee.get(0).getFirstname()).isEqualTo("Reguel");
  }

  private static Customer newCustomer(String name, String zip) {
    var customer = new Customer();
    customer.setFirstname(name);
    customer.setZip(zip);
    return customer;
  }
}
