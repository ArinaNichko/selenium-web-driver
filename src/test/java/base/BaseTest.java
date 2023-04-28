package base;

import static java.util.Optional.ofNullable;
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
  public static WebDriver driver;
  public static PropertiesHelper propertiesHelper;
  protected static HomePage homePage;
  protected static PageFactoryManager pageFactoryManager;
  protected static int timeout;
  protected static String baseUrl;
  private static String hubUrl;
  protected final int FIRST = 1;

  private static void configureLog4j() {
    PropertyConfigurator.configure(propertiesHelper.getProperty("log4jPropertiesPath"));
  }

  @Parameters({"browser", "localRun"})
  @BeforeMethod
  public void setUp(String browser, @Optional("true") boolean localRun) {
    setUpDriver(browser, localRun);
    driver.manage().window().maximize();
    pageFactoryManager = new PageFactoryManager(driver);
    homePage = pageFactoryManager.getPage(HomePage.class);
    propertiesHelper = getInstance();
    configureLog4j();
    configureConstant();
  }

  public void setUpDriver(String browser, boolean localRun) {
    String envBrowser = System.getenv("BROWSER");
    browser = ofNullable(envBrowser).orElse(browser);
    WebDriverCreator creator;
    if (localRun) {
      creator = new LocalWebDriverCreator(browser);
    } else {
      creator = new RemoteWebDriverCreator(browser, hubUrl);
    }
    driver = creator.createWebDriver();
  }

  public void configureConstant() {
    hubUrl = propertiesHelper.getProperty("hubUrl");
    baseUrl = propertiesHelper.getProperty("baseUrl");

    timeout = Integer.parseInt(propertiesHelper.getProperty("timeout"));
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
