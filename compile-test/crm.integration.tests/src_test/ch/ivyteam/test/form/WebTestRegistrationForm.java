package ch.ivyteam.test.form;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import ch.ivyteam.test.web.IvyEngine;

/**
 * Simple browser-based (selenium) integration test. <br/>
 * Tests the functionality of the Registration <code>crm.CustomerRegistrationForm</code>.
 */
public class WebTestRegistrationForm {

	@Test
	public void registerNewCustomer()
	{
		WebDriver driver = new HtmlUnitDriver();
		driver.get(IvyEngine.getBaseUrl());
		System.out.println(driver.getCurrentUrl());
		assertThat(driver.getTitle()).contains("ivy");
		
		driver.findElement(By.linkText("customer/register.ivp")).click();
		driver.findElement(By.id("form:firstname")).sendKeys("Unit");
		driver.findElement(By.id("form:lastname")).sendKeys("Test");
		driver.findElement(By.id("form")).submit();
	}
	
}
