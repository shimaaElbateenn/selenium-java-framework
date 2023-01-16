package com.letscodeit.overview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {
    WebDriver driver;
    String baseURL;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Libs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        baseURL = "https://letskodeit.com/";
        driver.get(baseURL);
    }

    @Test
    public void testLogin() {
        driver.findElement(By.xpath("//div[@class=\"ast-button\"]")).click();
        WebElement txtEmail = driver.findElement(By.id("email"));
        txtEmail.clear();
        txtEmail.sendKeys("shimaa@test.com");
        WebElement txtPassword = driver.findElement(By.id("password"));
        txtPassword.clear();
        txtPassword.sendKeys("123456");
        WebElement btnLogin = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        btnLogin.click();

        WebElement accountImage = null;
        try {
            accountImage.findElement(By.className("zl-navbar-rhs-img"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(accountImage);


    }
}
