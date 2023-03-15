package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import java.util.List;

public class OptionsTests extends BaseTest {

  @Test
  public void checkJavaDropdownMenu() {
    homePage.openHomePage();
    homePage.clickOnDropdownLink();

    List<String> newTab = homePage.tabsList();
    homePage.switchToTab(newTab.get(FIRST));

    optionsPage.selectOption("python");

    Assert.assertEquals(optionsPage.getSelectedOptionText(), "Python");
  }

  @Test
  public void checkEclipseDropdownMenu() {
    homePage.openHomePage();
    homePage.clickOnDropdownLink();

    List<String> newTab = homePage.tabsList();
    homePage.switchToTab(newTab.get(FIRST));

    optionsPage.clickOnEclipseDropdownMenu();

    optionsPage.waitVisibilityOfTestngOption();
    optionsPage.clickOnTestngOption();

    Assert.assertEquals(optionsPage.getTestngOptionText(), "TestNG");
  }

  @Test
  public void checkGreenRadioButton() {
    homePage.openHomePage();
    homePage.clickOnDropdownLink();

    List<String> newTab = homePage.tabsList();
    homePage.switchToTab(newTab.get(FIRST));

    optionsPage.clickOnGreenRadioButton();

    Assert.assertEquals(optionsPage.getGreenRadioButtonValue(), "green");
  }

  @Test
  public void checkCheckboxes() {
    homePage.openHomePage();
    homePage.clickOnDropdownLink();

    List<String> newTab = homePage.tabsList();
    homePage.switchToTab(newTab.get(FIRST));

    optionsPage.clickOnFirstOptionCheckbox();
    optionsPage.clickOnSecondOptionCheckbox();
    optionsPage.clickOnThirdOptionCheckbox();

    Assert.assertTrue(optionsPage.isSelectedFirstOptionCheckbox() &&
            optionsPage.isSelectedSecondOptionCheckbox() && optionsPage.isNotSelectedThirdOptionCheckbox());
  }
}
