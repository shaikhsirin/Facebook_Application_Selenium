package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Action<fontSize, fontWeight> {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void ContextClickusingActionsClass() throws InterruptedException, AWTException {
        driver.get("https://demo.actitime.com/");
        WebElement link = driver.findElement(By.linkText("actiTIME Inc."));
        Actions actions = new Actions(driver);
        actions.contextClick(link).perform();
        Thread.sleep(3000);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_W);
        r.keyRelease(KeyEvent.VK_W);
        driver.quit();
    }

    @Test
    public void gmail_contextClick_mailArchive() throws InterruptedException {

        driver.get("https://www.gmail.com");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sirinshaikh942@gmail.com");
        driver.findElement(By.xpath("//span[.='Next']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("sirin123 ");
        driver.findElement(By.xpath("//span[.='Next']")).click();
        Thread.sleep(10000);
        String xp = "(//b[contains(.,'Following Openings (for Bangalore)')])[2]";
        WebElement mail = driver.findElement(By.xpath(xp));
        System.out.println(mail.getText());
        Actions actions = new Actions(driver);
        actions.contextClick(mail).perform();
        Thread.sleep(6000);
        driver.findElement(By.xpath("(//div[@class='J-N-JX aDE aDD'])[1]")).click();
    }

    @Test
    public void DropdownMenu() {
        driver.get("http://www.actimind.com/");
        String xp = "//span[.='About Company']";
        WebElement menu = driver.findElement(By.xpath(xp));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
        WebElement submenu = driver.findElement(By.linkText("Basic Facts"));
        submenu.click();
    }

    @Test
    public void MouseHover() {

        driver.get("http://www.actimind.com/");
        Actions action = new Actions(driver);

        WebElement AreaOfExpertise = driver.findElement(By.xpath("//a[contains(text(),'AREAS OF EXPERTISE')]"));
        action.moveToElement(AreaOfExpertise).perform();
        WebElement cloudApp = driver.findElement(By.linkText("Cloud Applications"));
        action.moveToElement(cloudApp).click().perform();
    }
}