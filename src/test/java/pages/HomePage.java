package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
  final String URL = "https://www.webdriveruniversity.com/";

  @FindBy(id = "dropdown-checkboxes-radiobuttons")
  private WebElement optionsLink;

  @FindBy(css = "#popup-alerts")
  private WebElement popupAndAlertsLink;

  @FindBy(xpath = "//h1[contains(text(),'ACCORDION')]")
  private WebElement accordionItemsLink;

  @FindBy(css = "#login-portal")
  private WebElement loginPortalLink;

  @FindBy(css = "#actions")
  private WebElement actionsLink;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void openHomePage() {
    driver.get(URL);
  }

  public void clickOnOptionsLink() {
    javascriptExecutor.executeScript("arguments[0].click();", optionsLink);
  }

  public void clickOnLoginPortalLink() {
    javascriptExecutor.executeScript("arguments[0].click();", loginPortalLink);
  }

  public void clickOnPopupAndAlertsLink() {
    javascriptExecutor.executeScript("arguments[0].click();", popupAndAlertsLink);
  }

  public void clickOnAccordionItemsLink() {
    javascriptExecutor.executeScript("arguments[0].click();", accordionItemsLink);
  }
  public void clickOnActionsLink() {
    javascriptExecutor.executeScript("arguments[0].click();", actionsLink);
  }
}
