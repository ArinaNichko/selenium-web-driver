package manager;

import org.openqa.selenium.WebDriver;
import pages.AccordionItemsPage;
import pages.PopupAndAlertsPage;
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

  public PopupAndAlertsPage getPopupAndAlertsPage() {
    return new PopupAndAlertsPage(driver);
  }

  public AccordionItemsPage getAccordionItemsPage() {
    return new AccordionItemsPage(driver);
  }

  public OptionsPage getDropdownPage() {
    return new OptionsPage(driver);
  }
}
