package com.issoft.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private final static By LOGIN_INPUT = By.id("Username");
    private final static By PASSWORD_INPUT = By.id("Password");
    private final static By SUBMIT_BUTTON = By.cssSelector(".button.loginButton.gradientforbutton");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MailPage login(String name, String password) {
        driver.findElement(LOGIN_INPUT).clear();
        driver.findElement(LOGIN_INPUT).sendKeys(name);
        driver.findElement(PASSWORD_INPUT).clear();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(SUBMIT_BUTTON).click();
        return new MailPage(driver);
    }
}
