package com.example.testSelenium.selenium.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class PageMoveMouse {

    private WebDriver webDriver;

    public PageMoveMouse(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void moveMouseMenu() throws InterruptedException {
        Actions builder = new Actions(webDriver);
        WebElement butonMenu = webDriver.findElement(By.xpath("//a[contains(@class='dropdown-button')]"));
        Action mouseOverHome = builder.moveToElement(butonMenu).build();
        mouseOverHome.perform();
        Thread.sleep(1000);
        System.out.println("moveu mouse menu");
    }

    public void moverMouseNovo() {
        Actions builder = new Actions(webDriver);
        WebElement butonNew = webDriver.findElement(By.xpath("//button[contains(@class,'md-fab md-raised md-mini md-button')]"));
        Action mouseOverHomeBotaoNovo = builder.moveToElement(butonNew).click(butonNew).build();
        mouseOverHomeBotaoNovo.perform();
    }
}
