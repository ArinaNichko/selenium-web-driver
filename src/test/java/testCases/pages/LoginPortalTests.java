package testCases.pages;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPortalPage;

import java.util.List;

public class LoginPortalTests extends BaseTest {
  private static LoginPortalPage loginPortalPage;

  @BeforeMethod
  public void setLoginPortalPage() {
    loginPortalPage = pageFactoryManager.getLoginPortalPage();
  }

  @Test
  public void checkLogin() {
    homePage.openHomePage();
    homePage.clickOnLoginPortalLink();

    List<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    loginPortalPage.implicitWait(TIMEOUT);
    loginPortalPage.enterUsername("Arina");
    loginPortalPage.enterPassword("1234pf");
    loginPortalPage.clickOnLoginButton();

    Alert alert = loginPortalPage.switchToAlert();
    String getAlertMessage = loginPortalPage.getAlertText(alert);

    loginPortalPage.acceptAlert(alert);

    Assert.assertEquals(getAlertMessage, "validation failed");
  }
}
