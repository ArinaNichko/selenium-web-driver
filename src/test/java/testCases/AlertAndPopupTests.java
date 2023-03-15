package testCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import java.util.List;

public class AlertAndPopupTests extends BaseTest {

  @Test
  public void checkAlert(){
    homePage.openHomePage();
    homePage.clickOnPopupAndAlertsLink();

    List<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    alertAndPopupPage.clickOnAlertButton();

    Alert alert = alertAndPopupPage.switchToAlert();
    String getAlertMessage = alertAndPopupPage.getAlertText(alert);

    alertAndPopupPage.acceptAlert(alert);

    Assert.assertEquals(getAlertMessage, "I am an alert box!");
  }

  @Test
  public void checkPopup() {
    homePage.openHomePage();
    homePage.clickOnPopupAndAlertsLink();

    List<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    alertAndPopupPage.implicitWait(TIMEOUT);
    alertAndPopupPage.clickOnPopupButton();

    alertAndPopupPage.waitVisibilityOfPopup();
    alertAndPopupPage.clickOnClosePopupButton();

    Assert.assertEquals(alertAndPopupPage.getPopupTitle(),
            "It’s that Easy!! Well I think it is.....");
  }
}
