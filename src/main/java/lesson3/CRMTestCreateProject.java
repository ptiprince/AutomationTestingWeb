package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

//Test Case to create new Project

public class CRMTestCreateProject {
    public static WebDriver driver;

    public static <StingBuffer> void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        loginToCrm();

        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a"));
                actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//li[@data-route='crm_project_index']/a")).click();
//a/span[text()='Все проекты'] - another locator

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать проект']")));
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='crm_project[name]']")));
        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).sendKeys("TestProject777");
        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Test");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> organizationNames = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
        organizationNames.get(0).click();

        //webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='crm_project[priority]']")));
        Select prioritySelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[priority]']")));
        prioritySelect.selectByVisibleText("Средний");

        Select businessUnitSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select curatorSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[curator]']")));
        curatorSelect.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select rpSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[rp]']")));
        rpSelect.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select managerSelect = new Select(driver.findElement(By.xpath("//select[@name='crm_project[manager]']")));
        managerSelect.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

       webDriverWait.until(ExpectedConditions.elementToBeClickable
               (By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")));
        //driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")).click();

        webDriverWait.until(ExpectedConditions.textToBePresentInElement(
                driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_company')]/a")), "123test"));

        //Thread.sleep(1000);//TODO: подебажить это ожидание
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-container select2']")));
        driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='select2-drop']//input")));
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("1111");
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys(Keys.ENTER);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_planning-uid')]")));
        driver.findElement(By.xpath("//body")).sendKeys("testtest");
        ////textarea[contains(@name, 'crm_project[planning]')]-another xpath;
        Thread.sleep(5000);
        driver.switchTo().parentFrame();

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        driver.quit();
    }

    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }
}
