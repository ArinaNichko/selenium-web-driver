package pages;

import base.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

@Slf4j
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
    log.info("Selected option: {}", option);
    createSelectJavaDropdownMenu().selectByValue(option);
  }

  public String getSelectedOptionText() {
    String selectedOptionText = createSelectJavaDropdownMenu().getFirstSelectedOption().getText();
    log.debug("Getting Selected option text: {}", selectedOptionText);
    return selectedOptionText;
  }

  public void clickOnEclipseDropdownMenu() {
    elementWrapper(eclipseDropdownMenu).click();
  }


  public void clickOnTestngOption() {
    elementWrapper(testngOption).click();
  }

  public String getTestngOptionText() {
    return elementWrapper(testngOption).getText();
  }

  public void clickOnGreenRadioButton() {
    elementWrapper(greenRadioButton).click();
  }

  public String getGreenRadioButtonValue() {
    return elementWrapper(greenRadioButton).getAttribute("value");
  }

  public void clickOnFirstOptionCheckbox() {
    elementWrapper(firstOptionCheckbox).click();
  }

  public void clickOnSecondOptionCheckbox() {
    elementWrapper(secondOptionCheckbox).click();
  }

  public void clickOnThirdOptionCheckbox() {
    elementWrapper(thirdOptionCheckbox).click();
  }

  public boolean isSelectedFirstOptionCheckbox() {
    return elementWrapper(firstOptionCheckbox).isSelected();
  }

  public boolean isSelectedSecondOptionCheckbox() {
    return elementWrapper(secondOptionCheckbox).isSelected();
  }

  public boolean isNotSelectedThirdOptionCheckbox() {
    return !elementWrapper(thirdOptionCheckbox).isSelected();
  }

  public void waitVisibilityOfTestngOption() {
    log.info("Setting explicit wait of visibility of element: {}", testngOption.getAttribute("value"));
    WAIT.until(
            ExpectedConditions.visibilityOf(testngOption));
  }
}

