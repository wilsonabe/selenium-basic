package com.orphynova.seleniumbasic.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebElementsPractice {
    private String baseURL = "http://qaguru.ca/webelementapp.php";
    WebDriver driver;

    @BeforeTest
    public void BeforeTest(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get(baseURL);
    }
    @AfterMethod
    public void afterMethod(){
    //    driver.quit();
    }

    @Test
    public void RadioButtonCheck(){

        // check if default radio button(male)  enabled
        WebElement radDefault = driver.findElement(By.xpath("//*[@id=\"home-5\"]/form[2]/input[1]"));
        Assert.assertTrue(radDefault.isSelected(),"Male Default Button not selected");

        //Check if different radio button(female) is clicked
        WebElement radSelect = driver.findElement(By.xpath("//*[@id=\"home-5\"]/form[2]/input[2]"));
        radSelect.click();

        //same code can be written as
    //   driver.findElement(By.xpath("//*[@id=\"home-5\"]/form[2]/input[2]")).click();

    }
    @Test
    public void setTextBox(){
        WebElement nameTxtBox = driver.findElement(By.name("firstname"));
        nameTxtBox.clear();
        nameTxtBox.sendKeys("John");

//        Alternatively the code can be written as
//        driver.findElement(By.name("firstname")).clear();
//        driver.findElement(By.name("firstname")).sendKeys("Mary");
    }

    //***************************************************************************************
    // List Box/ Dropdown ListBox operations
    @Test
    public void listBox(){
        WebElement dropListBox = driver.findElement(By.name("cars"));

        // To select a value in the list box - use SELECT class
        Select selList = new Select(dropListBox);
        selList.selectByVisibleText("Audi");

        selList.deselectAll();   // to deselect all values
        selList.selectByIndex(0); // to select a particular value

        //to get values listed in list box
        String selValue = dropListBox.getText();
     //   System.out.println(selValue);
        // Alternatively create a list of webelements
        List<WebElement> listCombo = selList.getOptions();
        for (WebElement list:listCombo){
            System.out.println(list.getText());
        }
    }

    //***********************************************************************************
    @Test
    public void checkBox(){
        WebElement selChkBox = driver.findElement(By.name("vehicle1"));
        selChkBox.click();
    }
//******************************************************************
    @Test
    public void CalendarControl(){
        WebElement dateControl = driver.findElement(By.name("bday"));
        dateControl.sendKeys("10"+ "15" +"1982");
    // in case TAB moves cursor then use Keys.TAB
    //  dateControl.sendKeys("10"+ Keys.TAB +"15" +"1982");
    }

    //*************************************************************************

    @Test
    public void buttonandalert() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"home-5\"]/button")).click();

        Alert alertMsg = driver.switchTo().alert();
        Assert.assertEquals(alertMsg.getText(),"QA GURU!","Incorrect message");
        alertMsg.accept();
    }

    // *****************************************************************************************
    //     SYNCHRONISATION
    // *****************************************************************************
    // IMPLICIT
    @ Test
    public void implicitWait() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("bday")).sendKeys("10"+"15"+"1989");
        }

    //    EXPLICIT WAIT

    @Test
    public void explicitWait(){
        WebDriverWait CalWait = new WebDriverWait(driver,10);
        WebElement CalControl = CalWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("bday")));
        //Alternatively using visibilityOf - above method visibilityOfElementLocated is better
       // WebElement CalControl = CalWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("bday") ) ));
        CalControl.sendKeys("10"+ "25" +"1982");
    }

}
