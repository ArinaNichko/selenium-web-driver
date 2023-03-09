package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertAndPopupPage extends BasePage{

  public AlertAndPopupPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@id=\"button1\"]")
  private WebElement alertButton;

  @FindBy(id = "button2")
  private WebElement popupButton;

  @FindBy(xpath = "//*[@id=\"myModal\"]/div/div/div[3]/button")
  private WebElement closePopupButton;

  @FindBy(xpath = "//h4")
  private WebElement popupTitle;

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
}
