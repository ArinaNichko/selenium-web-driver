package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class OptionsPage extends BasePage {
  @FindBy(id = "dropdowm-menu-1")
  private WebElement javaDropdownMenu;

  @FindBy(id = "dropdowm-menu-2")
  private WebElement eclipseDropdownMenu;

  @FindBy(xpath = "//*[@value=\"testng\"]")
  private WebElement testngOption;

  @FindBy(xpath = "//*[@value=\"green\"]")
  private WebElement greenRadioButton;

  @FindBy(xpath = "//*[@value=\"option-1\"]")
  private WebElement firstOptionCheckbox;

  @FindBy(xpath = "//*[@value=\"option-2\"]")
  private WebElement secondOptionCheckbox;

  @FindBy(xpath = "//*[@value=\"option-3\"]")
  private WebElement thirdOptionCheckbox;

  public OptionsPage(WebDriver driver) {
    super(driver);
  }

  public Select createSelectJavaDropdownMenu() {
    return new Select(javaDropdownMenu);
  }

  public void selectOption(String option) {
    createSelectJavaDropdownMenu().selectByValue(option);
  }

  public String getSelectedOptionText() {
    return createSelectJavaDropdownMenu().getFirstSelectedOption().getText();
  }

  public void clickOnEclipseDropdownMenu() {
    eclipseDropdownMenu.click();
  }

  public void clickOnTestngOption() {
    testngOption.click();
  }

  public String getTestngOptionText() {
    return testngOption.getText();
  }

  public void clickOnGreenRadioButton() {
    greenRadioButton.click();
  }

  public String getGreenRadioButtonValue() {
    return greenRadioButton.getAttribute("value");
  }

  public void clickOnFirstOptionCheckbox() {
    firstOptionCheckbox.click();
  }

  public void clickOnSecondOptionCheckbox() {
    secondOptionCheckbox.click();
  }

  public void clickOnThirdOptionCheckbox() {
    thirdOptionCheckbox.click();
  }

  public boolean isSelectedFirstOptionCheckbox() {
    return firstOptionCheckbox.isSelected();
  }

  public boolean isSelectedSecondOptionCheckbox() {
    return secondOptionCheckbox.isSelected();
  }

  public boolean isNotSelectedThirdOptionCheckbox() {
    return !(thirdOptionCheckbox.isSelected());
  }

  public void waitVisibilityOfTestngOption() {
    WAIT.until(
            ExpectedConditions.visibilityOf(testngOption));
  }
}

