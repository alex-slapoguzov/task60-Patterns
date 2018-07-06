package com.issoft.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {

    private WebDriver driver;
    private WebDriverWait wait;
    By logOutLocator = By.id("PH_logoutLink");
    By inboxButtonLocator = By.cssSelector(".b-nav__item__text.b-nav__item__text_unread");


    public MailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 15);
    }

    public void logOutFromMail() {
        driver.findElement(logOutLocator).click();
    }

    public boolean isElementInboxButtonPresentOnMailPage(){
        return wait.until(ExpectedConditions.elementToBeClickable(inboxButtonLocator)).isDisplayed();
    }
}
