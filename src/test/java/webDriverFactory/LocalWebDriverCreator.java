package webDriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.edgedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;

public class LocalWebDriverCreator implements WebDriverCreator{
  private final String BROWSER;

  public LocalWebDriverCreator(String browser) {
    this.BROWSER = browser;
  }

  @Override
  public WebDriver createWebDriver() {
    switch (BROWSER.toLowerCase()) {
      case "chrome" -> {
        chromedriver().setup();
        return new ChromeDriver();
      }
      case "firefox" -> {
        firefoxdriver().setup();
        return new FirefoxDriver();
      }
      case "edge" -> {
        edgedriver().setup();
        return new EdgeDriver();
      }
      default -> throw new IllegalArgumentException("Invalid browser specified");
    }
  }
}
