package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedCondition;

//method for custom waiting
public class CustomsWaiters {
    public static ExpectedCondition<Boolean> elementFirstInCollection(final By locator, final String text) {
      return new ExpectedCondition<Boolean>() {
          public Boolean apply(WebDriver driver){
          return driver.findElements(locator).get(0).getText().equals(text);
          }
          public String toString() {
              return String.format("element with text %s is at the first place", text);
          }
      };
    }

}
