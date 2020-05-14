package ch.ivyteam.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Locale;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.environment.IvyTest;

@IvyTest
public class TestIvy
{
  
  /**
   * Test how to check content of the 'crm' CMS with multiple languages.
   */
  @Test
  public void cmsContent()
  {
    //check if the content inside the cms has a specific value
    assertThat(Ivy.cms().co("/Test/content")).isEqualTo("Hello World");
    
    //check if the content inside the same cms has specified a value for German
    assertThat(Ivy.cms().coLocale("/Test/content", Locale.GERMAN)).isEqualTo("Hallo Welt");
    
    //change the language for this test session
    Ivy.session().setContentLocale(Locale.GERMAN);
    
    //check if the default content of the same cms is now in German
    assertThat(Ivy.cms().co("/Test/content")).isEqualTo("Hallo Welt");
  }
  
  /**
   * Test how to access global variables
   */
  @Test
  public void globalVariables()
  {
    assertThat(Ivy.var().getVariableNames()).contains("variable");
    assertThat(Ivy.var().get("variable")).isEqualTo("Hi");
    //TODO: add example with AppFixure API
  }
  
  /**
   * Test execute a rest client
   */
  @Test
  public void restClient()
  {
    WebTarget client = Ivy.rest().client("openApiService");
    assertThat(client.getUri().toString()).isEqualTo("https://petstore.swagger.io/v2");
    
    Response response = client.path("/store/inventory").request().buildGet().invoke();
    assertThat(response.getStatus()).isEqualTo(200);
  }
 
  // Some other Ivy API examples:
  
  @Test
  public void cal() 
  {
    assertThat(Ivy.cal()).isNotNull();
    assertThat(Ivy.cal().getName()).isEqualTo("Default");
  }

  @Test
  public void persistence() 
  {
    assertThat(Ivy.persistence()).isNotNull();
    assertThat(Ivy.persistence().get("gugus")).isNotNull();
  }

  @Test
  public void log() 
  {
    assertThat(Ivy.log()).isNotNull();
    assertThat(Ivy.log().getName()).isEqualTo("runtimelog.test.testHtmlProcessElements.user_code");
  }


  @Test
  public void session() 
  {
    assertThat(Ivy.session()).isNotNull();
    assertThat(Ivy.session().isSessionUserUnknown()).isTrue();
  }

  @Test
  public void wf() 
  {
    assertThat(Ivy.wf()).isNotNull();
    assertThat(Ivy.wf().getApplication()).isNotNull();
  }
  
  @Test
  public void wfTask() 
  {
    assertThat(Ivy.wfTask()).isNotNull();
    assertThat(Ivy.wfTask().getName()).isEqualTo("test process");
  }
  
  @Test
  public void wfCase() 
  {
    assertThat(Ivy.wfCase()).isNotNull();
    assertThat(Ivy.wfCase().getName()).isEqualTo("test process");
  }
  
}
