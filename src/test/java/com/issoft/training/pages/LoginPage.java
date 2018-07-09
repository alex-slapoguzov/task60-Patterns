package com.issoft.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By loginInputLocator = By.id("Username");
    private By passwordInputLocator = By.id("Password");
    private By submitButtonLocator = By.cssSelector(".button.loginButton.gradientforbutton");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginInTytBy(String name, String password) {
        driver.findElement(loginInputLocator).clear();
        driver.findElement(loginInputLocator).sendKeys(name);
        driver.findElement(passwordInputLocator).clear();
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public MailPage clickSubmitButton() {
        driver.findElement(submitButtonLocator).click();
        return new MailPage(driver);
    }
}
