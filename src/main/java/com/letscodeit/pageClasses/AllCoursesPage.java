package com.letscodeit.pageClasses;

import com.letscodeit.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllCoursesPage extends BasePage {
    public AllCoursesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebDriver driver;
    private String SEARCH_BAR = "xpath=>//input[@id=\"search\"]";
    private String SEARCH_BUTTON = "class=>find-course";


    public ResultsPage searchCourse(String courseName) {
        sendData(SEARCH_BAR, courseName, "search courses");
        elementClick(SEARCH_BUTTON, "Click search");
        return new ResultsPage(driver);
    }
}
