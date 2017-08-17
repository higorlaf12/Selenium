package com.example.testSelenium.selenium.Verify;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Verify {
    static WebDriver webDriver;

    public Verify(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static void verifyElement(By element, String sendKeys) {
        WebDriverWait wait = new WebDriverWait(webDriver, 300);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));

        WebElement element1 = webDriver.findElement(element);
        if (sendKeys == null) {
            element1.click();
        } else {
            element1.sendKeys(sendKeys);
        }
    }

    public static void verifyExisting(By element) {
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void verifyLoop(List<String> nameElement) throws Exception {

        List<WebElement> webElement = webDriver.findElements(By.xpath("//div/div[3]/div/table/tbody/tr"));

        for (int x = 1; x <= webElement.size(); x++) {

            List<WebElement> webDriverElements = webDriver.findElements(By.xpath("//div/div[3]/div/table/tbody/tr[" + Integer.toString(x) + "]"));

            for (WebElement element1 : webDriverElements) {

                WebElement element = webDriver.findElement(By.xpath("//div[3]/div/table/tbody/tr[" + Integer.toString(x) + "]/td[4]/span"));
                element.click();

                Thread.sleep(1000);

                element1 = webDriver.findElement(By.xpath("//div/div[3]/div/table/tbody/tr[" + Integer.toString(x) + "]/td[2]/input"));
                element1.click();
                element1.sendKeys(Keys.CONTROL + "a");
                element1.sendKeys(Keys.DELETE);
                element1.sendKeys(nameElement.get(x - 1));

                Thread.sleep(1000);

                webDriver.findElement(By.xpath("//div[3]/div/table/tbody/tr[" + Integer.toString(x) + "]/td[4]/span")).click();
                webDriver.findElement(By.xpath("//div/div[3]/div/table/tbody/tr[" + Integer.toString(x) + "]/td[5]/div[1]/span")).click();
                webDriver.findElement(By.xpath("//div/div[3]/div/table/tbody/tr[" + Integer.toString(x) + "]/td[5]/div[2]/span")).click();
            }
        }

    }
}
