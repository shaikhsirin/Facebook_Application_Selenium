package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class AutoIt {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

//    @Test
//    public void FileUpload() throws InterruptedException {
//        driver.get("https://demo.automationtesting.in/Register.html");
//        driver.findElement(By.xpath("(//input[@uploader='uploader'])[2]")).click();
//        Thread.sleep(2000);
//        Runtime getRuntime().exec("D:\\sirin\\FileUpload.exe");
//    }


    @Test
    public void AutoIT() throws InterruptedException, AWTException, IOException {
        driver.get("http://www.actimind.com/");

        Thread.sleep(3000);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_P);
        r.keyRelease(KeyEvent.VK_P);
        r.keyRelease(KeyEvent.VK_CONTROL);
        Runtime run = Runtime.getRuntime();
        run.exec("D:\\sirin\\CancelOnPrintWindowpopup.au3");
        driver.close();
    }
}