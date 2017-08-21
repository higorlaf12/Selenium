package com.example.testSelenium.selenium.Page;

import com.example.testSelenium.selenium.Verify.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class NewSearch {

    static WebDriver webDriver;
    static String FOR_TEST ="Analizando é testando com o selenium";

    public NewSearch(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void createCapa() throws Exception{
        webDriver.get("http://localhost:8080/#/hreports/surveymanagement");

        Verify.verifyExisting(By.xpath("//a[@href='#/hreports/createsurvey']"));
        Verify.verifyElementClick(By.xpath("//a[@href='#/hreports/createsurvey']"));

        //Colocar aqui uma verificação se esta realmente na pagina.

        //Titulo da questão
        Verify.verifyElementClick(By.id("title"));
        Verify.verifyElement(By.id("title"),FOR_TEST);

        //Descrição da questão
        Verify.verifyElementClick(By.id("textarea1"));
        Verify.verifyElement(By.id("textarea1"),"Estou fazendo tudo que eu posso");

        //Definir usuario
        Verify.verifyElementClick(By.xpath("//*[@id='input_nome']"));
        Verify.verifyElement(By.xpath("//*[@id='input_nome']"),"Higor Freitas");

        //Departamento
        Verify.verifyExisting(By.cssSelector(" div:nth-child(2) > div.col.s6.m5.l3.offset-m1 > select"));
        new Select(webDriver.findElement(By.cssSelector(" div:nth-child(2) > div.col.s6.m5.l3.offset-m1 > select")))
                .selectByVisibleText("Desenvolvimento BE");
        Verify.verifyElementClick(By.cssSelector("div.col.s6.m5.l3.offset-m1 > select > option:nth-child(2)"));

        //Cargo
        Verify.verifyExisting(By.cssSelector("div:nth-child(2) > div:nth-child(3) > select"));
        new Select(webDriver.findElement(By.cssSelector(" div:nth-child(2) > div:nth-child(3) > select")))
                .selectByVisibleText("BackEnd");
        Verify.verifyElementClick(By.cssSelector(" div:nth-child(3) > select > option:nth-child(3)"));

        //Buscar usuario alvo
        Verify.verifyExisting(By.xpath("//div[3]/div[2]/div[4]/a"));
        Verify.verifyElementClick(By.xpath("//div[3]/div[2]/div[4]/a"));

        //Clicar para proxima pagina
        Verify.verifyExisting(By.xpath("//button[@type='submit']"));
        Verify.verifyElementClick(By.xpath("//button[@type='submit']"));

    }

    public void createQuestion() throws Exception{

        Thread.sleep(1000);

        //Adicionar uma nova questão
        Verify.verifyExisting(By.xpath("//div/div[2]/div[1]/label"));
        List<WebElement> verifyElement = webDriver.findElements(By.xpath("//div/div[2]/div[1]/label"));

        for (int valueElement = 1;valueElement <= verifyElement.size();valueElement++){
            Verify.verifyElementClick(By.xpath("//div/div[2]/div[1]/label["+Integer.toString(valueElement)+"]"));
            Verify.verifyElementClick(By.xpath("//div/div[2]/div[3]/a"));
        }
        Thread.sleep(2000);

        //Primeira pergunta Aberta
        Verify.verifyElementClick(By.xpath("//div/form/div[2]/div/div/div[2]/div[2]/div/div/input"));

        Verify.verifyElement(By.xpath("//div/form/div[2]/div/div/div[2]/div[2]/div/div/input"),
                "Aberta Deve escrever alguma coisa");

        Verify.verifyExisting(By.xpath("//div/div/div[1]/div[2]/a"));

        Verify.verifyElementClick(By.xpath("//div/div/div[1]/div[2]/a"));

        Thread.sleep(2000);

        //Click Obrigtorio
        Verify.verifyExisting(By.xpath("//div[4]/div/label"));
        Verify.verifyElementClick(By.xpath("//div[4]/div/label"));

        Thread.sleep(1000);

        //Segunda pergunta multipla escolha
        Verify.verifyElementClick(By.xpath("//div[3]/div/div/div[2]/div[2]/div/div[1]/div[1]/input"));
        Verify.verifyElement(By.xpath("//div[3]/div/div/div[2]/div[2]/div/div[1]/div[1]/input"),
                "X perguntas multiplicas escolhas");

        Thread.sleep(2000);

        Verify.verifyElementClick(By.xpath("//div/div[2]/div[2]/div/div[2]/div/div[1]/input"));
        Verify.verifyElement(By.xpath("//div/div[2]/div[2]/div/div[2]/div/div[1]/input"),"X = Y");

        Thread.sleep(2000);

        Verify.verifyElementClick(By.xpath("//div/form/div[3]/div/div/div[2]/div[2]/div/div[3]/div[2]/a"));

        Thread.sleep(2000);

        Verify.verifyElementClick(By.xpath("//div/div/div[2]/div[2]/div/div[3]/div/div[1]/input"));
        Verify.verifyElement(By.xpath("//div/div/div[2]/div[2]/div/div[3]/div/div[1]/input"),"X<Y");

        Verify.verifyExisting(By.xpath("//div[2]/div/div[3]/div/div[2]/a/i"));
        Verify.verifyElementClick(By.xpath("//div[2]/div/div[3]/div/div[2]/a/i"));

        Thread.sleep(1000);

        //Click minimizar
        Verify.verifyExisting(By.xpath("//div[3]/div/div/div[1]/div[2]/a/i"));
        Verify.verifyElementClick(By.xpath("//div[3]/div/div/div[1]/div[2]/a/i"));

        Thread.sleep(1000);

        //Terceira pergunta multipla escolha
        Verify.verifyElementClick(By.xpath("//form/div[4]/div/div/div[2]/div[2]/div/div/div/input"));
        Verify.verifyElement(By.xpath("//form/div[4]/div/div/div[2]/div[2]/div/div/div/input"),"Texte Pergunta");

        //Deletar Terceira pergunta
        Verify.verifyExisting(By.xpath("//form/div[4]/div/div/div[4]/div[3]/div/a"));
        Verify.verifyElementClick(By.xpath("//form/div[4]/div/div/div[4]/div[3]/div/a"));

        //Proxima pagina
        Verify.verifyExisting(By.xpath("//button[@type='submit']"));
        Verify.verifyElementClick(By.xpath("//button[@type='submit']"));
        Thread.sleep(1000);
    }

    public void createDateInitEnd() throws Exception{
        Verify.verifyElement(By.xpath("//div/div[1]/div[3]/div/div[2]/input"),"15092017");
        Verify.verifyElement(By.xpath("//div/div[1]/div[3]/div/div[3]/input"),"20122018");

        //Clicar para proxima pagina

        Verify.verifyExisting(By.xpath("//div/div[2]/a"));
        Verify.verifyElementClick(By.xpath("//div/div[2]/a"));
    }

    public void createTargetQuestion()throws Exception{
        //Alvos do Questionário
        Verify.verifyElementClick(By.id("autocomplete-input"));
        Verify.verifyElement(By.id("autocomplete-input"),"Higor Freitas");

        //Departamento
        Verify.verifyExisting(By.cssSelector(" div.card-panel > div:nth-child(5) > div:nth-child(2) > select"));
        new Select(webDriver.findElement(By.cssSelector(" div.card-panel > div:nth-child(5) > div:nth-child(2) > select")))
                .selectByVisibleText("Desenvolvimento BE");
        Verify.verifyElementClick(By.cssSelector("div:nth-child(2) > select > option:nth-child(2)"));

        //Cargo
        Verify.verifyExisting(By.cssSelector("div.card-panel > div:nth-child(5) > div:nth-child(3) > select"));
        new Select(webDriver.findElement(By.cssSelector("div.card-panel > div:nth-child(5) > div:nth-child(3) > select")))
                .selectByVisibleText("BackEnd");
        Verify.verifyElementClick(By.cssSelector("div:nth-child(3) > select > option:nth-child(3)"));

        Verify.verifyExisting(By.xpath("//div/div[1]/div[3]/div[4]/a"));
        Verify.verifyElementClick(By.xpath("//div/div[1]/div[3]/div[4]/a"));

        Verify.verifyElementClick(By.xpath("//div[1]/ul/li[2]/table/tbody/tr/td[1]"));

        Verify.verifyElementClick(By.xpath("//div/div[3]/a"));

    }
}
