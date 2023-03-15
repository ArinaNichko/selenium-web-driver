package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
  final String URL = "https://www.webdriveruniversity.com/";

  @FindBy(id = "dropdown-checkboxes-radiobuttons")
  private WebElement optionsLink;

  @FindBy(css = "#popup-alerts")
  private WebElement popupAndAlertLink;

  @FindBy(xpath = "//h1[contains(text(),'ACCORDION')]")
  private WebElement accordionLink;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void openHomePage() {
    driver.get(URL);
  }

  public void clickOnOptionsLink() {
    optionsLink.click();
  }

  public void clickOnPopupAndAlertsLink() {
    popupAndAlertLink.click();
  }

  public void clickOnAccordionItemsLink() {
    accordionLink.click();
  }
}
