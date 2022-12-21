package ch.ivyteam.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import ch.ivyteam.crm.CrmBean;
import ch.ivyteam.crm.IssueXivy1571;

public class TestCrmBean {

  @Test
  public void accessBeanFromCrmDemo() {
    CrmBean bean = new CrmBean();
    bean.setDescription("my simple description");
    assertThat(bean.getDescription()).startsWith("my simple");
  }

  /**
   * see https://jira.axonivy.com/jira/browse/XIVY-1571
   */
  @Test
  public void useExternalReferencedLibraryInRequiredProject() {
    assertThat(IssueXivy1571.hello()).isEqualTo("Rock'n'Roll");
  }
}
