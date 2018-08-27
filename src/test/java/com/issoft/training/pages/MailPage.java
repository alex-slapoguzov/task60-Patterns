package com.issoft.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private final static By USER_NAME = By.cssSelector(".mail-User-Name");
    private final static By LOG_OUT_BUTTON = By.xpath("//a[@class=\"b-mail-dropdown__item__content js-user-dropdown-item \"][text()='Выход']");
    private final static By MAIL_BUTTONS_LIST = By.cssSelector(".mail-NestedList-Item-Name.js-folders-item-name");
    private final static Integer NUMBER_OF_STANDARD_FOLDERS = 5;


    public MailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void logout() {
        driver.findElement(USER_NAME).click();
        wait.until(ExpectedConditions.elementToBeClickable(LOG_OUT_BUTTON));
        driver.findElement(LOG_OUT_BUTTON).click();
    }

    private Integer numberElementsInList() {
        wait.until(ExpectedConditions.elementToBeClickable(MAIL_BUTTONS_LIST));
        return driver.findElements(MAIL_BUTTONS_LIST).size();
    }

    public boolean isMailPage() {
        return numberElementsInList().equals(NUMBER_OF_STANDARD_FOLDERS);
    }
}
