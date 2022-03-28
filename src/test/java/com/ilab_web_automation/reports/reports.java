package com.ilab_web_automation.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class reports {

    public ExtentSparkReporter spark;
    public ExtentReports extent;

    public ExtentReports initializeReports(String reportFileName){
        spark = new ExtentSparkReporter(reportFileName);
        extent = new ExtentReports();
        extent.attachReporter(spark);

        return extent;

    }

    public String captureScreenshot(WebDriver driver) throws IOException {

        File sFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte [] fileContent = FileUtils.readFileToByteArray(new File(String.valueOf(sFile)));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);

        return encodedString;
    }

}
