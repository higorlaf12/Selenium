package com.example.testSelenium.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static com.example.testSelenium.selenium.Executaveis.InternetExplorer.executExplorer;

public class SeleniumTest {

    static WebDriver webDriver;

    @BeforeClass
    public static void setWebDriver() throws Exception{
            System.setProperty("webdriver.chrome.driver","E:/Program Files/chromedriver_win32/chromedriver.exe");
            webDriver = new ChromeDriver();
//        executExplorer();
//     webDriver = new InternetExplorerDriver();
//     webDriver.get("https://www.youtube.com.br");
        System.out.println(webDriver.getTitle());
        WebElement element = webDriver.findElement(By.xpath("//input[@name='search_query']"));
        element.sendKeys("musicas eletronicas");

        WebElement button = webDriver.findElement(By.xpath("//button[@id ='register-btn']"));
        button.click();
    }

    @Test
    public void test() {

    }

    @AfterClass
    public static void testDownAfterClass() throws Exception{

        webDriver.close();
        webDriver.quit();
    }

}
