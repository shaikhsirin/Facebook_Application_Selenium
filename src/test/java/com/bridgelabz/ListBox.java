package com.bridgelabz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class ListBox {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void ListBoxExample() {
        driver.get("file:///D:/sirin/ListBox_Breakfast.html");
        WebElement list = driver.findElement(By.id("mtr"));
        Select s = new Select(list);
        List<WebElement> options = s.getOptions();
        int size = options.size();
        System.out.println("Number of elements present inside the listbox is : " + size);
        for (WebElement webElement : options) {
            String text = webElement.getText();
            System.out.println(text);
        }
        s.selectByIndex(0);
        s.selectByValue("v");
        s.selectByVisibleText("POORI");
        System.out.println("************Print all selected options***********");
        List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
        int size2 = allSelectedOptions.size();
        System.out.println("Number of items that is selected in the list box is : " + size2);
        System.out.println(" Selected items are printed below ");
        for (WebElement webElement : allSelectedOptions) {
            System.out.println(webElement.getText());
        }
        System.out.println("check whether it is a multiple select listbox or not");
        boolean multiple = s.isMultiple();
        System.out.println(multiple + " yes , it is multi select");
        if (multiple) {
            WebElement firstSelectedOption = s.getFirstSelectedOption();

            System.out.println(firstSelectedOption.getText() + " is the first selected item in the list box");
            s.deselectByIndex(0);
            WebElement firstSelectedOption1 = s.getFirstSelectedOption();
            System.out.println(firstSelectedOption1.getText() + " is the first selected item");
            s.deselectByValue("v");
            WebElement firstSelectedOption2 = s.getFirstSelectedOption();
            System.out.println(firstSelectedOption2.getText() + " is the first selected item");
            s.deselectByVisibleText("POORI");
        }
    }

    @Test
    public void PrintListValues_SortedOrder() {
        driver.get("file:///D:/sirin/ListBox_Breakfast.html");
        WebElement listElement = driver.findElement(By.id("mtr"));
        Select s = new Select(listElement);
        List<WebElement> allOptions = s.getOptions();
        int count = allOptions.size();
        System.out.println(count);
        System.out.println("-----print the values in the list ----");
        ArrayList<String> list = new ArrayList<String>();
        for (WebElement option : allOptions) {
            String text = option.getText();
            System.out.println(text);

            list.add(text);
        }
        Collections.sort(list);
        System.out.println("-----print the value in sorted order----");
        for (String value : list) {
            System.out.println(value);

        }
    }

    @Test
    public void printUniqueElementinthelistbox() {
        driver.get("file:///D:/sirin/ListBox_Breakfast.html");
        WebElement listElement = driver.findElement(By.id("mtr"));
        Select s = new Select(listElement);
        List<WebElement> allOptions = s.getOptions();
        int count = allOptions.size();
        System.out.println(count);
        System.out.println("-----print the values in the list ----");
        HashSet<String> allElements = new HashSet<String>();
        for (WebElement option : allOptions) {
            String text = option.getText();
            System.out.println(text);

            allElements.add(text);
        }
        System.out.println(allElements);
    }

    @Test
    public void checklisthasDUPLICATEvalues_HashSet() {

        driver.get("file:///D:/sirin/ListBox_Breakfast.html");
        WebElement listbox = driver.findElement(By.id("mtr"));
        Select s = new Select(listbox);
        List<WebElement> allOptions = s.getOptions();
        int count1 = allOptions.size();
        System.out.println("Number of elements in the list is :" + count1);
        HashSet<String> allElementText = new HashSet<String>();
        for (int i = 0; i < count1; i++) {
            String text = allOptions.get(i).getText();
            System.out.println(text);
            allElementText.add(text);
        }
        int count2 = allElementText.size();
        System.out.println("Number of elements in the hashset is :" + count2);
        if (count1 == count2) {
            System.out.println("list box has NO duplicate values");
        } else {
            System.out.println("list box has duplicate values");
        }

        System.out.println(allElementText);
        driver.close();
    }

    @Test
    public void PrinttheDUPLICATEItem_intheList_HashSet() {
        driver.get("file:///D:/sirin/ListBox_Breakfast.html");
        WebElement listbox = driver.findElement(By.id("mtr"));
        Select s = new Select(listbox);
        List<WebElement> allOptions = s.getOptions();
        int count1 = allOptions.size();
        System.out.println("Number of elements in the list is :" + count1);
        HashSet<String> allElementText = new HashSet<String>();
        for (int i = 0; i < count1; i++) {
            String text = allOptions.get(i).getText();
            if (!allElementText.add(text)) {
                System.out.println(text + " is the duplicate item in the list box");
            }
        }
        System.out.println(allElementText.size());
        System.out.println(allElementText);
        driver.close();
    }

    @Test
    public void HashMapExample_printtheOcuuranceOfPoori() {
        driver.get("file:///D:/sirin/ListBox_Breakfast.html");

        WebElement list = driver.findElement(By.id("mtr"));
        Select s = new Select(list);
        List<WebElement> allElements = s.getOptions();

        HashMap<String, Integer> hashMapObj = new HashMap<String, Integer>();
        for (WebElement element : allElements) {

            String text = element.getText();
            if (hashMapObj.containsKey(text)) {
                Integer value = hashMapObj.get(text);
                value++;
                hashMapObj.put(text, value);
            } else {
                hashMapObj.put(text, 1);
            }
        }
        Set<String> allKeys = hashMapObj.keySet();
        for (String key : allKeys) {
            Integer value = hashMapObj.get(key);
            System.out.println(key + " -->" + value);

            if (value > 1) {
                System.out.println("Occurance of " + key + " is :" + value);

            }
        }
    }

}