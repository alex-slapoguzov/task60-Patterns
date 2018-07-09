package com.issoft.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By userNameLocator = By.cssSelector(".mail-User-Name");
    private By logOutButtonLocator = By.xpath("//a[@class=\"b-mail-dropdown__item__content js-user-dropdown-item \"][text()='Выход']");
    private By listWithMailButtonsLocator = By.cssSelector(".mail-NestedList-Item-Name.js-folders-item-name");


    public MailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void logOutFromMail() {
        driver.findElement(userNameLocator).click();
        wait.until(ExpectedConditions.elementToBeClickable(logOutButtonLocator));
        driver.findElement(logOutButtonLocator).click();
    }

    private Integer numberElementsInList() {
        wait.until(ExpectedConditions.elementToBeClickable(listWithMailButtonsLocator));
        return driver.findElements(listWithMailButtonsLocator).size();
    }

    public boolean isMailPage() {
        return numberElementsInList().equals(5);
    }
}
