package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BasePage {
  private final long TIMEOUT = 15;
  protected final WebDriverWait WAIT;
  protected WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    WAIT = new WebDriverWait(driver, TIMEOUT);
    PageFactory.initElements(driver, this);
  }

  public ArrayList<String> tabsList() {
    return new ArrayList<>(driver.getWindowHandles());
  }

  public void switchToTab(String tab) {
    driver.switchTo().window(tab);
  }

  public void implicitWait(long TIMEOUT) {
    driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
  }
}
