package com.ilab_web_automation.webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;



//Locators on the SA careers page
public class iLabSACareers {

    protected WebDriver driver;

    public iLabSACareers(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "(//a[@class = 'wpjb-job_title wpjb-title'])[1]")
    public WebElement firstCurrentOpening;

}
