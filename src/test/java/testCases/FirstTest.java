package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class FirstTest extends BaseTest {


  @Test
  public void test() {
    driver.get("https://www.webdriveruniversity.com/Popup-Alerts/index.html");

  }

  @Test
  public void checkDropdownMenu(){
    homePage.openHomePage();
    homePage.clickOnDropdownLinks();

//    dropdownPage.clickOnDropDown1();
  }

  @Test
  public void checkAlert()  {

//   homePage.openHomePage();
//   homePage.clickOnpopupAndAlertsLink();
    driver.get("https://www.webdriveruniversity.com/Popup-Alerts/index.html");
    alertAndPopupPage.clickOnAlertButton();

    Alert alert = driver.switchTo().alert();
//    System.out.println(alert.getText().getClass());
    String getAlertMessage = alert.getText();
    alert.accept();

    Assert.assertEquals(getAlertMessage, "I am an alert box!");
  }

  @Test
  public void checkPopup() {

    driver.get("https://www.webdriveruniversity.com/Popup-Alerts/index.html");

//   homePage.openHomePage();
//   homePage.clickOnpopupAndAlertsLink();
    alertAndPopupPage.clickOnPopupButton();

    alertAndPopupPage.clickOnClosePopupButton();

    Assert.assertEquals(alertAndPopupPage.getPopupTitle()
            , "It’s that Easy!!  Well I think it is.....");
  }
}
