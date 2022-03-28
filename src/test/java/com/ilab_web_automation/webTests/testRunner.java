package com.ilab_web_automation.webTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ilab_web_automation.data.dataConnector;
import com.ilab_web_automation.pageObjects.webFunctions;
import com.ilab_web_automation.reports.reports;
import com.ilab_web_automation.validations.validations;
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
    validations validate = new validations();
    reports repo = new reports();
    ExtentReports extentRepo;
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

        //Initialize extent reports
       extentRepo = repo.initializeReports("reports/extentReport.html");

    }

    //A method that runs the test
    @Test
    public void negativeTest(){

        ExtentTest test = extentRepo.createTest("File upload test").assignAuthor("Matome Answer Masiye");
        ExtentTest node;

        try{

            //Invokes the function that navigates to the application form
            functions.navigateToForm(web.getWebDriver());

            //Reads data from the database and populates the application form
            while(ilabApplicationSet.next()){

                node = test.createNode("Testing using : " + sBrowser);

                String applicantName = ilabApplicationSet.getString("firstName");
                String applicantEmail = ilabApplicationSet.getString("emailAddress");

                functions.populateApplicationForm(web.getWebDriver(), applicantName, applicantEmail,"083 568 7859");
                validate.validateApplication(web.getWebDriver(),node);
            }

        }catch (Exception e){
            System.out.println("Could not pass data from the database into the web functions : " + e.getMessage());
            e.printStackTrace();
        }

    }

    //Runs after the test is done executing
    @AfterTest
    public void cleanUp() throws InterruptedException {

        Thread.sleep(5000);
        web.getWebDriver().quit();
        extentRepo.flush();

    }
}
