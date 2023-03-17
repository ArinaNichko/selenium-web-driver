package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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
    ACTION.dragAndDrop(dropTarget, droppableContainer).build().perform();
  }

  public String getDroppableContainerText() {
    return (String) javascriptExecutor.executeScript("return arguments[0].textContent", droppableContainer);
  }
  public void performDoubleClick(){
    ACTION.doubleClick(doubleClickableItem).build().perform();
  }

  public String getDoubleClickableItemColor() {
    return (String) javascriptExecutor.executeScript(
            "return window.getComputedStyle(arguments[0]).getPropertyValue('background-color')", doubleClickableItem);
  }

  public void clickAndHold() {
    ACTION.clickAndHold(clickableBox).perform();
  }

  public String getClickableBoxText() {
    return (String) javascriptExecutor.executeScript("return arguments[0].textContent", clickableBox);
  }
  public String getClickableBoxColor() {
    return (String) javascriptExecutor.executeScript("return arguments[0].style.background", clickableBox);
  }
}
