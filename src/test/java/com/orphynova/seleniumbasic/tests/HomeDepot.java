package com.orphynova.seleniumbasic.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeDepot {
    private final String baseURL = "https://www.homedepot.ca/en/home.html";

    @Test
    public void testHomePageTitle() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);

        //meta name in source
        String expTitle = "Home Improvement, Home Renovation, Tools, & Hardware | The Home Depot Canada";
        String actTitle = driver.getTitle();
        Assert.assertEquals(expTitle,actTitle,"Incorrect Webpage Title");
//        Thread.sleep(2000);
        driver.close(); // only closes the window

    }

    @Test
    public void testSearchingForAProduct()  {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);

        //meta title in source
        String expTitle = "Home Improvement, Home Renovation, Tools, & Hardware | The Home Depot Canada";
        String actTitle = driver.getTitle();
        Assert.assertEquals(expTitle,actTitle,"Incorrect Webpage Title");

        WebElement txtSearch = driver.findElement(By.xpath("//*[@id=\"gheader-autosuggest-input\"]"));
        txtSearch.clear();
        txtSearch.sendKeys("tables");

        WebElement btnSearch = driver.findElement(By.xpath("//*[@id=\"gheader-autosuggest-input-submit\"]/acl-icon/svg"));
        btnSearch.click();
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