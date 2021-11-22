package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupBrowser {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions
                .addArguments("--headless")
                .addArguments("--disable-notifications")
                .addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.google.com");

        driver.manage().window().maximize();
        //to set up max screen size
        Thread.sleep(5000);
        driver.manage().window().setSize(new Dimension(500, 500));
        //to set up dimensions needed for specific device
        Thread.sleep(500);
        driver.quit();
    }
}
