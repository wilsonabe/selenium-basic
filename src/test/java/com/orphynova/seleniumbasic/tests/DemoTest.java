package com.orphynova.seleniumbasic.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTest {
    private final String baseURL = "https://www.homeandstuff.com";

    @Test
    public void testHomePageTitle() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);

        //meta name in source
        String expTitle = "Furniture, Kitchen, Dining Room, Entertainment, Bedroom Sets, Outdoor, Fireplaces";
        String actTitle = driver.getTitle();
        Assert.assertEquals(expTitle,actTitle,"Incorrect Webpage Title");
        Thread.sleep(2000);
       driver.close(); // only closes the window

    }
    @BeforeTest
    public void beforeTest(){
     //   WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void CloseBrowser(){
    //    driver.quit(); // instance is quit

    }
}
