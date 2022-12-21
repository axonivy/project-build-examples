package ch.ivyteam.test;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Named;

import org.junit.jupiter.api.Test;

import ch.ivyteam.ivy.bpm.engine.client.BpmClient;
import ch.ivyteam.ivy.bpm.engine.client.ExecutionResult;
import ch.ivyteam.ivy.bpm.engine.client.History;
import ch.ivyteam.ivy.bpm.engine.client.Workflow;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmElement;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmProcess;
import ch.ivyteam.ivy.bpm.exec.client.IvyProcessTest;
import ch.ivyteam.ivy.security.IUser;
import ch.ivyteam.ivy.workflow.CaseState;
import ch.ivyteam.ivy.workflow.TaskState;
import crm.Order;

@IvyProcessTest
public class TestInvoiceProcess {

  /* The process under test */
  private static final BpmProcess INVOICE_PROCESS = BpmProcess.name("invoice");

  /* The process start elements */
  private static final BpmElement WRITE_INVOICE_START = INVOICE_PROCESS.elementName("writeInvoice.ivp");
  private static final BpmElement WRITE_INVOICE = INVOICE_PROCESS.elementName("write invoice");
  private static final BpmElement CHECK_ORDER_START = INVOICE_PROCESS.elementName("checkOrder.ivp");

  @Test
  void writeInvoice(BpmClient bpmClient) {
    /* Executing the write invoice process */
    ExecutionResult result = bpmClient
            .start()
            .process(WRITE_INVOICE_START)
            .execute();

    /*
     * The execution should have ran exactly two elements; the RequestStart and
     * UserTask
     */
    History history = result.history();
    assertThat(history.elementNames()).containsExactly("writeInvoice.ivp", "write invoice");

    /* The last executed task should be the RequestStart task */
    Workflow workflow = result.workflow();
    assertThat(workflow.executedTask().getName()).isEqualTo("start write invoice");

    /* Mock the UI part of the UserTask by setting the UI result */
    bpmClient.mock().uiOf(WRITE_INVOICE).with((params, results) -> results.set("total", 935));

    /*
     * Drive the process further through the UserTask by telling the BpmClient
     * hat it should execute the next task with the role everybody
     */
    result = bpmClient
            .start()
            .anyActiveTask(result)
            .as().everybody()
            .execute();

    /* This time the execution should have ran until the end of the process */
    history = result.history();
    assertThat(history.elementNames()).containsExactly("write invoice", "end");

    /* Asserting the data of the last execution */
    Order orderData = result.data().last();
    assertThat(orderData.getTotal()).isEqualTo(935);

    /* The process is finished and therefore the workflow case should be done */
    workflow = result.workflow();
    assertThat(workflow.activeCase().getState()).isEqualTo(CaseState.DONE);
  }

  @Test
  void checkOrder(BpmClient bpmClient) {
    /* Mocking the return value of a html dialog */
    bpmClient.mock()
            .element(INVOICE_PROCESS.elementName("check order"))
            .with(Order.class, (in, out) -> out.setValid(Boolean.TRUE));

    ExecutionResult result = bpmClient
            .start()
            .process(CHECK_ORDER_START)
            .execute();

    /* Asserting the data of the last execution */
    Order orderData = result.data().last();
    assertThat(orderData.getValid()).isTrue();
  }

  @Test
  @SuppressWarnings("unused")
  void select(BpmClient bpmClient) {
    /* Selecting processes */
    BpmProcess byName = BpmProcess.name("invoice");
    BpmProcess byNameSelector = BpmProcess.name().startsWith("invo");

    /* Selecting process elements */
    BpmElement byEleName = INVOICE_PROCESS.elementName("write invoice");
    BpmElement byEleNameSelector = INVOICE_PROCESS.element().name().contains("write");
  }

  @Test
  @SuppressWarnings("unused")
  void as(BpmClient bpmClient) {
    /* Execution with the role everybody */
    ExecutionResult result = bpmClient.start()
            .process(WRITE_INVOICE_START)
            .as().everybody()
            .execute();

    /* Execution with a specific user */
    result = bpmClient.start()
            .process(WRITE_INVOICE_START)
            .as().user("James Bond")
            .execute();

    /* Execution by selecting a specific role */
    result = bpmClient.start()
            .process(WRITE_INVOICE_START)
            .as().role("Everybody")
            .execute();
  }

  @Test
  void start(BpmClient bpmClient) {
    bpmClient.mock().uiOf(WRITE_INVOICE).withNoAction();

    ExecutionResult result = bpmClient
            .start().process(WRITE_INVOICE_START)
            .execute();

    /* Execute any active task after the previous result */
    bpmClient.start().anyActiveTask(result).as().everybody().execute();

    result = bpmClient
            .start().process(WRITE_INVOICE_START)
            .execute();

    /* Execute the desired task */
    bpmClient.start().task(result.workflow().anyActiveTask()).as().everybody().execute();
  }

  @Test
  void workflow(BpmClient bpmClient, @Named("James Bond") IUser user) {
    BpmElement prepareShipmentStart = INVOICE_PROCESS.elementName("prepareShipment.ivp");

    ExecutionResult result = bpmClient
            .start().process(prepareShipmentStart)
            .as().user(user)
            .execute();

    /* Asserting case and task states */
    assertThat(result.workflow().activeCase().getState()).isEqualTo(CaseState.RUNNING);
    assertThat(result.workflow().executedTask().getState()).isEqualTo(TaskState.DONE);

    /* Asserting if any active tasks are present */
    assertThat(result.workflow().anyActiveTask()).isPresent();
    assertThat(result.workflow().activeTasks()).hasSize(1);
    assertThat(result.workflow().activeTask().name("prepare shipment")).isPresent();
    assertThat(result.workflow().activeTask().name().startsWith("prepare")).isPresent();

    /* Asserting the activator */
    assertThat(result.workflow().activeTask().activatorUser("James Bond")).isPresent();
    assertThat(result.workflow().activeTask().activator(user)).isPresent();

    /* Asserting the session user */
    assertThat(result.workflow().session().getSessionUserName()).isEqualTo("James Bond");
  }

  @Test
  void history(BpmClient bpmClient) {
    ExecutionResult result = bpmClient
            .start().process(WRITE_INVOICE_START)
            .execute();

    /* Assert that a specific element has been executed */
    assertThat(result.history().elements()).contains(WRITE_INVOICE_START);

    /* Assert that the elements with the given names have been executed */
    assertThat(result.history().elementNames()).contains("writeInvoice.ivp", "write invoice");
  }

  @Test
  void data(BpmClient bpmClient) {
    BpmElement writeInvoiceElement = INVOICE_PROCESS.elementName("write invoice");

    ExecutionResult result = bpmClient
            .start().process(WRITE_INVOICE_START)
            .execute();

    /* Process data at last executed element */
    assertThat(((Order) result.data().last()).getValid()).isFalse();

    /* Process data at elements last execution */
    assertThat(((Order) result.data().lastOnElement(writeInvoiceElement)).getValid()).isFalse();

    /* Process data for each execution of the element */
    assertThat(((Order) result.data().onElement(writeInvoiceElement).get(0)).getValid()).isFalse();

    /* Streaming over all executions of the process data */
    result.data().onElement(writeInvoiceElement)
            .stream()
            .map(data -> (Order) data)
            .forEach(data -> assertThat(data.getValid()).isFalse());
  }

  @Test
  void mock(BpmClient bpmClient) {
    /* Mocking an element that doesn't require nor return anything */
    bpmClient.mock()
            .element(INVOICE_PROCESS.elementName("check order"))
            .withNoAction();

    /* Mocking without prior setup */
    bpmClient.mock()
            .element(INVOICE_PROCESS.elementName("check order"))
            .with(Order.class, (in, out) -> out.setValid(Boolean.TRUE));

    /* Mocking by defining the data beforehand */
    Order myOrderData = new Order();
    myOrderData.setValid(Boolean.TRUE);

    bpmClient.mock()
            .element(INVOICE_PROCESS.elementName("check order"))
            .with(in -> myOrderData);

    /* Mocking only the UI part of the element */
    bpmClient.mock()
            .uiOf(INVOICE_PROCESS.elementName("check order"))
            .with((params, results) -> results.set("total", 935));
  }

}
