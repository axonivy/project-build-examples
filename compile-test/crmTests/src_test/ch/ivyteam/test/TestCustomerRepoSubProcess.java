package ch.ivyteam.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.ivyteam.crm.mocks.CustomerServiceMock;
import ch.ivyteam.ivy.bpm.engine.client.BpmClient;
import ch.ivyteam.ivy.bpm.engine.client.ExecutionResult;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmElement;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmProcess;
import ch.ivyteam.ivy.bpm.exec.client.IvyProcessTest;
import ch.ivyteam.ivy.environment.AppFixture;
import crm.Customer;
import util.customerRepoData;

@IvyProcessTest
public class TestCustomerRepoSubProcess {

  private static final BpmProcess CUSTOMER_REPO = BpmProcess.name("customerRepo"); // see crm:Processes/util

  @BeforeEach
  void setup(AppFixture fixture) {
    // changes the rest-client called 'customer-service', defined in the 'crm' project.
    fixture.config("RestClients.customer-service.Url", CustomerServiceMock.URI);
    // the config key is the YAML path to any configuration:
    // therefore also Features or Properties of RestClients can be changed with the config API.
  }

  /**
   * Testing SubProcesses, rather than full Business Processes is best practice: <br/>
   * - it reduces the scope of your test: clear in/out and less infrastructure to setup <br/>
   * - it drives a component driven architecture, and makes your processes therefore easier to re-use <br/>
   */
  @Test
  void callSubProcess_findCustomer(BpmClient bpmClient) {
    BpmElement FIND_CUSTOMER = CUSTOMER_REPO.elementName("findCustomer(String)");
    ExecutionResult result = bpmClient.start()
      .subProcess(FIND_CUSTOMER)
      .withParam("name", "Wermelinger")
      .execute();
    customerRepoData data = result.data().last();
    Customer match = data.getCustomer();
    assertThat(match.getZip()).isEqualTo("CH-6300");
  }

  @Test
  void callSubProcess_findErpCustomer(BpmClient bpmClient, AppFixture fixture) {
    useInMemoryDb(fixture);

    var rew = new Customer();
    rew.setFirstname("Reguel");
    rew.setLastname("Wermelinger");
    storeToDb(bpmClient, rew);

    Customer match = findFromDb(bpmClient, rew.getLastname()).getCustomer();
    assertThat(match.getFirstname())
      .isEqualTo(rew.getFirstname());
  }

  /**
   * Mocks the DB under test in 'crm' project, with a volatile inMemory-db
   */
  private static void useInMemoryDb(AppFixture fixture) {
    String db = "Databases.exampleDb";
    fixture.config(db + ".Driver", "org.hsqldb.jdbc.JDBCDriver");
    fixture.config(db + ".Url", "jdbc:hsqldb:mem:acmeCRM");
  }

  private static void storeToDb(BpmClient bpmClient, Customer customer) {
    BpmElement STORE_DB_CUSTOMER = CUSTOMER_REPO.elementName("store(Customer)");
    bpmClient.start()
      .subProcess(STORE_DB_CUSTOMER)
      .withParam("customer", customer)
      .execute();
  }

  private static customerRepoData findFromDb(BpmClient bpmClient, String name) {
    BpmElement FIND_DB_CUSTOMER = CUSTOMER_REPO.elementName("findErpCustomer(String)");
    ExecutionResult result = bpmClient.start()
      .subProcess(FIND_DB_CUSTOMER)
      .withParam("name", name)
      .execute();
    return result.data().last();
  }

}
