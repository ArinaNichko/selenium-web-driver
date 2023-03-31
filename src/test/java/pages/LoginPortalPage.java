package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPortalPage extends BasePage {
  @FindBy(css = "#text")
  private WebElement usernamePlaceholder;

  @FindBy(css = "#password")
  private WebElement passwordPlaceholder;

  @FindBy(css = "#login-button")
  private WebElement loginButton;

  public LoginPortalPage(WebDriver driver) {
    super(driver);
  }

  public void enterUsername(String username) {
    usernamePlaceholder.sendKeys(username);
  }

  public void enterPassword(String password) {
    passwordPlaceholder.sendKeys(password);
  }

  public void clickOnLoginButton() {
    javascriptExecutor.executeScript("arguments[0].click();", loginButton);
  }
}
