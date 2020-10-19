package com.orphynova.seleniumbasic.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
}
