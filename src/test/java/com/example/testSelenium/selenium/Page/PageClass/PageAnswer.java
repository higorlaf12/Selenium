package com.example.testSelenium.selenium.Page.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.example.testSelenium.selenium.Page.Verify.Verify.*;
import static org.junit.Assert.assertEquals;

public class PageAnswer {

    static WebDriver webDriver;

    public PageAnswer(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void answerTable() throws Exception{
        webDriver.get("http://localhost:8080/#/hreports");
        assertEquals("Atividades no Sistemas",webDriver.findElement(By.xpath("//div[1]/div[1]/h5")).getText());

        verifyElementClickable(By.xpath("//div/table/tbody/tr[1]"));

        assertEquals("Pizza and Beer",webDriver.findElement(By.xpath("//div/div[1]/div/h4")).getText());

        verifyElementClickable(By.xpath("//div[3]/div[1]/div/div/div[1]/label"));

        verifyElementClickable(By.xpath("//div[3]/div[2]/div/div[2]/textarea"));
        verifyElement(By.xpath("//div[3]/div[2]/div/div[2]/textarea"),"Test Selenium");

        verifyElementClickable(By.xpath("//div[3]/div[3]/div/div/div[6]/label"));

        verifyExisting(By.xpath("//div/div[4]/div/a"));
        verifyElementClickable(By.xpath("//div/div[4]/div/a"));

        Thread.sleep(1000);

        verifyExisting(By.xpath("//div[3]/div/div[2]/div/a"));
        verifyElementClickable(By.xpath("//div[3]/div/div[2]/div/a"));
    }
}
