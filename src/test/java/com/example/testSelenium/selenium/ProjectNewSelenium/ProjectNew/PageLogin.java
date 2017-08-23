package com.example.testSelenium.selenium.ProjectNewSelenium.ProjectNew;

import com.example.testSelenium.selenium.Page.PageClass.PageMoveMouse;
import com.example.testSelenium.selenium.ProjectNewSelenium.Verify.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.example.testSelenium.selenium.ProjectNewSelenium.Verify.Verify.*;
import static org.junit.Assert.assertEquals;

public class PageLogin {

    private static WebDriver driver;
    private static String LOGIN_EMAIL ="higor.freitas@neppoadm.com.br";
    private static String LOGIN_PASSWORD = "1234567890";
    private static String LOGIN_NOTFOUND= "Lucas..@neppoadm.com.br";

    public PageLogin(WebDriver driver){
        this.driver = driver;
    }

    public void loginSuccess()throws Exception{

        String expectedH2 = "HReports";

        if (expectedH2.equals(driver.findElement(By.xpath("//div/div/div/form/h2")).getText())){

            verifyElementClickable(By.id("loginEmail"));
            verifyElement(By.id("loginEmail"),LOGIN_EMAIL);

            verifyElementClickable(By.xpath("//div/form/div[2]/div/label"));
            verifyElement(By.id("loginPassword"),LOGIN_PASSWORD);

            Thread.sleep(1000);

            verifyElementClickable(By.xpath("//div/form/div[3]/div[1]/label"));

            verifyExisting(By.name("action"));
            verifyElementClickable(By.name("action"));


        }else
            System.out.println("ERROR SERVICE");
    }

    public void loginErrorNotFound() throws Exception{

        driver.get("http://localhost:8080/#/hreports/login");

        verifyElementClickable(By.id("loginEmail"));
        verifyElement(By.id("loginEmail"),LOGIN_NOTFOUND);

        verifyElementClickable(By.xpath("//div/form/div[2]/div/label"));
        verifyElement(By.id("loginPassword"),LOGIN_PASSWORD);

        Thread.sleep(1000);

        verifyElementClickable(By.xpath("//div/form/div[3]/div[1]/label"));

        verifyExisting(By.name("action"));
        verifyElementClickable(By.name("action"));

        Thread.sleep(1000);
        assertEquals("  Algo deu errado",
                driver.findElement(By.xpath("//*[@id='toast-container']/div/div/span")).getText());

    }

    public void loginTurnOff() throws Exception{

        loginSuccess();

        PageMoveMouse moveMouse = new PageMoveMouse(driver);
        moveMouse.moveMouseMenu(By.xpath("//nav/div/ul[1]/li[3]/a/i"));
        moveMouse.moverMouseNovo(By.xpath("//*[@id='Perfil']/li[2]/a"));

    }
}
