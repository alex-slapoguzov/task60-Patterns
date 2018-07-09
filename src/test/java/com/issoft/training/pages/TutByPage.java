package com.issoft.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TutByPage {

    private WebDriver driver;

    private By mailLinkLocator = By.xpath("//a[@href=\"http://mail.tut.by/#ua:top_menu_www.tut.by~10\"]");

    public TutByPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickMailLink() {
        driver.findElement(mailLinkLocator).click();
        return new LoginPage(driver);
    }
}
