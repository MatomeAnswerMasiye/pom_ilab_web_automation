package com.ilab_web_automation.pageObjects;

import com.ilab_web_automation.webPageObjects.*;
import com.ilab_web_automation.webUtilities.webActions;
import org.openqa.selenium.WebDriver;

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
    public void populateApplicationForm(WebDriver driver,String firstName,String emailAddress,String phoneNumber){

        iLabApplicationForm appForm = new iLabApplicationForm(driver);

        //pass data into the form and submit
        try{
            passData(appForm.txtName,driver,firstName);
            passData(appForm.txtEmail,driver,emailAddress);
            passData(appForm.phone,driver, phoneNumber);

            clickObject(appForm.sendApplicationButton,driver);

        }catch (Exception e){
            System.out.println("Failed to submit the application form : " + e.getMessage());
        }

    }

}
