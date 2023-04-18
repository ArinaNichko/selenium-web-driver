package manager;

import base.BasePage;
import exceptions.TestExecutionException;
import org.openqa.selenium.WebDriver;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PageFactoryManager {
  WebDriver driver;

  public PageFactoryManager(WebDriver driver) {
    this.driver = driver;
  }

  public <T extends BasePage> T getPage(Class<T> pageClass) {
    try {
      Constructor<T> constructor = pageClass.getDeclaredConstructor(WebDriver.class);
      return constructor.newInstance(driver);
    } catch (IllegalAccessException | InstantiationException |
             InvocationTargetException | NoSuchMethodException e) {
      throw new TestExecutionException("Failed to instantiate page class", e);
    }
  }
}
