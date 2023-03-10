package manager;

import org.openqa.selenium.WebDriver;
import pages.AccordionItemsPage;
import pages.AlertAndPopupPage;
import pages.OptionsPage;
import pages.HomePage;

public class PageFactoryManager {
  WebDriver driver;

  public PageFactoryManager(WebDriver driver) {
    this.driver = driver;
  }

  public HomePage getHomePage() {
    return new HomePage(driver);
  }

  public AlertAndPopupPage getAlertAndPopupPage() {
    return new AlertAndPopupPage(driver);
  }

  public AccordionItemsPage getAccordianPage() {
    return new AccordionItemsPage(driver);
  }

  public OptionsPage getDropdownPage() {
    return new OptionsPage(driver);
  }
}
