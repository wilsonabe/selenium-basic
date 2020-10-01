package com.orphynova.seleniumbasic.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTest {
    private final String baseURL = "https://www.homeandstuff.com";
    private WebDriver driver;


    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
     public void beforeMethod(){
        driver = new ChromeDriver();
        driver.get(baseURL);
    }

    @Test
    public void testHomePageTitle() throws InterruptedException {

        //meta name in source
        String expTitle = "Furniture, Kitchen, Dining Room, Entertainment, Bedroom Sets, Outdoor, Fireplaces";
        String actTitle = driver.getTitle();
        Assert.assertEquals(expTitle,actTitle,"Incorrect Webpage Title");
//        Thread.sleep(2000);
//       driver.close(); // only closes the window
    }

    @Test
    public void testSearchingForAProduct()  {
               //meta title in source
        String expTitle = "Furniture, Kitchen, Dining Room, Entertainment, Bedroom Sets, Outdoor, Fireplaces";
        String actTitle = driver.getTitle();
        Assert.assertEquals(expTitle,actTitle,"Incorrect Webpage Title");

        WebElement txtSearch = driver.findElement(By.name("search_field"));
        txtSearch.clear();
        txtSearch.sendKeys("table");

        WebElement btnSearch = driver.findElement(By.xpath("//*[@id=\"search\"]/form/div/span/input" ));
        btnSearch.click();

        WebElement linkTest = driver.findElement(By.linkText("Atlantic Height Adjustable Standing Desk Converter Large"));
        linkTest.click();
    }

    @AfterMethod
    public void CloseBrowser(){
        driver.quit(); // instance is quit
    }
}
