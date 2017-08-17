package com.example.testSelenium.selenium;

import com.example.testSelenium.selenium.Page.Administration;
import com.example.testSelenium.selenium.Page.LoginTest;
import com.example.testSelenium.selenium.Page.Register;
import com.example.testSelenium.selenium.Page.Search;
import com.example.testSelenium.selenium.Verify.Verify;
import org.junit.*;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static com.example.testSelenium.selenium.Executaveis.Chrome.executChrome;
import static com.example.testSelenium.selenium.Executaveis.FireFox.executFireFox;

@FixMethodOrder
public class pageTest {

    static WebDriver webDriver;
    static Register register;
    static Verify verify;
    static Search search;
    static Administration administration;

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
        loginTest = new LoginTest(webDriver);
        register = new Register(webDriver);
        search = new Search(webDriver);
        verify = new Verify(webDriver);
        webDriver.get("http://localhost:8080/#/hreports/login");
        administration = new Administration(webDriver);
        webDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

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
        administration.admCharges();
         Thread.sleep(1000);
        administration.admCompetence();
        Thread.sleep(1000);
        administration.admDepartment();
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
