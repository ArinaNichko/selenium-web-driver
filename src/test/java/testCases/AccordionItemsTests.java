package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.util.List;

public class AccordionItemsTests extends BaseTest {

  @Test
  public void checkKeepClickingItem() {
    homePage.openHomePage();
    homePage.clickOnAccordionItemsLink();

    List<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    accordionItemsPage.waitVisibilityOfLoadText("LOADING COMPLETE.");
    accordionItemsPage.clickOnKeepClickingItem();

    Assert.assertEquals(accordionItemsPage.getKeepClickingItemText(),
            "This text has appeared after 5 seconds!");
  }

  @Test
  public void checkManualTestingItem() {
    homePage.openHomePage();
    homePage.clickOnAccordionItemsLink();

    List<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    accordionItemsPage.clickOnManualTestingItem();

    Assert.assertTrue(accordionItemsPage.getManualTestingItemText().contains("Manual testing has for some time"));
  }
}
