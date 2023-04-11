package testCases.pages;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PopupAndAlertsPage;

import java.util.List;

public class PopupAndAlertsTests extends BaseTest {
  private static PopupAndAlertsPage popupAndAlertsPage;

  @BeforeMethod
  public void setPopupAndAlertsPage() {
    popupAndAlertsPage = pageFactoryManager.getPopupAndAlertsPage();
  }

  @Test
  public void checkAlert() {
    homePage.openHomePage();
    homePage.clickOnPopupAndAlertsLink();

    List<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    popupAndAlertsPage.implicitWait(TIMEOUT);
    popupAndAlertsPage.clickOnAlertButton();

    Alert alert = popupAndAlertsPage.switchToAlert();
    String getAlertMessage = popupAndAlertsPage.getAlertText(alert);

    popupAndAlertsPage.acceptAlert(alert);

    Assert.assertEquals(getAlertMessage, "I am an alert box!");
  }

  @Test
  public void checkPopup() {
    homePage.openHomePage();
    homePage.clickOnPopupAndAlertsLink();

    List<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    popupAndAlertsPage.implicitWait(TIMEOUT);
    popupAndAlertsPage.clickOnPopupButton();

    popupAndAlertsPage.waitVisibilityOfPopup();
    String popupTitle = popupAndAlertsPage.getPopupTitle();

    popupAndAlertsPage.clickOnClosePopupButton();

    Assert.assertEquals(popupTitle,
            "It’s that Easy!! Well I think it is.....");
  }
}
