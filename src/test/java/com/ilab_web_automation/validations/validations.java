package com.ilab_web_automation.validations;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.ilab_web_automation.reports.reports;
import com.ilab_web_automation.webPageObjects.iLabApplicationForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;


public class validations {

    reports repo = new reports();

    public void validateApplication(WebDriver driver, ExtentTest node){

        iLabApplicationForm appForm = new iLabApplicationForm(driver);

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(WebDriverException.class);
        wait.until(ExpectedConditions.visibilityOf(appForm.errorMessage));

        try{

            String filename = repo.captureScreenshot(driver);

            if(appForm.errorMessage.isDisplayed()){

                node.pass("Error message displayed",MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());

            }else{

                node.fail("Error message not displayed",MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
                Assert.fail("Error message not displayed");

            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
