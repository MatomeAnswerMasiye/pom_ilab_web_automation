package com.ilab_web_automation.webTests;

import com.ilab_web_automation.webUtilities.webUtilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testRunner {
    webUtilities web = new webUtilities();
    String sUrl,sBrowser;

    //Runs before the test method
    @BeforeTest
    @Parameters({"url","browser"})
    public void setUp(String url,String browser){

        //Pass the link and browser
        sUrl = url;
        sBrowser = browser;

        //Intialize the browser
        web.setWebDriver(web.initializeWebDriver(sBrowser));

        //Navigate to the website using the provided link
        web.navigateToUrl(sUrl);

    }

    @Test
    public void negativeTest(){

    }

    @AfterTest
    public void cleanUp(){
        web.getWebDriver().quit();
    }
}
