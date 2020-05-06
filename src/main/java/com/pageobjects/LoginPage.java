package com.pageobjects;

import com.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends Utils{

    String uname = getUsername();
    String pwd = getPassword();
    //static String expectedTitle = myMap.get("Login Page Title");

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(name = "submit")
    public WebElement submit;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void login(){
        username.sendKeys(uname);
        password.sendKeys(pwd);
        submit.click();
    }

    /*public void verifyTitle() {
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }*/
}
