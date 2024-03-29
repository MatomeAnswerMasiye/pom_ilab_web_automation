package com.ilab_web_automation.webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;



//Locators on the jobDescription page
public class iLabJobDescription {

    protected WebDriver driver;

    public iLabJobDescription (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//a[text()[contains(.,'Apply Online')]]")
    public WebElement applyButton;

}

