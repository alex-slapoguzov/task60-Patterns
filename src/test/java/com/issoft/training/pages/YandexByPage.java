package com.issoft.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexByPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By inputFieldLocator = By.cssSelector(".input__control.input__input");

    public YandexByPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public boolean isInputFieldInYandexByPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(inputFieldLocator));
        return driver.findElement(inputFieldLocator).isDisplayed();
    }
}
