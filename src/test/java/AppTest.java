import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.rules.ExternalResource;
import org.sql2o.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;


public class AppTest extends FluentTest{
  public WebDriver webDriver = new HtmlUnitDriver(); //what is this?
  public WebDriver getDefaultDriver(){
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule(); //What does this do?

  @Rule
  public DatabaseRule database = new DatabaseRule(); //Why save this way?

  @Test
  public void rootTest() {
    goTo("http://localhost:4567");
    assertThat(pageSource().contains("Bella Stylists"));
  }

  @Test // added public
  public void stylistIsDisplayedWhenCreated() {
    goTo("http://localhost:4567/");
    fill("#name").with("Roxana");
    submit(".submit-stylist");
    assertThat(pageSource().contains("Roxana"));
  }

  @Test
  public void clientIsDisplayedWhenCreated() {
    goTo("http://localhost:4567/");
    fill("#name").with("Roxana");
    submit(".submit-stylist");
    fill("#stylistId").with("Roxana");
    fill("name").with("Monique");
    fill("phone").with("5555");
    fill("email").with("@yahoo");
    fill("address").with("address");
    submit(".submit-client");
    assertThat(pageSource()).contains("Monique");
  }
}//end AppTest
