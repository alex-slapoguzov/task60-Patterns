package com.issoft.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailRuPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final static String MAIL_RU_URL = "https://mail.ru/";
    By loginInputLocator = By.id("mailbox:login");
    By passwordInputLocator = By.id("mailbox:password");
    By submitButtonLocator = By.xpath("//input[@class=\"o-control\"]");
    By findButtonLocator = By.cssSelector(".btn.btn_orange.search__btn.i-no-left-radius");

    public MailRuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 15);
    }

    public MailRuPage openMailRuPage(){
        driver.get(MAIL_RU_URL);
        return new MailRuPage(driver);
    }

    public void loginInMailRu(String name, String password){
        driver.findElement(loginInputLocator).clear();
        driver.findElement(loginInputLocator).sendKeys(name);
        driver.findElement(passwordInputLocator).clear();
        driver.findElement(passwordInputLocator).sendKeys(password);
        clickSubmitButton();
    }

    private MailPage clickSubmitButton(){
        driver.findElement(submitButtonLocator).click();
      //  wait.until(ExpectedConditions.elementToBeClickable())
        return new MailPage(driver);
    }

    public boolean isElementFindButtonPresentOnMailRuPage(){
       return wait.until(ExpectedConditions.elementToBeClickable(findButtonLocator)).isDisplayed();
       // return driver.findElement(findButtonLocator).isDisplayed();
    }
}
