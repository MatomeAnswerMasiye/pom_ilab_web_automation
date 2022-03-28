package com.ilab_web_automation.webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;



//Locators on the careers page
public class iLabApplicationForm{

    protected WebDriver driver;

    public iLabApplicationForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//*[@id=\"applicant_name\"]")
    public WebElement txtName;

    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement txtEmail;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    public WebElement phone;

    @FindBy(xpath = "//*[@id=\"wpjb_submit\"]\n")
    public WebElement sendApplicationButton;



}
