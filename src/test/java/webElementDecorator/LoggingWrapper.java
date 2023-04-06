package webElementDecorator;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;

@Slf4j
public class LoggingWrapper implements WebElement {
  private final WebElement element;

  public LoggingWrapper(WebElement element) {
    this.element = element;
  }

  @Override
  public String getAttribute(String s) {
    String attributeValue = element.getAttribute(s);
    log.debug("Getting the element value: {}", attributeValue);
    return attributeValue;
  }

  @Override
  public boolean isSelected() {
    log.info("Element is selected: {}", this.getAttribute("value"));
    return element.isSelected();
  }

  @Override
  public boolean isEnabled() {
    return false;
  }

  @Override
  public String getText() {
    String text = element.getText();
    log.debug("Getting the element text: {}", text);
    return text;
  }

  @Override
  public List<WebElement> findElements(By by) {
    return null;
  }

  @Override
  public WebElement findElement(By by) {
    return null;
  }

  @Override
  public boolean isDisplayed() {
    return false;
  }

  @Override
  public Point getLocation() {
    return null;
  }

  @Override
  public Dimension getSize() {
    return null;
  }

  @Override
  public Rectangle getRect() {
    return null;
  }

  @Override
  public String getCssValue(String s) {
    return null;
  }

  @Override
  public void click() {
    element.click();
    log.info("Clicked on the element: {}", this.getAttribute("value"));
  }

  @Override
  public void submit() {

  }

  @Override
  public void sendKeys(CharSequence... keysToSend) {
    element.sendKeys(keysToSend);
    log.info("Send keys: {}", (Object) keysToSend);
  }

  @Override
  public void clear() {

  }

  @Override
  public String getTagName() {
    return null;
  }

  @Override
  public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
    return null;
  }
}

