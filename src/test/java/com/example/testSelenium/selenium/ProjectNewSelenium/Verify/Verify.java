package com.example.testSelenium.selenium.ProjectNewSelenium.Verify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Verify {
    private static WebDriver driver;

    public Verify(WebDriver driver){
        this.driver = driver;
    }

    public static void verifyElement(By element, String sendKeys){

        WebDriverWait wait = new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));

        driver.findElement(element).sendKeys(sendKeys);
    }

    public static void verifyElementClickable(By element){

        WebDriverWait wait = new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));

        driver.findElement(element).click();
    }

    public static void verifyExisting(By element){
        WebDriverWait wait = new WebDriverWait(driver,180);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
