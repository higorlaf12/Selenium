package com.example.testSelenium.selenium.Page;

import com.example.testSelenium.selenium.Verify.Verify;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    static WebDriver webDriver;
    static String USER_EMAIL = "higor.freitas@neppoadm.com.br";
    static String USER_LOGIN = "1234567890";
    static String USER_LOGIN_ERROR="25785485185";

    public LoginTest(WebDriver driver) {
        this.webDriver = driver;
    }

    public void fillField () {

        WebElement element = webDriver.findElement(By.xpath("//input[@id ='loginEmail']"));
        element.sendKeys("higor.freitas@neppoadm.com.br");

        WebElement element1 = webDriver.findElement(By.xpath("//input[@id ='loginPassword']"));
        element1.sendKeys("1234567890");

        WebElement button = webDriver.findElement(By.xpath("//button[@name ='action']"));
        button.click();
    }

    public void loginErrorNotFoud() throws Exception{
        webDriver.get("http://localhost:8080/#/hreports/login");
        Verify.verifyElement(By.xpath("//input[@id ='loginEmail']"),USER_EMAIL);
        Verify.verifyElement(By.xpath("//input[@id ='loginPassword']"),USER_LOGIN_ERROR);
        Verify.verifyElement(By.xpath("//button[@name ='action']"),null);


        assertEquals("  Algo deu errado",
                webDriver.findElement(By.xpath("//*[@id='toast-container']/div/div/span")).getText());

//        Verify.verifyExisting();
//        Alert alert = webDriver.switchTo().alert();
//        alert.accept();

//        String expectedMessage = "The Institution is deleted Successfully!";
//        String message = driver.findElement(By.xpath("//div[contains(@class,'callout callout-success')]")).getText();
//        Assert.assertTrue("Your error message", message.contains(expectedMessage))


    }

}