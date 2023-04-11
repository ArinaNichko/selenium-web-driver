package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
  protected final WebDriverWait WAIT;
  private final long TIMEOUT = 15;
  protected JavascriptExecutor javascriptExecutor;
  protected WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    WAIT = new WebDriverWait(driver, TIMEOUT);
    javascriptExecutor = (JavascriptExecutor) driver;
    PageFactory.initElements(driver, this);
  }

  public List<String> tabsList() {
    return new ArrayList<>(driver.getWindowHandles());
  }

  public void switchToTab(String tab) {
    driver.switchTo().window(tab);
  }

  public Alert switchToAlert() {
    return driver.switchTo().alert();
  }

  public String getAlertText(Alert alert) {
    return alert.getText();
  }

  public void acceptAlert(Alert alert) {
    alert.accept();
  }

  public void implicitWait(long TIMEOUT) {
    driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
  }
}
