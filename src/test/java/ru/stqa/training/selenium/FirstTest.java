package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTest {

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
    public void myFirstTest() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
