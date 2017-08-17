package com.example.testSelenium.selenium.YoutubeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YoutubeTest {

    static WebDriver webDriver;

    public YoutubeTest(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void primeiraEtapa(){

        WebElement campoPreencher = webDriver.findElement(By.name("search_query"));
        campoPreencher.sendKeys("Musicas Eletronicas");

        WebElement botao = webDriver.findElement(By.id("search-btn"));
        botao.click();

        WebElement click = webDriver.findElement(By.xpath("//a[@href ='/watch?v=EVdeYuWxxy8']"));
        click.click();

        WebElement showpause = webDriver.findElement(By.cssSelector("button.ytp-play-button.ytp-button"));
        showpause.click();


    }
}
