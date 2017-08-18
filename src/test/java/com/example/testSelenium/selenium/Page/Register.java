package com.example.testSelenium.selenium.Page;

import com.example.testSelenium.selenium.Verify.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Register {
    static WebDriver webDriver;
    static String USER_NAME = "Romero Junior Freitas";
    static String USER_EMAIL = "romeroJuu@gmail.com";
    static String USER_CPF = "01234567897";
    static String NICK_ACCESS = "RomeroJJFreitas";
    static String PASSWORD_AGE = "02587963";
    static String NEW_PASSWORD = "124578963";

    public Register(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void register() throws Exception {
        webDriver.get("http://localhost:8080/#/hreports/profileconfig");

        Verify.verifyElementClick(By.cssSelector("#Perfil > li > a"));
        Thread.sleep(1000);
        Verify.verifyElement(By.id("complet-name"), USER_NAME);
        Thread.sleep(1000);
        Verify.verifyElement(By.id("email"), USER_EMAIL);
        Thread.sleep(1000);
        Verify.verifyElement(By.id("cpf"), USER_CPF);

        webDriver.findElement(By.cssSelector("select.browser-default")).click();
        new Select(webDriver.findElement(By.cssSelector("select.browser-default"))).selectByVisibleText("Administração");
        webDriver.findElement(By.cssSelector("option[value='1']")).click();
        Thread.sleep(1000);

        Verify.verifyElementClick(By.xpath("//div[1]/div[3]/div[2]/div[5]/select"));
        new Select(webDriver.findElement(By.xpath("//div[1]/div[3]/div[2]/div[5]/select"))).selectByVisibleText("Desenvolvedor");
        Verify.verifyElementClick(By.cssSelector("option[value='1']"));
    }

    public void registerUser() throws Exception {

        Verify.verifyElementClick(By.id("icon_prefix"));
        Verify.verifyElement(By.id("icon_prefix"), NICK_ACCESS);
        Thread.sleep(1000);

        Verify.verifyElementClick(By.id("Password"));
        Verify.verifyElement(By.id("Password"), PASSWORD_AGE);
        Thread.sleep(1000);

        Verify.verifyElementClick(By.id("New_Password"));
        Verify.verifyElement(By.id("New_Password"), NEW_PASSWORD);
        Thread.sleep(1000);

        Verify.verifyElementClick(By.id("Confirm_Password"));
        Verify.verifyElement(By.id("Confirm_Password"), NEW_PASSWORD);
        Thread.sleep(1000);

        Verify.verifyElementClick(By.xpath("//div[2]/div[2]/button"));
    }
}
