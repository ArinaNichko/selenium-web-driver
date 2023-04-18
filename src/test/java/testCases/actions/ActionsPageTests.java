package testCases.actions;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ActionsPage;
import base.BaseTest;

import java.util.List;

public class ActionsPageTests extends BaseTest {
  private static ActionsPage actionsPage;

  @BeforeMethod
  public void setActionsPage() {
    actionsPage = pageFactoryManager.getPage(ActionsPage.class);
  }

  @Test
  public void checkDragAndDrop() {
    homePage.openHomePage(baseUrl);
    homePage.clickOnActionsLink();

    List<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    actionsPage.implicitWait(timeout);
    actionsPage.moveElementToContainer();

    Assert.assertTrue(actionsPage.getDroppableContainerText().contains("Dropped!"));
  }

  @Test
  public void checkDoubleClick() {
    homePage.openHomePage(baseUrl);
    homePage.clickOnActionsLink();

    List<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    actionsPage.implicitWait(timeout);
    actionsPage.performDoubleClick();

    Assert.assertEquals(actionsPage.getDoubleClickableItemColor(), "rgb(147, 203, 90)");
  }

  @Test
  public void checkClickAndHold() {
    homePage.openHomePage(baseUrl);
    homePage.clickOnActionsLink();

    List<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    actionsPage.implicitWait(timeout);
    actionsPage.clickAndHold();

    Assert.assertEquals(actionsPage.getClickableBoxColor(), "rgb(0, 255, 0)");
    Assert.assertEquals(actionsPage.getClickableBoxText(), "Well done! keep holding that click now.....");
  }
}
