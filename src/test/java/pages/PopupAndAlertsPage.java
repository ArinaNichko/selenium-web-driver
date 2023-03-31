package pages;

import base.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
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
    log.info("Clicked on Alert button");
    alertButton.click();
  }

  public void clickOnClosePopupButton() {
    log.info("Clicked on Close popup button");
    closePopupButton.click();
  }

  public String getPopupTitle() {
    log.debug("Getting popup title: {}", popupTitle.getText());
    return popupTitle.getText();
  }

  public void clickOnPopupButton() {
    log.info("Clicked on Popup button");
    popupButton.click();
  }

  public void waitVisibilityOfPopup() {
    log.info("Setting explicit wait of visibility of element: {}", closePopupButton);
    WAIT.until(
            ExpectedConditions.visibilityOf(closePopupButton));
  }
}
