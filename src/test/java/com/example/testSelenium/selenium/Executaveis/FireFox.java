package com.example.testSelenium.selenium.Executaveis;

public class FireFox {

    private static String MAP_LOGIN = "webdriver.gecko.driver";
    private static String MAP_lOCAL= "C:/ArquivosProgramaJava/geckodriver-v0.18.0-win32/geckodriver.exe";
    public static final String executFireFox(){ return System.setProperty(MAP_LOGIN,MAP_lOCAL); }
}
