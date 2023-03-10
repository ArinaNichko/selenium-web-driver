package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class OptionsPage extends BasePage {
  @FindBy(id = "dropdowm-menu-1")
  private WebElement dropdownMenu1;
  @FindBy(id = "dropdowm-menu-2")
  private WebElement dropdownMenu2;
  @FindBy(xpath = "//*[@value=\"testng\"]")
  private WebElement optionInDropdownMenu2;

  @FindBy(xpath = "//*[@value=\"green\"]")
  private WebElement radioButton1;

  @FindBy(xpath = "//*[@value=\"option-1\"]")
  private WebElement checkbox1;

  @FindBy(xpath = "//*[@value=\"option-2\"]")
  private WebElement checkbox2;

  @FindBy(xpath = "//*[@value=\"option-3\"]")
  private WebElement checkbox3;

  public OptionsPage(WebDriver driver) {
    super(driver);
  }

  public Select createSelectDropdownMenu1() {
    return new Select(dropdownMenu1);
  }

  public void selectOption(String option) {
    createSelectDropdownMenu1().selectByValue(option);
  }

  public String getSelectedOptionText() {
    return createSelectDropdownMenu1().getFirstSelectedOption().getText();
  }

  public void clickOnDropdownMenu2() {
    dropdownMenu2.click();
  }

  public void clickOnOptionInDropdown2() {
    optionInDropdownMenu2.click();
  }

  public String getOptionDropdownText() {
    return optionInDropdownMenu2.getText();
  }

  public void clickOnRadioButton1() {
    radioButton1.click();
  }

  public String getRadioButton1Value() {
    return radioButton1.getAttribute("value");
  }

  public void clickOnCheckbox1() {
    checkbox1.click();
  }

  public void clickOnCheckbox2() {
    checkbox2.click();
  }

  public void clickOnCheckbox3() {
    checkbox3.click();
  }

  public boolean isSelectedCheckbox1() {
    return checkbox1.isSelected();
  }

  public boolean isSelectedCheckbox2() {
    return checkbox2.isSelected();
  }

  public boolean isNotSelectedCheckbox3() {
    return !(checkbox3.isSelected());
  }

  public void waitVisibilityOfDropdownOption() {
    WAIT.until(
            ExpectedConditions.visibilityOf(optionInDropdownMenu2));
  }
}

