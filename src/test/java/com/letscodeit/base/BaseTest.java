package com.letscodeit.base;

import com.letscodeit.pageClasses.AllCoursesPage;
import com.letscodeit.pageClasses.LoginPage;
import com.letscodeit.pageClasses.NavigationPage;
import com.letscodeit.pageClasses.ResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    protected String baseURL;
    protected LoginPage loginPage;
    protected NavigationPage nav;

    protected AllCoursesPage allCoursesPage;
    protected ResultsPage resultsPage;

    @BeforeClass
    @Parameters({"browser"})
    public void CsetUp(String browser) {
        driver = WebDriverFactory.getInstance().getDriver(browser);
        baseURL = "https://letskodeit.com/";
        driver.get(baseURL);
        nav = new NavigationPage(driver);
        loginPage = nav.goToLoginPage();
    }

    @BeforeMethod
    public void methodSetup() {
        CheckPoint.clearHashMap();
    }

    @AfterClass
    public void CtearDown() {
        WebDriverFactory.getInstance().quitDriver();
    }
}
