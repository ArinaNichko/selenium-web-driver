package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PopupAndAlertsPage extends BasePage {
  @FindBy(xpath = "//*[@id=\"button1\"]")
  private WebElement alertButton;

  @FindBy(id = "button2")
  private WebElement popupButton;

  @FindBy(xpath = "//*[@id=\"myModal\"]/div/div/div[3]/button")
  private WebElement closePopupButton;

  @FindBy(xpath = "//h4")
  private WebElement popupTitle;

  public PopupAndAlertsPage(WebDriver driver) {
    super(driver);
  }

  public void clickOnAlertButton() {
    alertButton.click();
  }

  public void clickOnClosePopupButton() {
    closePopupButton.click();
  }

  public String getPopupTitle() {
    return popupTitle.getText();
  }

  public void clickOnPopupButton() {
    popupButton.click();
  }

  public void waitVisibilityOfPopup() {
    WAIT.until(
            ExpectedConditions.visibilityOf(closePopupButton));
  }
}
