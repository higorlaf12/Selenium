package com.example.testSelenium.selenium.YoutubeTest;

import com.example.testSelenium.selenium.FlashObjectWebDriver.FlashObjectWebDriver;
import com.example.testSelenium.selenium.YoutubeTest.YoutubeTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.example.testSelenium.selenium.Executaveis.Chrome.executChrome;

public class YoutubeStartTest {

    static WebDriver webDriver;

    static YoutubeTest youtubeTest;

    @BeforeClass
    public static void init () throws Exception{

        executChrome();
        webDriver = new ChromeDriver();
        webDriver.get("https://www.youtube.com/");
        youtubeTest = new YoutubeTest(webDriver);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        FlashObjectWebDriver flashApp = new FlashObjectWebDriver(webDriver, "movie_player");

        webDriver.get("http://tinyurl.com/bqnaoo7");
        Thread.sleep(2000L);

        // let the video load
        while (Integer.parseInt(flashApp.callFlashObject("getPlayerState")) == 3){
            Thread.sleep(1000L);
        }

        // Play the video for 10 seconds
        Thread.sleep(5000);
        flashApp.callFlashObject("pauseVideo");
        Thread.sleep(5000);
        flashApp.callFlashObject("playVideo");
        Thread.sleep(5000);
        flashApp.callFlashObject("seekTo","140","true");
        Thread.sleep(5000);
        flashApp.callFlashObject("mute");
        Thread.sleep(5000);
        flashApp.callFlashObject("setVolume","50");
        Thread.sleep(5000);

    }

    @Test
    public void testYoutubeMusicaEntrar(){
        //youtubeTest.primeiraEtapa();
    }

    @AfterClass
    public static void finalizacaoDaClasse() throws Exception{

    }
}
