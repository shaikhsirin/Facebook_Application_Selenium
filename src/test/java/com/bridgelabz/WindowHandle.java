package com.bridgelabz;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandle<fontSize, fontWeight> {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void Print_windowHandle() {
        driver.get("http://www.actimind.com/");
        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);
    }

    @Test
    public void ChildBrowserPopUp() {
        driver.get("http://www.actimind.com/");
        Set<String> allWindowHandles = driver.getWindowHandles();
        int count = allWindowHandles.size();
        System.out.println("Number of browser windows opened on the system is : " + count);
        for (String windowHandle : allWindowHandles) {
            driver.switchTo().window(windowHandle);
            String title = driver.getTitle();
            System.out.println("Window handle id of page -->" + title + " --> is : " + windowHandle);
            driver.close();
        }
    }

    @Test
    public void CloseALLChildbrowsersONLY() {
        driver.get("http://www.actimind.com/");
        String parentWindowhandleID = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        int count = allWindowHandles.size();

        System.out.println("Number of browser windows opened on the system is : " + count);
        for (String windowHandle : allWindowHandles) {
            driver.switchTo().window(windowHandle);
            String title = driver.getTitle();
            if (!windowHandle.equals(parentWindowhandleID)) {
                driver.close();
                System.out.println("Child Browser window with title -->" + title + " --> is closed");
            }
        }
    }

    @Test
    public void CloseAnySpecifiedBrowser() {
        driver.get("https://www.naukri.com/");
        String expected_title = "Tech Mahindra";
        Set<String> allWindowHandles = driver.getWindowHandles();
        int count = allWindowHandles.size();
        System.out.println("Number of browser windows opened on the system is : " + count);
        for (String windowHandle : allWindowHandles) {
            driver.switchTo().window(windowHandle);

            String actual_title = driver.getTitle();
            if (actual_title.contains(expected_title)) {
                driver.close();
                System.out.println("Specified Browser window with title -->" + actual_title + " --> is closed");
            }
        }
    }

    @Test
    public void HandleTabs_using_getWindowHandles() {
        driver.get("http://www.actimind.com/");
        String parentwindowHandle = driver.getWindowHandle();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.name("pwd")).sendKeys("manager");
        driver.findElement(By.xpath("//a[text()='actiTIME Inc.']")).click();

        Set<String> allwhs = driver.getWindowHandles();
        for (String wh : allwhs) {
            driver.switchTo().window(wh);
        }
        String childtitle = driver.getTitle();
        System.out.println("Title of the child tab is :" + childtitle);
        driver.close();
        driver.switchTo().window(parentwindowHandle);
        driver.findElement(By.xpath("//div[text()='Login ']")).click();
        driver.close();

    }
}