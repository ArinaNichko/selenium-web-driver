package pages;

import base.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class ActionsPage extends BasePage {
  private final Actions ACTION = new Actions(driver);

  @FindBy(xpath = "//*[@id=\"draggable\"]")
  private WebElement dropTarget;

  @FindBy(xpath = "//*[@id=\"droppable\"]")
  private WebElement droppableContainer;

  @FindBy(xpath = "//*[@id=\"double-click\"]")
  private WebElement doubleClickableItem;

  @FindBy(xpath = "//*[@id=\"click-box\"]")
  private WebElement clickableBox;

  public ActionsPage(WebDriver driver) {
    super(driver);
  }

  public void moveElementToContainer() {
    log.info("Moved element to container");
    ACTION.dragAndDrop(dropTarget, droppableContainer).build().perform();
  }

  public String getDroppableContainerText() {
    String droppableContainerText = (String) javascriptExecutor
            .executeScript("return arguments[0].textContent", droppableContainer);
    log.debug("Getting droppable container text: {}", droppableContainerText);
    return droppableContainerText;
  }

  public void performDoubleClick(){
    log.info("Performed double click");
    ACTION.doubleClick(doubleClickableItem).build().perform();
  }

  public String getDoubleClickableItemColor() {
    String doubleClickableItemColor = (String) javascriptExecutor.executeScript(
            "return window.getComputedStyle(arguments[0]).getPropertyValue('background-color')"
            , doubleClickableItem);
    log.debug("Getting double clickable item color: {}", doubleClickableItemColor);
    return doubleClickableItemColor;
  }

  public void clickAndHold() {
    log.info("Clicked and hold");
    ACTION.clickAndHold(clickableBox).perform();
  }

  public String getClickableBoxText() {
    String clickableBoxText = (String) javascriptExecutor
            .executeScript("return arguments[0].textContent", clickableBox);
    log.debug("Getting clickable box text: {}", clickableBoxText);
    return clickableBoxText;
  }

  public String getClickableBoxColor() {
    String clickableBoxColor = (String) javascriptExecutor
            .executeScript("return arguments[0].style.background", clickableBox);
    log.debug("Getting clickable box color: {}", clickableBoxColor);
    return clickableBoxColor;
  }
}
