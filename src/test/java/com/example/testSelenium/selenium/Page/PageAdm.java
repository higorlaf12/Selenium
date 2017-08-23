package com.example.testSelenium.selenium.Page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static com.example.testSelenium.selenium.Verify.Verify.*;
import static org.junit.Assert.assertEquals;

public class PageAdm {

    static WebDriver webDriver;
    private static String CHARGES_NAME = "FrontEnd";
    private static String COMPETENCE_NAME = "Comunicação";
    private static String DEPARTMENT_NAME = "Desenvolvimento BE";
    private static String USER_NEW = "LucasSilva";
    private static String EMAIL_NEW = "LucasSilvaT@hotmail.com";
    private static String CPF_NEW = "12345678912";
    private static String PASSWORD_NEW = "549868A9SD4S";

    public PageAdm(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void admCharges() throws Exception {

        PageMoveMouse  moveMouse = new PageMoveMouse(webDriver);
        moveMouse.moveMouseMenu(By.xpath("//div/nav/div/ul[1]/li[2]/a"));
        moveMouse.moverMouseNovo(By.xpath("//*[@id='Menu']/li[4]/a"));

        verifyElementClickable(By.xpath("//div/div/div/div[2]/div[1]/a"));

        verifyExisting(By.id("text-input"));
        verifyElementClickable(By.id("text-input"));
        verifyElement(By.id("text-input"), CHARGES_NAME);

        verifyExisting(By.xpath("//div/form/div/div[2]/button"));
        verifyElementClickable(By.xpath("//div/form/div/div[2]/button"));

        List<String> nameElement = new ArrayList<>();
        nameElement.add("FrontEnd");
        nameElement.add("BackEnd");
        nameElement.add("Diretor");

        verifyLoop(nameElement);

        Thread.sleep(1000);


    }

    public void admCompetence() throws Exception {

        PageMoveMouse  moveMouse = new PageMoveMouse(webDriver);
        moveMouse.moveMouseMenu(By.xpath("//div/nav/div/ul[1]/li[2]/a"));
        moveMouse.moverMouseNovo(By.xpath("//*[@id='Menu']/li[4]/a"));

        verifyElementClickable(By.xpath("//a[@href = '#/hreports/administration/competence']"));

        verifyExisting(By.id("text-input"));
        verifyElementClickable(By.id("text-input"));
        verifyElement(By.id("text-input"), COMPETENCE_NAME);

        verifyExisting(By.xpath("//div/form/div[2]/button"));
        verifyElementClickable(By.xpath("//div/form/div[2]/button"));

        List<String> nameElement = new ArrayList<>();
        nameElement.add("Comunicação");
        nameElement.add("Pontualidade");
        nameElement.add("Liderança");

        verifyLoop(nameElement);

        Thread.sleep(1000);
    }

    public void admDepartment() throws Exception {

        PageMoveMouse  moveMouse = new PageMoveMouse(webDriver);
        moveMouse.moveMouseMenu(By.xpath("//div/nav/div/ul[1]/li[2]/a"));
        moveMouse.moverMouseNovo(By.xpath("//*[@id='Menu']/li[4]/a"));

        verifyElementClickable(By.xpath("//a[@href='#/hreports/administration/department']"));

        verifyExisting(By.id("text-input"));
        verifyElement(By.id("text-input"), DEPARTMENT_NAME);

        verifyExisting(By.xpath("//div/form/div[2]/button"));
        verifyElementClickable(By.xpath("//div/form/div[2]/button"));

        List<String> nameElement = new ArrayList<>();
        nameElement.add("Desenvolvimento FE");
        nameElement.add("Gerencia");
        nameElement.add("Desenvolvimento BE");

        verifyLoop(nameElement);

        Thread.sleep(1000);
    }

    public void admTable() throws Exception {

        PageMoveMouse  moveMouse = new PageMoveMouse(webDriver);
        moveMouse.moveMouseMenu(By.xpath("//div/nav/div/ul[1]/li[2]/a"));
        moveMouse.moverMouseNovo(By.xpath("//*[@id='Menu']/li[4]/a"));

        verifyElementClickable(By.xpath("//a[@href='#/hreports/administration/table']"));

    }

    public void admChargenXCompetence() throws Exception {

        verifyExisting(By.cssSelector(" div > div:nth-child(8) > div > div:nth-child(1) > select"));
        verifyElementClickable(By.cssSelector(" div > div:nth-child(8) > div > div:nth-child(1) > select"));

        Select select = new Select(webDriver.findElement(By.cssSelector(" div > div:nth-child(8) > div > div:nth-child(1) > select")));
        Select select1 = new Select(webDriver.findElement(By.cssSelector(" div > div:nth-child(3) > select")));

        List<WebElement> receivesElement = select.getOptions();
        List<WebElement> webElementList = select1.getOptions();

        List<String> nameElement = new ArrayList<>();
        nameElement.add("FrontEnd");
        nameElement.add("BackEnd");
        nameElement.add("Diretor");

        List<String> nameElement1 = new ArrayList<>();
        nameElement1.add("Comunicação");
        nameElement1.add("Pontualidade");
        nameElement1.add("Liderança");

        for (int x = 1; x < receivesElement.size(); x++) {
            select.selectByVisibleText(nameElement.get(x - 1));
            verifyElementClickable(By.xpath("//div[5]/div/div[1]/select/option[" + Integer.toString(x) + "]"));

            verifyExisting(By.cssSelector(" div > div:nth-child(3) > select"));
            verifyElementClickable(By.cssSelector(" div > div:nth-child(3) > select"));

            for (int y = 1; y < webElementList.size(); y++) {
                select1.selectByVisibleText(nameElement1.get(y - 1));
                verifyElementClickable(By.xpath("//div[5]/div/div[3]/select/option[" + Integer.toString(y) + "]"));
                WebElement elementAtextInput = webDriver.findElement(By.id("atext-input"));
                elementAtextInput.sendKeys(y == 1 ? "222" : y == 2 ? "333" : "444");
                verifyElementClickable(By.xpath("//div[5]/div/div[6]/a"));
                elementAtextInput.clear();
            }
        }
        Thread.sleep(1000);
    }

    public void admTableChargeXCharge() throws Exception {

        verifyExisting(By.cssSelector("  div > div:nth-child(12) > div > div:nth-child(1) > select"));
        verifyElementClickable(By.cssSelector("  div > div:nth-child(12) > div > div:nth-child(1) > select"));

        Select select = new Select(webDriver.findElement(By.cssSelector("div > div:nth-child(12) > div > div:nth-child(1) > select")));
        Select select1 = new Select(webDriver.findElement(By.cssSelector("div > div:nth-child(12) > div > div:nth-child(3) > select")));

        List<WebElement> receivesElement = select.getOptions();
        List<WebElement> webElementList = select1.getOptions();

        List<String> nameElement = new ArrayList<>();
        nameElement.add("FrontEnd");
        nameElement.add("BackEnd");
        nameElement.add("Diretor");


        for (int x = 1; x < receivesElement.size(); x++) {

            select.selectByVisibleText(nameElement.get(x - 1));
            verifyElementClickable(By.xpath("//div/div[1]/select/option[" + Integer.toString(x) + "]"));

            verifyExisting(By.cssSelector(" div > div:nth-child(12) > div > div:nth-child(3) > select"));
            verifyElementClickable(By.cssSelector(" div > div:nth-child(12) > div > div:nth-child(3) > select"));

            for (int y = 1; y < webElementList.size(); y++) {
                select1.selectByVisibleText(nameElement.get(y - 1));

                verifyElementClickable(By.xpath("//div[8]/div/div[3]/select/option[" + Integer.toString(y) + "]"));

                WebElement elementAtextInput = webDriver.findElement(By.id("text-input"));

                elementAtextInput.sendKeys(y == 1 ? "222" : y == 2 ? "333" : "444");

                verifyElementClickable(By.xpath("//div[8]/div/div[6]/a"));

                elementAtextInput.clear();
            }
        }
        Thread.sleep(1000);
    }

    public void admUser() throws Exception {

        PageMoveMouse  moveMouse = new PageMoveMouse(webDriver);
        moveMouse.moveMouseMenu(By.xpath("//div/nav/div/ul[1]/li[2]/a"));
        moveMouse.moverMouseNovo(By.xpath("//*[@id='Menu']/li[4]/a"));

        verifyElementClickable(By.xpath("//a[@href='#/hreports/administration/users']"));

    }

    public void admUserRegister() throws Exception {

        verifyElementClickable(By.id("m-l-search"));
        verifyElement(By.id("m-l-search"), USER_NEW);

        verifyExisting(By.xpath("//div[1]/div[3]/div[2]/a"));
        verifyElementClickable(By.xpath("//div[1]/div[3]/div[2]/a"));

        List<WebElement> allElement = webDriver.findElements(By.xpath("//div[3]/div/table/tbody/tr"));

        for (int valueUser = 1; valueUser < allElement.size(); valueUser++) {

            List<WebElement> webElementList = webDriver.findElements(By.xpath("//div[3]/div/table/tbody/tr[" + Integer.toString(valueUser) + "]"));

            verifyExisting(By.xpath("//div/table/tbody/tr[" + Integer.toString(valueUser) + "]/td[6]/span"));

            for (WebElement webelement : webElementList) {

                webelement = webDriver.findElement(By.xpath("//div/table/tbody/tr[" + Integer.toString(valueUser) + "]/td[6]/span"));
                webelement.click();
            }

        }
    }

    public void admUserRegisterNewUser() throws Exception {

        verifyExisting(By.xpath("//div[3]/div[3]/a"));
        verifyElementClickable(By.xpath("//div[3]/div[3]/a"));
        assertEquals("Cadastro de Usuários", webDriver.findElement(By.xpath("//div/form/div[1]/h5")).getText());

        verifyElementClickable(By.id("icon_prefix"));
        verifyElement(By.id("icon_prefix"), USER_NEW);

        verifyElementClickable(By.id("email"));
        verifyElement(By.id("email"), EMAIL_NEW);

        verifyElementClickable(By.id("number"));
        verifyElement(By.id("number"), CPF_NEW);

        verifyExisting(By.cssSelector("div > div.row.valign-botton > div:nth-child(2) > select"));

        new Select(webDriver.findElement(By.cssSelector(" div > div.row.valign-botton > div:nth-child(2) > select")))
                .selectByVisibleText(CHARGES_NAME);

        verifyElementClickable(By.cssSelector("div:nth-child(2) > select > option:nth-child(2)"));

        verifyElementClickable(By.xpath("//div[3]/div[1]/label"));
        assertEquals(DEPARTMENT_NAME, webDriver.findElement(By.xpath("//div[3]/div[1]/label")).getText());

        verifyElementClickable(By.id("text"));
        verifyElement(By.id("text"), PASSWORD_NEW);

        verifyExisting(By.cssSelector("div > div.col.s12.m3.l3 > select"));

        new Select(webDriver.findElement(By.cssSelector("div > div.col.s12.m3.l3 > select")))
                .selectByVisibleText("Administrador");

        verifyElementClickable(By.xpath("//div/div[3]/select/option[2]"));

        //Salvar
        verifyExisting(By.xpath("//button[@type= 'submit']"));
        verifyElementClickable(By.xpath("//button[@type= 'submit']"));

    }
}
