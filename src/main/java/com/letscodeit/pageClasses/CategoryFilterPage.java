package com.letscodeit.pageClasses;

import com.letscodeit.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryFilterPage extends BasePage {
    public WebDriver driver;
    private String CATEGORY_FIELD = "xpath=>//select[@name=\"categories\"]";
    private String CATEGORY_OPTION = "xpath=>//option[@value=\"1606\"]";

    public CategoryFilterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ResultsPage selectCategory() {
        elementClick(CATEGORY_FIELD, "Select category");
        elementClick(CATEGORY_OPTION, "Category type");
        return new ResultsPage(driver);
    }
}
