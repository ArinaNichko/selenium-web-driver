package utils;

import exceptions.TestExecutionException;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.AccordionItemsPage;
import pages.ActionsPage;
import pages.LoginPortalPage;
import pages.PopupAndAlertsPage;
import pages.OptionsPage;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
  protected static HomePage homePage;
  protected static PopupAndAlertsPage popupAndAlertsPage;
  protected static AccordionItemsPage accordionItemsPage;
  protected static OptionsPage optionsPage;
  protected static LoginPortalPage loginPortalPage;
  protected static ActionsPage actionsPage;
  protected static PageFactoryManager pageFactoryManager;
  protected static WebDriver driver;
  protected static DesiredCapabilities capabilities;
  final protected int FIRST = 1;
  final protected int TIMEOUT = 15;

  @Parameters("browser")
  @BeforeMethod
  public void setUp(String browser) {
    setUpDriver(browser);
    driver.manage().window().maximize();
    pageFactoryManager = new PageFactoryManager(driver);
    initPages();
  }

  public void setUpDriver(String browser) {
    if (browser.equalsIgnoreCase("chrome")) {
      capabilities = DesiredCapabilities.chrome();
    } else if (browser.equalsIgnoreCase("firefox")) {
      capabilities = DesiredCapabilities.firefox();
    } else if (browser.equalsIgnoreCase("MicrosoftEdge")) {
      capabilities = DesiredCapabilities.edge();
    }
    try {
      driver = new RemoteWebDriver(new URL("http://172.20.10.3:4444/"), capabilities);
    } catch (MalformedURLException e) {
      throw new TestExecutionException(e.getMessage());
    }
  }

  public void initPages() {
    homePage = pageFactoryManager.getHomePage();
    popupAndAlertsPage = pageFactoryManager.getPopupAndAlertsPage();
    accordionItemsPage = pageFactoryManager.getAccordionItemsPage();
    optionsPage = pageFactoryManager.getDropdownPage();
    loginPortalPage = pageFactoryManager.getLoginPortalPage();
    actionsPage = pageFactoryManager.getActionsPage();
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
