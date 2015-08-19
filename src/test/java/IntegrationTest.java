import org.fluentlenium.adapter.FluentTest;
import java.util.ArrayList;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
  	goTo("http://localhost:4567/");
  	assertThat(pageSource()).contains("CD Organizer");
  }

  @Test
  public void insertsCDCorrectly(){
    goTo("http://localhost:4567/");
    fill("#artist").with("Summer");
    fill("#title").with("Ju");
    find("#brazilian").click();
    submit(".btn");
    assertThat(pageSource()).contains("Summer");
  }
}
