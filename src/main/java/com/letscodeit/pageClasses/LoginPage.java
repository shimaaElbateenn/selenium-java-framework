package com.letscodeit.pageClasses;

import com.letscodeit.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Base64;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebDriver driver;
    private String EMAIL_FIELD = "id=>email";
    private String PASSWORD_FIELD = "id=>password";
    private String LOGIN_BUTTON = "xpath=>//input[@type=\"submit\"]";

    public NavigationPage signInWith(String email, String password) {
        sendData(EMAIL_FIELD, email, "send email");
        sendData(PASSWORD_FIELD, password, "send password");
        elementClick(LOGIN_BUTTON, "Click Login");
        return new NavigationPage(driver);
    }


}
