package base;

import static utils.PropertiesHelper.getInstance;

import manager.PageFactoryManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.HomePage;
import utils.PropertiesHelper;
import reporting.TestListener;
import webDriverFactory.LocalWebDriverCreator;
import webDriverFactory.RemoteWebDriverCreator;
import webDriverFactory.WebDriverCreator;

@Listeners({TestListener.class})
public class BaseTest {
  protected static HomePage homePage;
  protected static PageFactoryManager pageFactoryManager;
  public static WebDriver driver;
  final protected int FIRST = 1;
  final protected int TIMEOUT = 15;
  protected static PropertiesHelper propertiesHelper;

  @Parameters({"browser", "localRun"})
  @BeforeMethod
  public void setUp(String browser, @Optional("true") boolean localRun) {
    setUpDriver(browser, localRun);
    driver.manage().window().maximize();
    pageFactoryManager = new PageFactoryManager(driver);
    homePage = pageFactoryManager.getHomePage();
    propertiesHelper = getInstance();
    configureLog4j();
  }

  public void setUpDriver(String browser, boolean localRun) {
    String envBrowser = System.getenv("BROWSER");
    browser = envBrowser != null ? envBrowser : browser;
    WebDriverCreator creator;
    if (localRun) {
      creator = new LocalWebDriverCreator(browser);
    } else {
      creator = new RemoteWebDriverCreator(browser, "http://172.20.10.3:4444/");
    }
    driver = creator.createWebDriver();
  }

  private static void configureLog4j() {
    PropertyConfigurator.configure(propertiesHelper.getProperty("log4jPropertiesPath"));
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
