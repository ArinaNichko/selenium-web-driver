package testCases.loginPortal;

import model.User;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPortalPage;
import base.BaseTest;

import java.util.List;

public class LoginPortalTests extends BaseTest {
  private static LoginPortalPage loginPortalPage;
  private static String username;
  private static String password;

  @BeforeMethod
  public void setLoginPortalPage() {
    loginPortalPage = pageFactoryManager.getLoginPortalPage();
    username = propertiesHelper.getProperty("username");
    password = propertiesHelper.getProperty("password");

  }

  @Test
  public void checkLogin() {
    homePage.openHomePage();
    homePage.clickOnLoginPortalLink();

    List<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    User user = new User(username, password);

    loginPortalPage.implicitWait(TIMEOUT);
    loginPortalPage.loginIn(user);

    Alert alert = loginPortalPage.switchToAlert();
    String getAlertMessage = loginPortalPage.getAlertText(alert);

    loginPortalPage.acceptAlert(alert);

    Assert.assertEquals(getAlertMessage, "validation failed");
  }
}
