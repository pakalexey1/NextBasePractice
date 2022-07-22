package com.cydeo.pages;

import com.cydeo.utilties.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrmPage {

    public CrmPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "CRM")
    public WebElement header;

    @FindBy (linkText = "Log out")
    public WebElement logout_button;

    @FindBy (xpath = "//div[@id='user-block']/span[@class='user-name']")
    public WebElement logout_dropdown;

}
