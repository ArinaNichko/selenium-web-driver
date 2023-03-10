package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccordionItemsPage extends BasePage {
  @FindBy(id = "hidden-text")
  private WebElement loadItem;
  @FindBy(id = "click-accordion")
  private WebElement accordionItem4;

  @FindBy(id = "manual-testing-accordion")
  private WebElement accordionItem1;

  @FindBy(xpath = "//*[@id='timeout']")
  private WebElement panelAccordionItem4;

  @FindBy(css = "#manual-testing-description")
  private WebElement panelAccordionItem1;

  public AccordionItemsPage(WebDriver driver) {
    super(driver);
  }

  public void clickOnAccordionItem4() {
    accordionItem4.click();
  }

  public void clickOnAccordionItem1() {
    accordionItem1.click();
  }

  public String getPanelAccordionItem4Text() {
    return panelAccordionItem4.getText();
  }

  public String getPanelAccordionItem1Text() {
    return panelAccordionItem1.getText();
  }

  public void waitVisibilityOfLoadText(String text) {
    WAIT.until(
            ExpectedConditions.textToBePresentInElement(loadItem, text));
  }
}
