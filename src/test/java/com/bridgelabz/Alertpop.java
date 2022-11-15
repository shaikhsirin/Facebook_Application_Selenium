package com.bridgelabz;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alertpop{
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void simple_Alert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        System.out.println(alert.getText());
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
    }

    @Test
    public void simple_Alert2() {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.findElement(By.id("timerAlertButton")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

    }

    @Test
    public void Confirmation_PopUp() {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.findElement(By.id("confirmButton")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
    }

    @Test
    public void Prompt_PopUp() {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        JavascriptExecutor jsexe = (JavascriptExecutor) driver;
        jsexe.executeScript("window.scrollBy(0,100)");
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Sirin");
        alert.accept();
    }

    @Test
    public void Alert_Box() {
        driver.get("https://nxtgenaiacademy.com/alertandpopup/");
        driver.manage().window().maximize();
        driver.findElement(By.name("alertbox")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
}