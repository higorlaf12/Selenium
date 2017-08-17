package com.example.testSelenium.selenium.Page;

import com.example.testSelenium.selenium.Verify.Verify;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Administration {
    static WebDriver webDriver;
    static String CHARGES_NAME = "FrontEnd";
    static String COMPETENCE_NAME="Comunicação";
    static String DEPARTMENT_NAME="Desenvolvimento BE";

    public Administration(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void admCharges() throws Exception {

        webDriver.get("http://localhost:8080/#/hreports/administration");
        Verify.verifyElement(By.xpath("//div/div/div/div[2]/div[1]/a"), null);

        Verify.verifyExisting(By.id("text-input"));
        Verify.verifyElement(By.id("text-input"), null);
        Verify.verifyElement(By.id("text-input"), CHARGES_NAME);

        Verify.verifyExisting(By.xpath("//div/form/div/div[2]/button"));
        Verify.verifyElement(By.xpath("//div/form/div/div[2]/button"), null);

        List<String> nameElement = new ArrayList<>();
        nameElement.add("FrontEnd");
        nameElement.add("BackEnd");
        nameElement.add("Diretor");

        Verify.verifyLoop(nameElement);

        Thread.sleep(1000);


    }
    public void admCompetence()throws Exception{
        webDriver.get("http://localhost:8080/#/hreports/administration");
        Verify.verifyElement(By.xpath("//a[@href = '#/hreports/administration/competence']"),null);

        Verify.verifyExisting(By.id("text-input"));
        Verify.verifyElement(By.id("text-input"),null);
        Verify.verifyElement(By.id("text-input"),COMPETENCE_NAME);

        Verify.verifyExisting(By.xpath("//div/form/div[2]/button"));
        Verify.verifyElement(By.xpath("//div/form/div[2]/button"),null);

        List<String> nameElement = new ArrayList<>();
        nameElement.add("Comunicação");
        nameElement.add("Pontualidade");
        nameElement.add("Liderança");

        Verify.verifyLoop(nameElement);

        Thread.sleep(1000);
    }
    public void admDepartment()throws Exception{

        webDriver.get("http://localhost:8080/#/hreports/administration");
        Verify.verifyElement(By.xpath("//a[@href='#/hreports/administration/department']"),null);

        Verify.verifyExisting(By.id("text-input"));
        Verify.verifyElement(By.id("text-input"),DEPARTMENT_NAME);

        Verify.verifyExisting(By.xpath("//div/form/div[2]/button"));
        Verify.verifyElement(By.xpath("//div/form/div[2]/button"),null);

        List<String> nameElement = new ArrayList<>();
        nameElement.add("Desenvolvimento FE");
        nameElement.add("Gerencia");
        nameElement.add("Desenvolvimento BE");

        Verify.verifyLoop(nameElement);

        Thread.sleep(1000);
    }

    public void admTable()throws Exception {
        webDriver.get("http://localhost:8080/#/hreports/administration");
        Verify.verifyElement(By.xpath("//a[@href='#/hreports/administration/table']"), null);

        Verify.verifyExisting(By.cssSelector(" div > div:nth-child(8) > div > div:nth-child(1) > select"));
        Verify.verifyElement(By.cssSelector(" div > div:nth-child(8) > div > div:nth-child(1) > select"), null);

        Select select = new Select(webDriver.findElement(By.cssSelector(" div > div:nth-child(8) > div > div:nth-child(1) > select")));
        Select select1 = new Select(webDriver.findElement(By.cssSelector(" div > div:nth-child(3) > select")));

        List<WebElement> receivesElement = select.getOptions();
        List<WebElement> webElementList  = select1.getOptions();

        List<String> nameElement = new ArrayList<>();
        nameElement.add("FrontEnd");
        nameElement.add("BackEnd");
        nameElement.add("Diretor");

        List<String> nameElement1 = new ArrayList<>();
        nameElement1.add("Comunicação");
        nameElement1.add("Pontualidade");
        nameElement1.add("Liderança");

        for (int x = 1; x < receivesElement.size();x++){
            select.selectByVisibleText(nameElement.get(x-1));
            Verify.verifyElement(By.xpath("//div[5]/div/div[1]/select/option["+Integer.toString(x)+"]"),null);

            Verify.verifyExisting(By.cssSelector(" div > div:nth-child(3) > select"));
            Verify.verifyElement(By.cssSelector(" div > div:nth-child(3) > select"), null);

            for (int y =1; y< webElementList.size();y++){
                select1.selectByVisibleText(nameElement1.get(y-1));
                Verify.verifyElement(By.xpath("//div[5]/div/div[3]/select/option["+Integer.toString(y)+"]"),null);
        }
    }


    }
}
