package testCases.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.OptionsPage;

import java.util.List;

public class OptionsTests extends BaseTest {
  private static OptionsPage optionsPage;

  @BeforeMethod
  public void setOptionsPage() {
    optionsPage = pageFactoryManager.getOptionsPage();
  }

  @Test
  public void checkJavaDropdownMenu() {
    homePage.openHomePage();
    homePage.clickOnOptionsLink();

    List<String> newTab = homePage.tabsList();
    homePage.switchToTab(newTab.get(FIRST));

    optionsPage.implicitWait(TIMEOUT);
    optionsPage.selectOption("python");

    Assert.assertEquals(optionsPage.getSelectedOptionText(), "Python");
  }

  @Test
  public void checkEclipseDropdownMenu() {
    homePage.openHomePage();

    homePage.clickOnOptionsLink();

    List<String> newTab = homePage.tabsList();
    homePage.switchToTab(newTab.get(FIRST));

    optionsPage.implicitWait(TIMEOUT);
    optionsPage.clickOnEclipseDropdownMenu();

    optionsPage.waitVisibilityOfTestngOption();
    optionsPage.clickOnTestngOption();

    Assert.assertEquals(optionsPage.getTestngOptionText(), "TestNG");
  }

  @Test
  public void checkGreenRadioButton() {
    homePage.openHomePage();
    homePage.clickOnOptionsLink();

    List<String> newTab = homePage.tabsList();
    homePage.switchToTab(newTab.get(FIRST));

    optionsPage.implicitWait(TIMEOUT);
    optionsPage.clickOnGreenRadioButton();

    Assert.assertEquals(optionsPage.getGreenRadioButtonValue(), "green");
  }

  @Test
  public void checkCheckboxes() {
    homePage.openHomePage();
    homePage.clickOnOptionsLink();

    List<String> newTab = homePage.tabsList();
    homePage.switchToTab(newTab.get(FIRST));

    optionsPage.implicitWait(TIMEOUT);
    optionsPage.clickOnFirstOptionCheckbox();
    optionsPage.clickOnSecondOptionCheckbox();
    optionsPage.clickOnThirdOptionCheckbox();

    Assert.assertTrue(optionsPage.isSelectedFirstOptionCheckbox() &&
            optionsPage.isSelectedSecondOptionCheckbox() && optionsPage.isNotSelectedThirdOptionCheckbox());
  }
}
