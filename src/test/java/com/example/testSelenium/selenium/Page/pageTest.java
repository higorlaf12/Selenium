package com.example.testSelenium.selenium.Page;

import com.example.testSelenium.selenium.Page.PageClass.*;
import com.example.testSelenium.selenium.Page.Verify.Verify;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static com.example.testSelenium.selenium.Executaveis.Chrome.executChrome;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class pageTest {

    private static WebDriver webDriver;
    private static PageRegister pageRegister;
    private static PageSearch pageSearch;
    private static PageSearchNew pageSearchNew;
    private static PageAdm pageAdm;
    private static PageMoveMouse pageMoveMouse;
    private static PageAnswer pageAnswer;
    private static PageLogin pageLogin;

    @BeforeClass
    public static void init() throws Exception {

        executChrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");

        webDriver = new ChromeDriver(chromeOptions);

        pageLogin = new PageLogin(webDriver);
        pageRegister = new PageRegister(webDriver);
        pageSearch = new PageSearch(webDriver);
        pageSearchNew = new PageSearchNew(webDriver);
        pageMoveMouse = new PageMoveMouse(webDriver);
        pageAdm = new PageAdm(webDriver);
        pageAnswer = new PageAnswer(webDriver);

            Verify verify = new Verify(webDriver);

        webDriver.get("http://localhost:8080/#/hreports/login");
        webDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

    }

    @AfterClass
    public static void tearDown() throws Exception {

        pageLogin.loginExit();
        if (!pageLogin.loginExit()) {
            webDriver.close();
        }else{
            webDriver.quit();
        }
    }

    @Test
    public void ZloginError() throws Exception {
        pageLogin.loginErrorNotFoud();
    }

    @Test
    public void login() throws Exception {
        pageLogin.fillField();
        Thread.sleep(1000);
    }

    @Test
    public void register() throws Exception {
        pageRegister.register();
        Thread.sleep(1000);

        pageRegister.registerUser();
        Thread.sleep(1000);
    }

    @Test
    public void screenDepartment() throws Exception {
        pageAdm.admDepartment();
        Thread.sleep(4000);

    }

    @Test
    public void screenCharges() throws Exception {
        pageAdm.admCharges();
        Thread.sleep(1000);
    }

    @Test
    public void screenCompetence() throws Exception {
        pageAdm.admCompetence();
        Thread.sleep(1000);
    }

    @Test
    public void screenTable() throws Exception {
        pageAdm.admTable();
        pageAdm.admChargenXCompetence();
        pageAdm.admTableChargeXCharge();
        Thread.sleep(1000);
    }

    @Test
    public void screenUser() throws Exception {
        pageAdm.admUser();
        pageAdm.admUserRegister();
        pageAdm.admUserRegisterNewUser();
        Thread.sleep(1000);
    }


    @Test
    public void search() throws Exception {

        pageSearch.search();
        Thread.sleep(1000);

        pageSearch.searchTable();
        Thread.sleep(1000);
    }

    @Test
    public void searchNew() throws Exception {

        pageSearchNew.createCapa();
        Thread.sleep(1000);

        pageSearchNew.createQuestion();
        Thread.sleep(1000);

        pageSearchNew.createDateInitEnd();
        Thread.sleep(1000);

        pageSearchNew.createTargetQuestion();
        Thread.sleep(1000);

        pageAnswer.answerTable();

    }

}
