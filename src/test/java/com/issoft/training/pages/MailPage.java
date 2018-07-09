package com.issoft.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = ".mail-NestedList-Item-Name.js-folders-item-name")
    private WebElement listWithLink;

    @FindBy(css = ".mail-User-Name")
    private WebElement userNameButton;

    @FindBy(xpath = "//a[@class=\"b-mail-dropdown__item__content js-user-dropdown-item \"][text()='Выход']")
    private WebElement logOutButton;

    public MailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public YandexPage logOut() {
        userNameButton.click();
        logOutButton.click();
        return new YandexPage(driver);
    }

    public boolean isFormPresent() {
        wait.until(ExpectedConditions.visibilityOf(listWithLink));
        int size = driver.findElements(By.cssSelector(".mail-NestedList-Item-Name.js-folders-item-name")).size();
        return size == 5;
    }
}
