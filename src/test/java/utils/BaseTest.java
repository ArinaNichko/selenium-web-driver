package utils;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AccordionItemsPage;
import pages.AlertAndPopupPage;
import pages.OptionsPage;
import pages.HomePage;

public class BaseTest {
  final protected int FIRST = 1;
  final protected int TIMEOUT = 15;
  protected static HomePage homePage;
  protected static AlertAndPopupPage alertAndPopupPage;
  protected static AccordionItemsPage accordionItemsPage;
  protected static OptionsPage optionsPage;
  protected static PageFactoryManager pageFactoryManager;
  protected static WebDriver driver;

  @BeforeMethod
  public void TestSetUp() {
    chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    pageFactoryManager = new PageFactoryManager(driver);
    initPages();
  }

  public void initPages() {
    homePage = pageFactoryManager.getHomePage();
    alertAndPopupPage = pageFactoryManager.getAlertAndPopupPage();
    accordionItemsPage = pageFactoryManager.getAccordianPage();
    optionsPage = pageFactoryManager.getDropdownPage();
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
