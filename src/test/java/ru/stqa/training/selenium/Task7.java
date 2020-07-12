package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Task7 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void login() {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        List<WebElement> menu;
        int menuSize = driver.findElements(By.id("app-")).size();

        for (int i = 0; i < menuSize; i++) {
            menu = driver.findElements(By.id("app-"));
            menu.get(i).findElement(By.className("name")).click();
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
