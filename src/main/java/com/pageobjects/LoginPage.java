package com.pageobjects;

import com.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends Utils{

    static String uname = getUsername();
    static String pwd = getPassword();
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
        enterText(username,uname);
        enterText(password,pwd);
        click(submit);
    }

    /*public void verifyTitle() {
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }*/
}
