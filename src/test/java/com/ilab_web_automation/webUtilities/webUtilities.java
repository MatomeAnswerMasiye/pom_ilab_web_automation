package com.ilab_web_automation.webUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class webUtilities {

    WebDriver driver;

    //Returns a web driver when invoked
    public WebDriver getWebDriver(){
        return driver;
    }


    //Sets the web driver
    public void setWebDriver(WebDriver theWebDriver){
        this.driver = theWebDriver;
    }

    //Takes the browser as a string input and returns when invoked
    public WebDriver initializeWebDriver(String sBrowser){
        switch (sBrowser.toUpperCase()){
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "IE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

        }

        driver.manage().window().maximize();
        return driver;
    }


    //Takes the web url as an input and navigates to the website/application
    public void navigateToUrl(String url){

        driver.get(url);

    }
}
