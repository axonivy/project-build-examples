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
import util.customerRepoData;

@IvyProcessTest
public class TestCustomerRepoSubProcess {

  private static final BpmProcess CUSTOMER_REPO = BpmProcess.name("customerRepo"); // see crm:Processes/util

  private interface Start {
    BpmElement FIND_CUSTOMER = CUSTOMER_REPO.elementName("findCustomer(String)");
  }

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
    ExecutionResult result = bpmClient.start()
      .subProcess(Start.FIND_CUSTOMER)
      .withParam("name", "Wermelinger")
      .execute();
    customerRepoData data = result.data().last();
    assertThat(data.getMatch()).isNotNull();
  }

}
