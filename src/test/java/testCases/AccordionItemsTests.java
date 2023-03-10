package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import java.util.ArrayList;

public class AccordionItemsTests extends BaseTest {

  @Test
  public void checkAccordionItemsBelowAfter5Sec() {
    homePage.openHomePage();
    homePage.clickOnAccordionLink();

    ArrayList<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    accordionItemsPage.waitVisibilityOfLoadText("LOADING COMPLETE.");
    accordionItemsPage.clickOnAccordionItem4();

    Assert.assertEquals(accordionItemsPage.getPanelAccordionItem4Text(),
            "This text has appeared after 5 seconds!");
  }

  @Test
  public void checkAccordionItemsBelow() {
    homePage.openHomePage();
    homePage.clickOnAccordionLink();

    ArrayList<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    accordionItemsPage.clickOnAccordionItem1();

    Assert.assertTrue(accordionItemsPage.getPanelAccordionItem1Text().contains("Manual testing has for some time"));
  }
}
