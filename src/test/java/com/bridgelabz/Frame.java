package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Frame<fontSize, fontWeight> {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void Frame() {
        driver.get("file:///D:/sirin/Page2.html");
        driver.switchTo().frame(0);

        driver.findElement(By.id("t1")).sendKeys("a");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("t2")).sendKeys("a");
        driver.switchTo().frame("f1");
        driver.findElement(By.id("t1")).sendKeys("b");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("t2")).sendKeys("b");
        driver.switchTo().frame("n1");
        driver.findElement(By.id("t1")).sendKeys("c");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("t2")).sendKeys("c");
        WebElement f = driver.findElement(By.className("c1"));
        driver.switchTo().frame(f);
        driver.findElement(By.id("t1")).sendKeys("d");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("t2")).sendKeys("d");
        driver.close();
    }
}