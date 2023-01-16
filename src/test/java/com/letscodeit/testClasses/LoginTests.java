package com.letscodeit.testClasses;

import com.letscodeit.base.BaseTest;
import com.letscodeit.base.CheckPoint;
import com.letscodeit.pageClasses.AllCoursesPage;
import com.letscodeit.pageClasses.LoginPage;
import com.letscodeit.pageClasses.NavigationPage;
import com.letscodeit.pageClasses.ResultsPage;
import com.letscodeit.utilities.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class LoginTests extends BaseTest {
    @BeforeClass
    public void setUp() {
    }

    @AfterMethod
    public void afterMethod() {
        if (nav.isUserLoggedIn()) {
            nav.logout();
            String str = "";
            nav.goToLoginPage();
        }
    }

    @Test
    public void testValidLogin() {
        nav = loginPage.signInWith(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);
        boolean headerResult = nav.verifyHeader();
        CheckPoint.mark("test-01", headerResult, "verify header");
        //Assert.assertTrue(headerResult);
        boolean result = nav.isUserLoggedIn();
        CheckPoint.markFinal("test-01", result, "verify Icon");
       // Assert.assertTrue(result);
    }

    @Test
    public void testInvalidLogin() {
        nav = loginPage.signInWith("shim@test.com", "123456");
        boolean result = nav.isUserLoggedIn();
        Assert.assertFalse(result);
    }
}
