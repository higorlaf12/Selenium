package com.example.testSelenium.selenium;

import com.example.testSelenium.selenium.Page.*;
import com.example.testSelenium.selenium.Verify.Verify;
import org.junit.*;
import org.junit.Test;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

import static com.example.testSelenium.selenium.Executaveis.Chrome.executChrome;
import static com.example.testSelenium.selenium.Executaveis.FireFox.executFireFox;
import static com.example.testSelenium.selenium.Executaveis.InternetExplorer.executExplorer;

@FixMethodOrder
public class pageTest {

    static WebDriver webDriver;
    static Register register;
    static Verify verify;
    static Search search;
    static Administration administration;
    static MoveMouse moveMouse;

    static LoginTest loginTest;

    @BeforeClass
    public static void init() throws Exception{
        //executFireFox();
        //webDriver = new FirefoxDriver();
        //webDriver.manage().window().maximize();

        executChrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");


        webDriver = new ChromeDriver(chromeOptions);

//        executExplorer();
//        webDriver = new InternetExplorerDriver();

        loginTest = new LoginTest(webDriver);
        register = new Register(webDriver);
        search = new Search(webDriver);
        verify = new Verify(webDriver);
        moveMouse = new MoveMouse(webDriver);
        administration = new Administration(webDriver);

        webDriver.get("http://localhost:8080/#/hreports/login");

        webDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

    }


    @Test
    public void testLogin() throws Exception {
        loginTest.fillField();
        Thread.sleep(1000);
    }
    @Test
    public void testRegister() throws Exception{
        register.register();
        Thread.sleep(1000);
        register.registerUser();
        Thread.sleep(1000);
    }

    @Test
    public void testScreenSearch() throws Exception{
        search.search();
        Thread.sleep(1000);
        search.searchTable();
        Thread.sleep(1000);
    }
    @Test
    public void testScreenP() throws Exception{
        loginTest.fillField();
        Thread.sleep(1000);
        administration.admCharges();
         Thread.sleep(1000);
        administration.admCompetence();
        Thread.sleep(1000);
        administration.admDepartment();
        Thread.sleep(4000);
        administration.admTable();
        administration.admChargenXCompetence();
        administration.admTableChargeXCharge();
    }

    @Test
    public void testLoginError()throws Exception{
        loginTest.loginErrorNotFoud();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        webDriver.close();

    }

}
