package com.example.testSelenium.selenium.Page;

import com.example.testSelenium.selenium.Verify.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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


    }
}
