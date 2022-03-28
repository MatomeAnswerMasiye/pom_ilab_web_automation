package com.ilab_web_automation.webTests;

import com.ilab_web_automation.pageObjects.webFunctions;
import com.ilab_web_automation.webUtilities.webUtilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testRunner {
    webUtilities web = new webUtilities();
    webFunctions functions = new webFunctions();
    String sUrl,sBrowser;

    //Runs before the test starts executing
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

    //A method that runs the test
    @Test
    public void negativeTest(){
        functions.navigateToForm(web.getWebDriver());
        functions.populateApplicationForm(web.getWebDriver(), "Matome",
                "automationAssessment@iLABQuality.com","083 568 7859");
    }

    //Runs after the test is done executing
    @AfterTest
    public void cleanUp() throws InterruptedException {

        Thread.sleep(5000);
        web.getWebDriver().quit();

    }
}
