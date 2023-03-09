package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


  String url = "https://www.webdriveruniversity.com/";

  @FindBy(id = "dropdown-checkboxes-radiobuttons")
  private WebElement dropdownLinks;

  @FindBy(css = "#popup-alerts")
  private WebElement popupAndAlertsLink;

  @FindBy(xpath = "//*[@id=\"button1\"]")
  private WebElement popupButton;



  public HomePage(WebDriver driver) {
    super(driver);
  }


  public void openHomePage() {
    driver.get(url);
  }

  public void clickOnDropdownLinks() {
    dropdownLinks.click();
  }
  public void clickOnpopupAndAlertsLink() {
    popupAndAlertsLink.click();
  }

  public void clickOnPopup() {
    popupButton.click();
  }



}
