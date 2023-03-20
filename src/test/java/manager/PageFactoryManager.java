package manager;

import org.openqa.selenium.WebDriver;
import pages.AccordionItemsPage;
import pages.ActionsPage;
import pages.LoginPortalPage;
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

  public OptionsPage getOptionsPage() {
    return new OptionsPage(driver);
  }

  public LoginPortalPage getLoginPortalPage() {
    return new LoginPortalPage(driver);
  }

  public ActionsPage getActionsPage() {
    return new ActionsPage(driver);
  }
}
