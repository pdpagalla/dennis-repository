package com.tests;

import com.pageobjects.LoginPage;
import com.utils.Utils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Tests extends Utils{
    LoginPage loginPage;
    @BeforeClass
    public void beforeClass() throws IOException {
        launchBrowser();
        navigateToUrl();
        readData();
    }

    @Test
    public void loginScenario(){
        loginPage = new LoginPage();
        loginPage.login();
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }
}