package testCases;

import exceptions.TestExecutionException;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.edgedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;

public class BaseTest {
  protected static HomePage homePage;
  protected static PageFactoryManager pageFactoryManager;
  protected static WebDriver driver;
  final protected int FIRST = 1;
  final protected int TIMEOUT = 15;

  @Parameters({"browser", "localRun"})
  @BeforeMethod
  public void setUp(String browser, boolean localRun) {
    setUpDriver(browser, localRun);
    driver.manage().window().maximize();
    pageFactoryManager = new PageFactoryManager(driver);
    homePage = pageFactoryManager.getHomePage();
  }

  public void setUpDriver(String browser, boolean localRun) {
    if (localRun) {
      setUpLocalDriver(browser);
    } else {
      setUpRemoteDriver(browser);
    }
  }

  public void setUpLocalDriver(String browser) {
    if (browser.equalsIgnoreCase("chrome")) {
      chromedriver().setup();
      driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase("firefox")) {
      firefoxdriver().setup();
      driver = new FirefoxDriver();
    } else if (browser.equalsIgnoreCase("edge")) {
      edgedriver().setup();
      driver = new EdgeDriver();
    }
  }

  public void setUpRemoteDriver(String browser) {
    try {
      driver = new RemoteWebDriver(new URL("http://172.20.10.3:4444/"), getDesiredCapabilities(browser));
    } catch (MalformedURLException e) {
      throw new TestExecutionException(e.getMessage());
    }
  }

  public DesiredCapabilities getDesiredCapabilities(String browser) {
    if (browser.equalsIgnoreCase("chrome")) {
      return DesiredCapabilities.chrome();
    } else if (browser.equalsIgnoreCase("firefox")) {
      return DesiredCapabilities.firefox();
    } else if (browser.equalsIgnoreCase("edge")) {
      return DesiredCapabilities.edge();
    }
    return new DesiredCapabilities();
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
