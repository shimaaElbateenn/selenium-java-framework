package com.letscodeit.testClasses;

import com.letscodeit.base.BaseTest;
import com.letscodeit.overview.ExcelRead;
import com.letscodeit.pageClasses.*;
import com.letscodeit.utilities.Constants;
import com.letscodeit.utilities.ExcelUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class AllCoursesTests extends BaseTest {

    @DataProvider(name = "verifySearchCourse")
    private Object[][] getVerifySearchCourse() {
        Object[][] testData = ExcelUtility.getTestData("verify_search_course");
        return testData;
    }

    @BeforeClass
    public void setUp() {
        loginPage.signInWith(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);
        ExcelUtility.setExcelFile(Constants.EXCEL_FILE,"Sheet1");
    }

    @Test(dataProvider = "verifySearchCourse")
    public void verifySearchCourse(String courseName){
        allCoursesPage = nav.AllCourses();
        resultsPage = allCoursesPage.searchCourse(courseName);
        boolean searchResults = resultsPage.verifyResultSearch();
        Assert.assertTrue(searchResults);

    }

    @Test(enabled = false)
    public void filterByCategory() {
        nav.AllCourses();
        CategoryFilterPage categoryFilterPage = new CategoryFilterPage(driver);
        resultsPage = categoryFilterPage.selectCategory();
        boolean searchResults = resultsPage.verifyCategoryFilter();
        Assert.assertTrue(searchResults);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
