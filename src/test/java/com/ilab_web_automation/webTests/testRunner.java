package com.ilab_web_automation.webTests;

import com.ilab_web_automation.data.dataConnector;
import com.ilab_web_automation.pageObjects.webFunctions;
import com.ilab_web_automation.webUtilities.webUtilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.ResultSet;

public class testRunner {
    webUtilities web = new webUtilities();
    webFunctions functions = new webFunctions();
    dataConnector connector = new dataConnector();
    String sUrl,sBrowser;
    ResultSet ilabApplicationSet;

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

        //Connect and retrieve data from the database
        String sConnectionUrl = "jdbc:mysql://localhost:3306/ilabapplicationinfo";
        String sUname = "root";
        String sPass = "passwordinstance@MySql";
        String sQuery = "select * from applicationforminfo";
        ilabApplicationSet = connector.ConnectAndQuerySQL(sConnectionUrl,sUname,sPass,sQuery);

    }

    //A method that runs the test
    @Test
    public void negativeTest(){

        try{

            functions.navigateToForm(web.getWebDriver());

            while(ilabApplicationSet.next()){

                String applicantName = ilabApplicationSet.getString("firstName");
                String applicantEmail = ilabApplicationSet.getString("emailAddress");

                functions.populateApplicationForm(web.getWebDriver(), applicantName, applicantEmail,"083 568 7859");
            }

        }catch (Exception e){
            System.out.println("Could not pass data from the database into the web functions : " + e.getMessage());
        }

    }

    //Runs after the test is done executing
    @AfterTest
    public void cleanUp() throws InterruptedException {

        Thread.sleep(5000);
        web.getWebDriver().quit();

    }
}
