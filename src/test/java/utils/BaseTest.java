package utils;

import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.AlertAndPopupPage;
import pages.HomePage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
  static PageFactoryManager pageFactoryManager;
  protected static HomePage homePage;
  protected static AlertAndPopupPage alertAndPopupPage;

 protected WebDriver driver;



  @BeforeClass
  public void TestSetUp() {
    chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    pageFactoryManager = new PageFactoryManager(driver);
    homePage = pageFactoryManager.getHomePage();
    alertAndPopupPage = pageFactoryManager.getAlertAndPopupPage();

  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }


}
