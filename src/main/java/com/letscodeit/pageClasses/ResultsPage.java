package com.letscodeit.pageClasses;

import com.letscodeit.base.BasePage;
import dev.failsafe.internal.util.Assert;
import dev.failsafe.internal.util.Lists;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;

import java.util.List;

public class ResultsPage extends BasePage {
    public ResultsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebDriver driver;
    private String RESULTS_COURSE = "css=>.zen-course-list a";

    private int coursesNum = 6;

    public int courseCount() {
        List<WebElement> courseList = getElementList(RESULTS_COURSE, "Result course");
        return courseList.size();
    }
    public boolean verifyResultSearch() {
        boolean result = false;
        if (courseCount() > 0) {
            result = true;
        }
        return result;
    }

    public boolean verifyCategoryFilter() {
        boolean result = false;
        if (courseCount() == coursesNum) {
            result = true;
        }
        return result;
    }
}
