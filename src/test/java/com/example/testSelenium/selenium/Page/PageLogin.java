package com.example.testSelenium.selenium.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.example.testSelenium.selenium.Verify.Verify.verifyElement;
import static com.example.testSelenium.selenium.Verify.Verify.verifyElementClickable;
import static org.junit.Assert.assertEquals;

public class PageLogin {

    static WebDriver webDriver;
    static String USER_EMAIL = "higor.freitas@neppoadm.com.br";
    static String USER_LOGIN = "1234567890";
    static String USER_LOGIN_ERROR = "25785485185";

    public PageLogin(WebDriver driver) {
        this.webDriver = driver;
    }

    public void fillField() {

        String expectedTitle = "HReports";

        String actualTitle = webDriver.getTitle();

        if (expectedTitle.equals(actualTitle)) {

            WebElement element = webDriver.findElement(By.id("loginEmail"));
            element.sendKeys(USER_EMAIL);

            WebElement element1 = webDriver.findElement(By.id("loginPassword"));
            element1.sendKeys(USER_LOGIN);

            WebElement button = webDriver.findElement(By.name("action"));
            button.click();
        } else
            System.out.println("ERROR, Page not found");
    }

    public void loginErrorNotFoud() throws Exception {
        webDriver.get("http://localhost:8080/#/hreports/login");
        verifyElement(By.id("loginEmail"), USER_EMAIL);
        verifyElement(By.id("loginPassword"), USER_LOGIN_ERROR);
        verifyElementClickable(By.name("action"));

        Thread.sleep(1000);
        assertEquals("  Algo deu errado",
                webDriver.findElement(By.xpath("//*[@id='toast-container']/div/div/span")).getText());

//        Verify.verifyExisting();
//        Alert alert = webDriver.switchTo().alert();
//        alert.accept();

//        String expectedMessage = "The Institution is deleted Successfully!";
//        String message = driver.findElement(By.xpath("//div[contains(@class,'callout callout-success')]")).getText();
//        Assert.assertTrue("Your error message", message.contains(expectedMessage))


    }
    public boolean loginExit() throws Exception{

        PageMoveMouse moveMouse = new PageMoveMouse(webDriver);
        moveMouse.moveMouseMenu(By.xpath("//nav/div/ul[1]/li[3]/a/i"));
        moveMouse.moverMouseNovo(By.xpath("//*[@id='Perfil']/li[2]/a"));

        return true;
    }

}
