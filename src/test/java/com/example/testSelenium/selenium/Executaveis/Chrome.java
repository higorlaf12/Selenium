package com.example.testSelenium.selenium.Executaveis;

public class Chrome {

    private static final String MAP_LOGIN = "webdriver.chrome.driver";
    private static final String MAP_LOCAL = "C:/ArquivosProgramaJava/chromedriver_win32/chromedriver.exe";
    public static final String executChrome(){ return System.setProperty(MAP_LOGIN,MAP_LOCAL); }

}
