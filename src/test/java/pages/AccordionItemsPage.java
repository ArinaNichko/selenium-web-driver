package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccordionItemsPage extends BasePage {
  @FindBy(id = "hidden-text")
  private WebElement loadItem;

  @FindBy(id = "click-accordion")
  private WebElement keepClickingItem;

  @FindBy(id = "manual-testing-accordion")
  private WebElement manualTestingItem;

  @FindBy(xpath = "//*[@id='timeout']")
  private WebElement KeepClickingItemPanel;

  @FindBy(css = "#manual-testing-description")
  private WebElement ManualTestingItemPanel;

  public AccordionItemsPage(WebDriver driver) {
    super(driver);
  }

  public void clickOnKeepClickingItem() {
    keepClickingItem.click();
  }

  public void clickOnManualTestingItem() {
    manualTestingItem.click();
  }

  public String getKeepClickingItemText() {
    return KeepClickingItemPanel.getText();
  }

  public String getManualTestingItemText() {
    return ManualTestingItemPanel.getText();
  }

  public void waitVisibilityOfLoadText(String text) {
    WAIT.until(
            ExpectedConditions.textToBePresentInElement(loadItem, text));
  }
}
