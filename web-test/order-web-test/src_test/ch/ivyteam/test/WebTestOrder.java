package ch.ivyteam.test;

import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.Test;

import com.axonivy.ivy.supplements.IvySelenide;

@IvySelenide(browser = "firefox", headless = false, reportFolder = "target/selenide/reports")
public class WebTestOrder
{

  @Test
  void testOrder()
  {
    open("www.google.ch");
  }
}
