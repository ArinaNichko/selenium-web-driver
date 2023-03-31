package pages;

import base.BasePage;
import lombok.extern.slf4j.Slf4j;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
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
    log.debug("Logging in with username: {} and password: {}", user.getUsername(), user.getPassword());
    usernamePlaceholder.sendKeys(user.getUsername());
    passwordPlaceholder.sendKeys(user.getPassword());
    javascriptExecutor.executeScript("arguments[0].click();", loginButton);
  }
}
