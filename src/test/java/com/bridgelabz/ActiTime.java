package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class ActiTime<fontSize, fontWeight> {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void Actitime() throws InterruptedException {
        driver.get("file:///C:/Users/HP/Desktop/Siri.html");
        WebElement unTB = driver.findElement(By.id("Sirin"));
        unTB.clear();
        unTB.sendKeys("sirinshaikh942@gmail.com");
        WebElement passTB = driver.findElement(By.name("n1"));
        passTB.clear();
        Thread.sleep(5000);

        passTB.sendKeys("Qspiders123");
        driver.findElement(By.linkText("Click ActiTIME link")).click();
        Thread.sleep(2000);
    }

    @Test
    public void Xpth_Using_Actitime() throws InterruptedException {
        driver.get("https://demo.actitime.com/");
        String xp = "//input[@class='textField'][ @id = 'username']";
        Thread.sleep(2000);
        driver.findElement(By.xpath(xp)).sendKeys("admin");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("manager");
        Thread.sleep(2000);
        WebElement clock = driver.findElement(By.xpath("//img[contains(@src,'Time')]"));
        String widthValue = clock.getAttribute("width");
        System.out.println("the width is :" + widthValue);
        System.out.println("the height of the clock element is : " + clock.getAttribute("height"));
        driver.findElement(By.xpath("//div[text()='Login ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='loginButton']//div[contains(text(),'Login')]")).click();
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void VerifyhomepageUsingTitle() throws InterruptedException {

        driver.get("https://demo.actitime.com/");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.name("pwd")).sendKeys("manager");
        driver.findElement(By.xpath("//div[.='Login ']")).click();
        Thread.sleep(3000);
        String expectedTitle = "Enter Time";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Home page is displayed");
        } else {
            System.out.println("Home page is NOT displayed");

        }
    }

    @Test
    public void VerifyhomepageUsingUrl() throws InterruptedException {
        driver.get("https://demo.actitime.com/");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.name("pwd")).sendKeys("manager");
        driver.findElement(By.xpath("//div[.='Login ']")).click();
        Thread.sleep(3000);
        String expectedUrl = "submit";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Home page is displayed");
        } else {
            System.out.println("Home page is NOT displayed");
        }
    }

    @Test
    public void VerifyhomepageUsingUniqueElement() throws InterruptedException {

        driver.get("https://demo.actitime.com/");
        driver.findElement(By.id("username")).sendKeys("admin");

        driver.findElement(By.name("pwd")).sendKeys("manager");
        driver.findElement(By.xpath("//div[.='Login ']")).click();
        Thread.sleep(3000);
        WebElement logoutBtn = driver.findElement(By.xpath("//a[.='Logout']"));
        if (logoutBtn.isDisplayed()) {
            System.out.println("Home page is displayed");
        } else {
            System.out.println("Home page is NOT displayed");
        }
    }

    @Test
    public void VerifyUNandPWDalignment() {
        driver.get("https://demo.actitime.com/");
        WebElement unTB = driver.findElement(By.id("username"));
        int un_x = unTB.getLocation().getX();
        int un_width = unTB.getSize().getWidth();

        int un_height = unTB.getSize().getHeight();
        WebElement pwTB = driver.findElement(By.name("pwd"));
        int pw_x = pwTB.getLocation().getX();
        int pw_width = pwTB.getSize().getWidth();
        int pw_height = pwTB.getSize().getHeight();
        if (un_x == pw_x && un_width == pw_width && un_height == pw_height) {
            System.out.println("Username and password text box are aligned");
        } else {
            System.out.println("Username and password text box are NOT aligned");
        }
    }

    @Test
    public void RemoveValuefromText_usingClearMethod() throws InterruptedException {
        driver.get("https://demo.actitime.com/");
        driver.findElement(By.id("username")).sendKeys("sirin");
        Thread.sleep(2000);

        String value = driver.findElement(By.id("username")).getAttribute("value");
        System.out.println("Value present inside the text box is : " + value);
        driver.findElement(By.id("username")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("username")).sendKeys("againEnteredSirin");
        Thread.sleep(2000);
        driver.findElement(By.id("username")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        Thread.sleep(2000);
    }

    @Test
    public void PrintTooltip_Actitime_RememberCheckbox() {
        driver.get("https://demo.actitime.com/");
        WebElement Checkbox = driver.findElement(By.id("keepLoggedInCheckBox"));
        String tooltipText = Checkbox.getAttribute("title");
        System.out.println(tooltipText);
        driver.close();
    }
}