package com.example.testSelenium.selenium.Page;

import com.example.testSelenium.selenium.Verify.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static com.example.testSelenium.selenium.Verify.Verify.*;

import java.util.List;

public class PageSearchNew {

    static WebDriver webDriver;
    static String FOR_TEST = "Analizando é testando com o seleniumsss";

    public PageSearchNew(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void createCapa() throws Exception {
        webDriver.get("http://localhost:8080/#/hreports/surveymanagement");

        verifyExisting(By.xpath("//a[@href='#/hreports/createsurvey']"));
        verifyElementClickable(By.xpath("//a[@href='#/hreports/createsurvey']"));

        //Colocar aqui uma verificação se esta realmente na pagina.

        //Titulo da questão
        verifyElementClickable(By.id("title"));
        verifyElement(By.id("title"), FOR_TEST);

        //Descrição da questão
        verifyElementClickable(By.id("textarea1"));
        verifyElement(By.id("textarea1"), "Estou fazendo tudo que eu posso");

        //Definir usuario
        verifyElementClickable(By.xpath("//*[@id='input_nome']"));
        verifyElement(By.xpath("//*[@id='input_nome']"), "Higor Freitas");

        //Departamento
        verifyExisting(By.cssSelector(" div:nth-child(2) > div.col.s6.m5.l3.offset-m1 > select"));

        new Select(webDriver.findElement(By.cssSelector(" div:nth-child(2) > div.col.s6.m5.l3.offset-m1 > select")))
                .selectByVisibleText("Desenvolvimento BE");

        verifyElementClickable(By.cssSelector("div.col.s6.m5.l3.offset-m1 > select > option:nth-child(2)"));

        //Cargo
        verifyExisting(By.cssSelector("div:nth-child(2) > div:nth-child(3) > select"));
        new Select(webDriver.findElement(By.cssSelector(" div:nth-child(2) > div:nth-child(3) > select")))
                .selectByVisibleText("BackEnd");

        verifyElementClickable(By.cssSelector(" div:nth-child(3) > select > option:nth-child(3)"));

        //Buscar usuario alvo
        verifyExisting(By.xpath("//div[3]/div[2]/div[4]/a"));
        verifyElementClickable(By.xpath("//div[3]/div[2]/div[4]/a"));

        //Clicar para proxima pagina
        verifyExisting(By.xpath("//button[@type='submit']"));
        verifyElementClickable(By.xpath("//button[@type='submit']"));

    }

    public void createQuestion() throws Exception {

        Thread.sleep(1000);

        //Adicionar uma nova questão
        Verify.verifyExisting(By.xpath("//div/div[2]/div[1]/label"));
        List<WebElement> verifyElement = webDriver.findElements(By.xpath("//div/div[2]/div[1]/label"));

        for (int valueElement = 1; valueElement <= verifyElement.size(); valueElement++) {
            verifyElementClickable(By.xpath("//div/div[2]/div[1]/label[" + Integer.toString(valueElement) + "]"));
            verifyElementClickable(By.xpath("//div/div[2]/div[3]/a"));
        }
        Thread.sleep(2000);

        //Primeira pergunta Aberta
        verifyElementClickable(By.xpath("//div/form/div[2]/div/div/div[2]/div[2]/div/div/input"));

        verifyElement(By.xpath("//div/form/div[2]/div/div/div[2]/div[2]/div/div/input"),
                "Aberta Deve escrever alguma coisa");

        verifyExisting(By.xpath("//div/div/div[1]/div[2]/a"));

        verifyElementClickable(By.xpath("//div/div/div[1]/div[2]/a"));

        Thread.sleep(2000);

        //Click Obrigtorio
        verifyExisting(By.xpath("//div[4]/div/label"));
        verifyElementClickable(By.xpath("//div[4]/div/label"));

        Thread.sleep(1000);

        //Segunda pergunta multipla escolha
        verifyElementClickable(By.xpath("//div[3]/div/div/div[2]/div[2]/div/div[1]/div[1]/input"));
        verifyElement(By.xpath("//div[3]/div/div/div[2]/div[2]/div/div[1]/div[1]/input"),
                "X perguntas multiplicas escolhas");

        Thread.sleep(2000);

        verifyElementClickable(By.xpath("//div/div[2]/div[2]/div/div[2]/div/div[1]/input"));
        verifyElement(By.xpath("//div/div[2]/div[2]/div/div[2]/div/div[1]/input"), "X = Y");

        Thread.sleep(2000);

        verifyElementClickable(By.xpath("//div/form/div[3]/div/div/div[2]/div[2]/div/div[3]/div[2]/a"));

        Thread.sleep(2000);

        verifyElementClickable(By.xpath("//div/div/div[2]/div[2]/div/div[3]/div/div[1]/input"));
        verifyElement(By.xpath("//div/div/div[2]/div[2]/div/div[3]/div/div[1]/input"), "X<Y");

        verifyExisting(By.xpath("//div[2]/div/div[3]/div/div[2]/a/i"));
        verifyElementClickable(By.xpath("//div[2]/div/div[3]/div/div[2]/a/i"));

        Thread.sleep(1000);

        //Click minimizar
        verifyExisting(By.xpath("//div[3]/div/div/div[1]/div[2]/a/i"));
        verifyElementClickable(By.xpath("//div[3]/div/div/div[1]/div[2]/a/i"));

        Thread.sleep(1000);

        //Terceira pergunta multipla escolha
        verifyElementClickable(By.xpath("//form/div[4]/div/div/div[2]/div[2]/div/div/div/input"));
        verifyElement(By.xpath("//form/div[4]/div/div/div[2]/div[2]/div/div/div/input"), "Texte Pergunta");

        //Deletar Terceira pergunta
        verifyExisting(By.xpath("//form/div[4]/div/div/div[4]/div[3]/div/a"));
        verifyElementClickable(By.xpath("//form/div[4]/div/div/div[4]/div[3]/div/a"));

        //Proxima pagina
        verifyExisting(By.xpath("//button[@type='submit']"));
        verifyElementClickable(By.xpath("//button[@type='submit']"));
        Thread.sleep(1000);
    }

    public void createDateInitEnd() throws Exception {
        verifyElement(By.xpath("//div/div[1]/div[3]/div/div[2]/input"), "15092017");
        verifyElement(By.xpath("//div/div[1]/div[3]/div/div[3]/input"), "20122018");

        //Clicar para proxima pagina

        verifyExisting(By.xpath("//div/div[2]/a"));
        verifyElementClickable(By.xpath("//div/div[2]/a"));
    }

    public void createTargetQuestion() throws Exception {
        //Alvos do Questionário
        verifyElementClickable(By.id("autocomplete-input"));
        verifyElement(By.id("autocomplete-input"), "Higor Freitas");

        //Departamento
        verifyExisting(By.cssSelector(" div.card-panel > div:nth-child(5) > div:nth-child(2) > select"));
        new Select(webDriver.findElement(By.cssSelector(" div.card-panel > div:nth-child(5) > div:nth-child(2) > select")))
                .selectByVisibleText("Desenvolvimento BE");
        verifyElementClickable(By.cssSelector("div:nth-child(2) > select > option:nth-child(2)"));

        //Cargo
        verifyExisting(By.cssSelector("div.card-panel > div:nth-child(5) > div:nth-child(3) > select"));
        new Select(webDriver.findElement(By.cssSelector("div.card-panel > div:nth-child(5) > div:nth-child(3) > select")))
                .selectByVisibleText("BackEnd");
        verifyElementClickable(By.cssSelector("div:nth-child(3) > select > option:nth-child(3)"));

        verifyExisting(By.xpath("//div/div[1]/div[3]/div[4]/a"));
        verifyElementClickable(By.xpath("//div/div[1]/div[3]/div[4]/a"));

        verifyElementClickable(By.xpath("//div[1]/ul/li[2]/table/tbody/tr/td[1]"));

        verifyElementClickable(By.xpath("//div/div[3]/a"));

    }
}
