package com.example.testSelenium.selenium.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MoveMouse {

    private WebDriver webDriver;

    public MoveMouse(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void moverMouseMenu() throws InterruptedException {
        Actions builder = new Actions(webDriver);
        WebElement botaoMenu = webDriver.findElement(By.xpath("//button[contains(@class,'md-fab md-primary md-button')]"));
        Action mouseOverHome = builder.moveToElement(botaoMenu).build();
        mouseOverHome.perform();
        Thread.sleep(1000);
        System.out.println("moveu mouse menu");
    }
    public void moverMouseNovo() {
        Actions builder = new Actions(webDriver);
        WebElement botaoNovo = webDriver.findElement(By.xpath("//button[contains(@class,'md-fab md-raised md-mini md-button')]"));
        Action mouseOverHomeBotaoNovo = builder.moveToElement(botaoNovo).click(botaoNovo).build();
        mouseOverHomeBotaoNovo.perform();	}
}
