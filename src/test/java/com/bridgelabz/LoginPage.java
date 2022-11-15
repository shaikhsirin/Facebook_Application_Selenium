package com.bridgelabz;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;


public class LoginPage<fontSize, fontWeight> {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void log() {
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("Sirin");

//        String title = driver.getTitle();
//        System.out.println(title);
//        String url = driver.getCurrentUrl();
//        System.out.println(url);
//        String source = driver.getPageSource();
//        System.out.println(source);
//        driver.navigate().to("https://www.flipkart.com/");
//        driver.navigate().back();
//        driver.navigate().refresh();
//        driver.navigate().forward();

    }

    @Test
    public void login() throws InterruptedException, IOException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("asdfasdf");
        driver.findElement(By.xpath("//input[contains(@id,'pas')]")).sendKeys("hgfjhj");
        driver.findElement(By.xpath("//button[contains(text(),'Log')]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500)");
        Thread.sleep(2000);
    }

    @Test
    public void Using_RobotClass() throws InterruptedException, IOException, AWTException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        // Robot robot = new Robot();
        driver.findElement(By.cssSelector("input#pass")).sendKeys("thftuuj");
        driver.findElement(By.partialLinkText("Forgotten")).click();
        String title = driver.getTitle();
        System.out.println(title);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String source = driver.getPageSource();
        System.out.println(source);
        Thread.sleep(5000);
        driver.navigate().to("https://www.flipkart.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        //driver.close
    }

    @Test
    public void Using_contextClick_Method() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement MobNum = driver.findElement(By.xpath("//input[@id='email']"));
        Actions actions = new Actions(driver);
        actions.contextClick(MobNum).perform();
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void Using_DragAndDrop_Method() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement des = driver.findElement(By.xpath("//p[text()='Drop here']"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
//        actions.moveToElement(src).clickAndHold().perform();
//        actions.release(des).perform();
        actions.dragAndDrop(src, des).perform();
        driver.close();
    }

    @Test
    public void Using_Google_ShortCut() throws InterruptedException, IOException, AWTException {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.name("q"));
        Actions action = new Actions(driver);
        action.sendKeys("selenium").perform();
        Thread.sleep(2000);
        action.keyDown(Keys.CONTROL).sendKeys("A").perform();
        action.keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
        action.keyDown(Keys.CONTROL).sendKeys("c").perform();
        action.keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
        action.keyDown(Keys.CONTROL).sendKeys("t").perform();
        action.keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
        action.keyDown(Keys.CONTROL).sendKeys("v").perform();
        action.keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void Using_Double_Click_Method() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement MobNum = driver.findElement(By.id("email"));
        WebElement Pass = driver.findElement(By.id("pass"));
        actions.doubleClick(Pass).perform();
        Thread.sleep(2000);
        actions.doubleClick(MobNum).perform();
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void Active_Element() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.switchTo().activeElement().sendKeys("sara");
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void Scroll_UpAndDown() throws InterruptedException {
        driver.get("https://www.seleniumhq.org/download/");
        driver.findElement(By.id("close")).click();
        WebElement element = driver.findElement(By.id("footerLogo"));
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();
        System.out.println("X cordinate is: " + x + "and Y cordinate is:" + y);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        Thread.sleep(3000);
        element.click();
    }

    @Test
    public void BrowserNavigationExample() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.navigate().to("http://www.gmail.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.close();
    }

    @Test
    public void Keyboard_Mouse_Operation() throws InterruptedException, AWTException {
        driver.navigate().to("http://www.gmail.com");
        Thread.sleep(5000);
        Robot r = new Robot();
        r.mouseMove(300, 500);
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_F);
        r.keyRelease(KeyEvent.VK_F);
        r.keyRelease(KeyEvent.VK_ALT);
        Thread.sleep(3000);
        r.keyPress(KeyEvent.VK_W);
        r.keyRelease(KeyEvent.VK_W);
        Thread.sleep(3000);
        driver.quit();

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

    @Test
    public void CheckBox_selectedorNot() {
        driver.get("https://demo.actitime.com/");
        WebElement KeepMeLogIN_Checkbox = driver.findElement(By.name("remember"));
//select the checkbox
        KeepMeLogIN_Checkbox.click();
        if (KeepMeLogIN_Checkbox.isSelected()) {
            System.out.println("Checkbox is selected");
        } else {
            System.out.println("Checkbox is NOT selected");
        }
    }

    @Test
    public void PrintVersion_ActitimeLoginPage() {
        driver.get("https://demo.actitime.com/");
        String xpathforVersion = "//nobr[contains(text(),'actiTIME')]";
        String version = driver.findElement(By.xpath(xpathforVersion)).getText();
        System.out.println("Version of actitime on login page is : " + version);
    }

    @Test
    public void enterText_intoDisabledTextbox() throws InterruptedException {

        driver.get("file:///D:/sirin/DisabledTextBox.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("document.getElementById('t1').value='admin'");
        Thread.sleep(2000);
        js.executeScript("document.getElementById('t2').value=''");
        js.executeScript("document.getElementById('t2').value='manager'");
        js.executeScript("document.getElementById('t2').type='button'");
    }



    @Test
    public void WebTable() {

        driver.get("file:///D:/sirin/WebTable.html");
        java.util.List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
        int totalRows = allRows.size();
        System.out.println("total number of rows present in the table is :" + totalRows);
        java.util.List<WebElement> allColumns = driver.findElements(By.xpath("//th"));

        int totalColumns = allColumns.size();
        System.out.println("Total number of columns in the table is :" + totalColumns);
        List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
        int totalCells = allCells.size();
        System.out.println("Total number of cells present in the table is :" + totalCells);
        int countNumberValue = 0;
        int sum = 0;
        for (WebElement cell : allCells) {
            String cellValue = cell.getText();
            try {
                int number = Integer.parseInt(cellValue);
                System.out.print(" " + number);
                countNumberValue++;
                sum = sum + number;
            } catch (Exception e) {
            }
        }
        System.out.println("Total count of numeric values is :" + countNumberValue);
        System.out.println("Total sum of all the numeric values is :" + sum);
        driver.close();
    }
}