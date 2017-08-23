package com.example.testSelenium.selenium.Page.PageClass;

import com.example.testSelenium.selenium.Page.Verify.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageSearch {
    static WebDriver webDriver;
    static String NAME_SEARCH = "HigorLucas";

    public PageSearch(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void search() throws Exception {
       PageMoveMouse  moveMouse = new PageMoveMouse(webDriver);
       moveMouse.moveMouseMenu(By.xpath("//div/nav/div/ul[1]/li[2]/a"));
       moveMouse.moverMouseNovo(By.xpath("//*[@id='Menu']/li[1]/a"));


        Verify.verifyElementClickable(By.id("search"));
        Verify.verifyElement(By.id("search"), NAME_SEARCH);
        Thread.sleep(1000);

        Verify.verifyExisting(By.xpath("//div[3]/div[2]/div/div[2]/a[1]"));
        Verify.verifyElementClickable(By.xpath("//div[3]/div[2]/div/div[2]/a[1]"));
        Thread.sleep(1000);

        Verify.verifyExisting(By.cssSelector(" div > div:nth-child(4) > div.offset-l1.offset-m1.col.s12.m3.l3 > select"));
        Thread.sleep(1000);
        Verify.verifyElementClickable(By.cssSelector(" div > div:nth-child(4) > div.offset-l1.offset-m1.col.s12.m3.l3 > select"));
        Select select = new Select(webDriver.findElement(By.cssSelector(
                "div > div:nth-child(4) > div.offset-l1.offset-m1.col.s12.m3.l3 > select")));
        select.selectByVisibleText("Andrey 1");
        Verify.verifyElementClickable(By.xpath("//div[3]/div[3]/div/div[2]/div[1]/select/option[2]"));
        Thread.sleep(1000);

        Verify.verifyExisting(By.cssSelector("div > div:nth-child(4) > div:nth-child(2) > select"));
        Thread.sleep(1000);

        Verify.verifyElementClickable(By.cssSelector("div > div:nth-child(4) > div:nth-child(2) > select"));
        new Select(webDriver.findElement(By.cssSelector(
                " div > div:nth-child(4) > div:nth-child(2) > select"))).selectByVisibleText("Andrey 2");
        Verify.verifyElementClickable(By.xpath("//div[3]/div[3]/div/div[2]/div[2]/select/option[3]"));
        Thread.sleep(1000);

        new Select(webDriver.findElement(By.xpath("//div[3]/select"))).selectByVisibleText("Aberta");
        webDriver.findElement(By.cssSelector("option[value=\"true\"]")).click();

        webDriver.findElement(By.xpath("//input[@type='date']")).sendKeys("10/04/2018");
        webDriver.findElement(By.xpath("(//input[@type='date'])[2]")).sendKeys("10/08/2018");

        Verify.verifyExisting(By.xpath("//div[3]/div[2]/div/div[2]/a[2]"));
        Thread.sleep(1000);
        Verify.verifyElementClickable(By.xpath("//div[3]/div[2]/div/div[2]/a[2]"));
    }

    public void searchTable() throws Exception {

        List<WebElement> element = webDriver
                .findElements(By.xpath(
                        "/html/body/div[2]/hreports-survey-management-component/div/div/div[4]/div/div/table/tbody/tr"));

        for (int var = 1; var <= element.size(); var++) {

            List<WebElement> elementList = webDriver.findElements(By.xpath
                    ("/html/body/div[2]/hreports-survey-management-component/div/div/div[4]/div/div/table/tbody/tr[" +
                            Integer.toString(var) + "]"));

            for (WebElement allElementList : elementList) {
                allElementList = webDriver.findElement(By.xpath
                        ("/html/body/div[2]/hreports-survey-management-component/div/div/div[4]/div/div/table/tbody/tr[" +
                                Integer.toString(var) + "]"));
                allElementList.click();


                WebElement webElement = webDriver.findElement(By.xpath("//div[@id='individual']/div/div/select"));
                webElement.click();

                Select select = new Select(webDriver.findElement(By.xpath("//*[@id='individual']/div/div/select")));
                select.getAllSelectedOptions();

                List<WebElement> elements = select.getOptions();


                for (int x = 1; x <= elements.size(); x++) {

                    List<WebElement> allElement = webDriver.findElements(By.xpath("//div[@id='individual']/div/div/select"));

                    for (WebElement allElements : allElement) {
                        allElements = webDriver.findElement(By.xpath("//*[@id=\"individual\"]/div[1]/div[1]/select/option[" +
                                Integer.toString(x) + "]"));
                        allElements.click();

                        WebElement element1 = webDriver.findElement(By.xpath("//a[@href= '#resumido']"));
                        element1.click();

                        for (int i = 0; i < 2; i++) {
                            WebElement clickOne = webDriver.findElement(By.xpath("//*[@id=\"Corpo-Impressao2\"]/div[6]/div/div[1]/div[2]/a/i"));
                            clickOne.click();

                            WebElement clickThow = webDriver.findElement(By.xpath("//*[@id=\"Corpo-Impressao2\"]/div[8]/div/div[1]/div[2]/a/i"));
                            clickThow.click();

                            WebElement clickThree = webDriver.findElement(By.xpath("//*[@id=\"Corpo-Impressao2\"]/div[10]/div/div[2]/div[2]/a/i"));
                            clickThree.click();

                            WebElement clickFour = webDriver.findElement(By.xpath("//*[@id=\"Corpo-Impressao2\"]/div[10]/div/div[4]/div[2]/a"));
                            clickFour.click();
                        }
                        webDriver.findElement(By.xpath("//a[@href= '#individual']")).click();

                    }
                }
            }
            webDriver.get("http://localhost:8080/#/hreports/surveymanagement");
        }
    }
}
