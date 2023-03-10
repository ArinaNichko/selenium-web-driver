package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import java.util.ArrayList;

public class OptionsTests extends BaseTest {

  @Test
  public void checkDropdownMenu1() {
    homePage.openHomePage();
    homePage.clickOnDropdownLink();

    ArrayList<String> newTab = homePage.tabsList();
    homePage.switchToTab(newTab.get(FIRST));

    dropdownPage.selectOption("python");

    Assert.assertEquals(dropdownPage.getSelectedOptionText(), "Python");
  }

  @Test
  public void checkDropdownMenu2() {
    homePage.openHomePage();
    homePage.clickOnDropdownLink();

    ArrayList<String> newTab = homePage.tabsList();
    homePage.switchToTab(newTab.get(FIRST));

    dropdownPage.clickOnDropdownMenu2();

    dropdownPage.waitVisibilityOfDropdownOption();
    dropdownPage.clickOnOptionInDropdown2();

    Assert.assertEquals(dropdownPage.getOptionDropdownText(), "TestNG");
  }

  @Test
  public void checkRadioButton() {
    homePage.openHomePage();
    homePage.clickOnDropdownLink();

    ArrayList<String> newTab = homePage.tabsList();
    homePage.switchToTab(newTab.get(FIRST));

    dropdownPage.clickOnRadioButton1();

    Assert.assertEquals(dropdownPage.getRadioButton1Value(), "green");
  }

  @Test
  public void checkCheckBox() {
    homePage.openHomePage();
    homePage.clickOnDropdownLink();

    ArrayList<String> newTab = homePage.tabsList();
    homePage.switchToTab(newTab.get(FIRST));

    dropdownPage.clickOnCheckbox1();
    dropdownPage.clickOnCheckbox2();
    dropdownPage.clickOnCheckbox3();

    Assert.assertTrue(dropdownPage.isSelectedCheckbox1() &&
            dropdownPage.isSelectedCheckbox2() && dropdownPage.isNotSelectedCheckbox3());
  }
}
