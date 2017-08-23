package com.example.testSelenium.selenium.ProjectNewSelenium;

import com.example.testSelenium.selenium.ProjectNewSelenium.MoveMouse.MoveMouse;
import com.example.testSelenium.selenium.ProjectNewSelenium.ProjectNew.*;
import com.example.testSelenium.selenium.ProjectNewSelenium.Verify.Verify;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static com.example.testSelenium.selenium.Executaveis.Chrome.executChrome;

@FixMethodOrder
public class TestNewSelenium {

    private static WebDriver driver;

    private static PageLogin login;
    private static PageInitial initial;
    private static PageAdministration administration;
    private static PageAnswer answer;
    private static PageCreatesurvey createsurvey;
    private static PageProfileConfig profileConfig;
    private static PageReport report;
    private static PageSurveyManagement surveyManagement;

    private static Verify verify;

    private static MoveMouse moveMouse;

    @BeforeClass
    public static void init() throws Exception {

        executChrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");

        driver = new ChromeDriver(chromeOptions);


        administration = new PageAdministration(driver);
        answer = new PageAnswer(driver);
        createsurvey = new PageCreatesurvey(driver);
        initial = new PageInitial(driver);
        login = new PageLogin(driver);
        profileConfig = new PageProfileConfig(driver);
        report = new PageReport(driver);
        surveyManagement = new PageSurveyManagement(driver);

        verify = new Verify(driver);
        moveMouse = new MoveMouse(driver);


        driver.get("http://localhost:8080/#/hreports/login");
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void pageLogin() throws Exception{
        login.loginSuccess();
        Thread.sleep(1000);
    }
    @Test
    public void pageLoginNotFound() throws Exception{
        login.loginErrorNotFound();
        Thread.sleep(1000);
    }
    @Test
    public void pageLoginTurnOff()throws Exception{
        login.loginTurnOff();
    }

    @AfterClass
    public static void tearDown() throws Exception{
        driver.close();
    }

}
