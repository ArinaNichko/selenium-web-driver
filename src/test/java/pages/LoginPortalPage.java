package pages;

import base.BasePage;
import model.User;
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

  public void loginIn(User user) {
    elementWrapper(usernamePlaceholder).sendKeys(user.getUsername());
    elementWrapper(passwordPlaceholder).sendKeys(user.getPassword());
    javascriptExecutor.executeScript("arguments[0].click();", loginButton);
  }
}
