package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import java.util.List;

public class ActionsPageTest extends BaseTest {

  @Test
  public void checkDragAndDrop() {
    homePage.openHomePage();
    homePage.clickOnActionsLink();

    List<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    actionsPage.implicitWait(TIMEOUT);
    actionsPage.moveElementToContainer();

    Assert.assertTrue(actionsPage.getDroppableContainerText().contains("Dropped!"));
  }

  @Test
  public void checkDoubleClick() {
    homePage.openHomePage();
    homePage.clickOnActionsLink();

    List<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    actionsPage.implicitWait(TIMEOUT);
    actionsPage.performDoubleClick();

    Assert.assertEquals(actionsPage.getDoubleClickableItemColor(),"rgb(147, 203, 90)");
  }

  @Test
  public void checkClickAndHold() {
    homePage.openHomePage();
    homePage.clickOnActionsLink();

    List<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    actionsPage.implicitWait(TIMEOUT);
    actionsPage.clickAndHold();

    Assert.assertEquals(actionsPage.getClickableBoxColor(),"rgb(0, 255, 0)");
    Assert.assertEquals(actionsPage.getClickableBoxText(),"Well done! keep holding that click now.....");
  }
}