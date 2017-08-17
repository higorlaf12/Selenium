package com.example.testSelenium.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumHrports {

    static WebDriver webDriver;

    @BeforeClass
    public static void init () throws Exception{
        System.setProperty("webdriver.chrome.driver","E:/Program Files/chromedriver_win32/chromedriver.exe");
        webDriver = new ChromeDriver();

        webDriver.get("http://localhost:8080/#/hreports/login");


        WebElement element = webDriver.findElement(By.xpath("//input[@id ='loginEmail']"));
        element.sendKeys("higor.freitas@neppoadm.com.br");

        WebElement element1 = webDriver.findElement(By.xpath("//input[@id ='loginPassword']"));
        element1.sendKeys("1234567890");

        WebElement button = webDriver.findElement(By.xpath("//button[@name ='action']"));
        button.click();
    }

    @Test
    public void test(){

    }

    @AfterClass
    public static void finalizado () throws Exception{
        //webDriver.close();
        webDriver.quit();
    }
}
