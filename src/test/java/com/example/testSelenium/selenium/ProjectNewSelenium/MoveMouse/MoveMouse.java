package com.example.testSelenium.selenium.ProjectNewSelenium.MoveMouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MoveMouse {

    private static WebDriver driver;
    private static Actions builder;


    public MoveMouse(WebDriver driver){
        this.driver = driver;
    }

    public void moveMouseMenu(By element) throws InterruptedException{
        builder = new Actions(driver);
        WebElement buttonMenu = driver.findElement(element);
        Action mouseOverHome= builder.moveToElement(buttonMenu).build();
        mouseOverHome.perform();
        Thread.sleep(1000);
        System.out.println("move mouse menu");
    }

    public void moveMouseClick(By element){
        builder = new Actions(driver);
        WebElement buttonNew = driver.findElement(element);
        Action mouseOverHome= builder.moveToElement(buttonNew).click(buttonNew).build();
        mouseOverHome.perform();
    }
}
