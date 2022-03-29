package com.ilab_web_automation.pageObjects;

import com.ilab_web_automation.webPageObjects.*;
import com.ilab_web_automation.webUtilities.webActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;

public class webFunctions extends webActions {

    //Navigate to the apply form
    public void navigateToForm(WebDriver driver) {

        //Instantiate objects
        iLabHomePage homePage = new iLabHomePage(driver);
        iLabCareers careers = new iLabCareers(driver);
        iLabSACareers saCareers = new iLabSACareers(driver);
        iLabJobDescription jobDesc = new iLabJobDescription(driver);

        try {

            //Click on the links taking us to the application form
            clickObject(homePage.careersLink, driver);
            clickObject(careers.southAfricaLink, driver);
            clickObject(saCareers.firstCurrentOpening, driver);
            clickObject(jobDesc.applyButton,driver);

        } catch (Exception e) {
            System.out.println("Could not navigate to the form : " + e.getMessage());
        }
    }

    //Pass information into the form
    public void populateApplicationForm(WebDriver driver, String firstName, String emailAddress, String phoneNumber){

        iLabApplicationForm appForm = new iLabApplicationForm(driver);

        //Waits for the form to be visible/displayed before attempting to populate the fields
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(WebDriverException.class);
        wait.until(ExpectedConditions.visibilityOf(appForm.applicationForm));

        //pass data into the form and submit
        try{

            //Populates the form
            passData(appForm.txtName,driver,firstName);
            passData(appForm.txtEmail,driver,emailAddress);
            passData(appForm.phone,driver, phoneNumber);

            //Submits the form
            clickObject(appForm.sendApplicationButton,driver);


        }catch (Exception e){
            System.out.println("Failed to submit the application form : " + e.getMessage());
            Assert.fail();
        }

    }

}
