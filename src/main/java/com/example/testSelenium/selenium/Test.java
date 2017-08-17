package com.example.testSelenium.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:/ArquivosProgramaJava/geckodriver-v0.18.0-win64/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/");
        WebElement element = driver.findElement(By.xpath("//input[@name='emailid']"));
        element.sendKeys("abc.gmail.com");

        WebElement button = driver.findElement(By.xpath("//input[@name='btnLogin']"));
        button.click();
    }
}
