import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
  private WebDriver driver;

  @Test
  public void testSimple() throws Exception {

      open("http://www.google.co.in");

  }

}