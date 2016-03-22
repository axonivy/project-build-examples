package ch.ivyteam.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import ch.ivyteam.crm.CrmBean;


public class TestCrmBean {

	@Test
	public void accessBeanFromCrmDemo()
	{
		CrmBean bean = new CrmBean();
		bean.setDescription("my simple description");
		assertThat(bean.getDescription()).startsWith("my simple");
	}
}
