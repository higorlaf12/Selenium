package com.example.testSelenium.selenium.Executaveis;

public class InternetExplorer {

    private static final String MAP_LOGIN = "webdriver.ie.driver";
    private static final String MAP_LOCAL = "C:/ArquivosProgramaJava/IEDriverServer_x64_3.5.0/IEDriverServer.exe";
    public static final String executExplorer(){ return System.setProperty(MAP_LOGIN,MAP_LOCAL); }

}
