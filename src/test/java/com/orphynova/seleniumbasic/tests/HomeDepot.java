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

public class HomeDepot {
    private final String baseURL = "https://www.homedepot.ca/en/home.html";
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
        String expTitle = "Home Improvement, Home Renovation, Tools, & Hardware | The Home Depot Canada";
        String actTitle = driver.getTitle();
        Assert.assertEquals(expTitle,actTitle,"Incorrect Webpage Title");
//        Thread.sleep(2000);
    }

    @Test
    public void testSearchingForAProduct()  {

        WebElement txtSearch = driver.findElement(By.xpath("//*[@id=\"gheader-autosuggest-input\"]"));
        txtSearch.clear();
        txtSearch.sendKeys("tables");


        driver.findElement(By.xpath("/html/body/app-container/div[1]/srp-landing-page/global-header-container/store-selector-wrapper/hdca-dialog/div/div[1]/div/store-selector/div/div[2]/div[1]/div[2]/div/div[1]/div[3]/div/button[1]/span")).click();

        driver.findElement(By.id("gheader-autosuggest-input-submit")).click();
        driver.findElement(By.xpath("//*[@id=\"gheader-autosuggest-input-submit\"]/acl-icon/svg")).click();

//        (Below code can be shortened as above)
//        WebElement btnSearch = driver.findElement(By.xpath("//*[@id=\"gheader-autosuggest-input-submit\"]/acl-icon/svg"));
//        btnSearch.click();
    }

    @AfterMethod
    public void CloseBrowser(){
         //   driver.quit(); // instance is quit

    }
}