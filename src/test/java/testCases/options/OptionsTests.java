package testCases.options;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.OptionsPage;
import base.BaseTest;

import java.util.List;

public class OptionsTests extends BaseTest {
  private static OptionsPage optionsPage;
  private static String selectOption;
  private static String expectedResult;

  @BeforeMethod
  public void setOptionsPage() {
    optionsPage = pageFactoryManager.getOptionsPage();
    selectOption = propertiesHelper.getProperty("selectOption");
    expectedResult = propertiesHelper.getProperty("expectedResult");
  }

  @Test
  public void checkJavaDropdownMenu() {
    homePage.openHomePage();
    homePage.clickOnOptionsLink();

    List<String> newTab = homePage.tabsList();
    homePage.switchToTab(newTab.get(FIRST));

    optionsPage.implicitWait(TIMEOUT);
    optionsPage.selectOption(selectOption);

    Assert.assertEquals(optionsPage.getSelectedOptionText(), expectedResult);
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
