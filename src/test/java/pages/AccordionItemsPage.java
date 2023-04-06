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
  private WebElement keepClickingItemPanel;

  @FindBy(css = "#manual-testing-description")
  private WebElement manualTestingItemPanel;

  public AccordionItemsPage(WebDriver driver) {
    super(driver);
  }

  public void clickOnKeepClickingItem() {
    elementWrapper(keepClickingItem).click();
  }

  public void clickOnManualTestingItem() {
    elementWrapper(manualTestingItem).click();
  }

  public String getKeepClickingItemText() {
    return elementWrapper(keepClickingItemPanel).getText();
  }

  public String getManualTestingItemText() {
    return elementWrapper(manualTestingItemPanel).getText();
  }

  public void waitVisibilityOfLoadText(String text) {
    log.info("Setting explicit wait to be present in Load element");
    WAIT.until(
            ExpectedConditions.textToBePresentInElement(loadItem, text));
  }
}
