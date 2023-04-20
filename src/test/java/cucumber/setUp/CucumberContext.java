package cucumber.setUp;

import manager.PageFactoryManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import pages.HomePage;
import reporting.TestListener;
import utils.PropertiesHelper;
import webDriverFactory.LocalWebDriverCreator;
import webDriverFactory.RemoteWebDriverCreator;
import webDriverFactory.WebDriverCreator;

import static java.util.Optional.ofNullable;
import static utils.PropertiesHelper.getInstance;

@Listeners({TestListener.class})
public class CucumberContext {
  public static PropertiesHelper propertiesHelper;
  public final int FIRST = 1;
  public PageFactoryManager pageFactoryManager;
  public WebDriver driver;
  public HomePage homePage;
  public int timeout;
  public String baseUrl;
  private String hubUrl;
  private String browser;
  private boolean localRun;

  private static void configureLog4j() {
    PropertyConfigurator.configure(propertiesHelper.getProperty("log4jPropertiesPath"));
  }

  public void setUp() {
    propertiesHelper = getInstance();
    configureConstant();
    setUpDriver(browser, localRun);
    driver.manage().window().maximize();
    pageFactoryManager = new PageFactoryManager(driver);
    homePage = pageFactoryManager.getPage(HomePage.class);
    configureLog4j();
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
    browser = propertiesHelper.getProperty("browser");
    localRun = Boolean.parseBoolean(propertiesHelper.getProperty("localRun"));
  }
}
