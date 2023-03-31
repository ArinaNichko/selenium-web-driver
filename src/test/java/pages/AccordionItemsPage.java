package pages;

import base.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
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
    log.info("Clicked on Keep clicking item");
    keepClickingItem.click();
  }

  public void clickOnManualTestingItem() {
    log.info("Clicked on Manual testing item");
    manualTestingItem.click();
  }

  public String getKeepClickingItemText() {
    log.debug("Getting Keep clicking item text: {}", KeepClickingItemPanel.getText());
    return KeepClickingItemPanel.getText();
  }

  public String getManualTestingItemText() {
    log.debug("Getting Manual testing item text: {}", ManualTestingItemPanel.getText());
    return ManualTestingItemPanel.getText();
  }

  public void waitVisibilityOfLoadText(String text) {
    log.info("Setting explicit wait to be present in element: {}", loadItem);
    WAIT.until(
            ExpectedConditions.textToBePresentInElement(loadItem, text));
  }
}
