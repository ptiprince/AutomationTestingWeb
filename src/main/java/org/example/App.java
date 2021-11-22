package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       /* System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");*/
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://google.com");
        driver.quit();
    }
}
