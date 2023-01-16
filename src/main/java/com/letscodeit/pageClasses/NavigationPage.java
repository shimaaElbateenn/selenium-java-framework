package com.letscodeit.pageClasses;

import com.letscodeit.base.BasePage;
import com.letscodeit.utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationPage extends BasePage {

    public WebDriver driver;
    private final String URL = "https://courses.letskodeit.com/courses";
    private String ALL_COURSES = "xpath=>//a[@href=\"/courses\"]";
    private String MY_COURSES = "xpath=>//a[@href=\"/mycourses\"]";
    private String ACCOUNT_ICON = "class=>zl-navbar-rhs-img";
    private String ACCOUNT_MENU = "class=>caret";
    private String LOGOUT_BUTTON = "xpath=>//a[@href=\"/logout\"]";
    private String LOGIN_LINK = "xpath=>//div[@class=\"ast-button\"]";
    private String LOGIN_LINK_AFTER_LOGOUT = "xpath=>//a[@href=\"/login\"]";

    public NavigationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public LoginPage goToLoginPage() {
        if (isElementPresent(LOGIN_LINK, "Login Link")) {
            elementClick(LOGIN_LINK, "Click Login");
        } else {
            elementClick(LOGIN_LINK_AFTER_LOGOUT, "Login link after logout");
        }
        return new LoginPage(driver);
    }


    public AllCoursesPage AllCourses() {
        elementClick(ALL_COURSES, "All Courses Link");
        return new AllCoursesPage(driver);
    }

    public boolean isUserLoggedIn() {
        if (isElementPresent(ACCOUNT_ICON, "Account Icon")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyHeader() {
        String text = getText(ALL_COURSES, "All Courses Link");
        return Util.verifyTextContains(text, "All Coursesss");
    }

    public void logout() {
        elementClick(ACCOUNT_MENU, "Account Menu");
        elementClick(LOGOUT_BUTTON, "Logout");

    }

    public boolean isOPen() {
        return URL.equalsIgnoreCase(driver.getCurrentUrl());
    }
}
