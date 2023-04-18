package testCases.accordionItems;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccordionItemsPage;
import base.BaseTest;

import java.util.List;

public class AccordionItemsTests extends BaseTest {
  private static AccordionItemsPage accordionItemsPage;

  @BeforeMethod
  public void setAccordionItemsPage() {
    accordionItemsPage = pageFactoryManager.getPage(AccordionItemsPage.class);
  }

  @Test
  public void checkKeepClickingItem() {
    homePage.openHomePage(baseUrl);
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
    homePage.openHomePage(baseUrl);
    homePage.clickOnAccordionItemsLink();

    List<String> tabsList = homePage.tabsList();
    homePage.switchToTab(tabsList.get(FIRST));

    accordionItemsPage.implicitWait(timeout);
    accordionItemsPage.clickOnManualTestingItem();

    Assert.assertTrue(accordionItemsPage.getManualTestingItemText().contains("Manual testing has for some time"));
  }
}
