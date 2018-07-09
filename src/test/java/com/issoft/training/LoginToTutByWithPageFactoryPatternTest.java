package com.issoft.training;

import com.issoft.training.pages.LoginPage;
import com.issoft.training.pages.MailPage;
import com.issoft.training.pages.TutByPage;
import com.issoft.training.pages.YandexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginToTutByWithPageFactoryPatternTest {

    private final String TYT_BY_URL = "https://www.tut.by/";
    private final String login = "seleniumtests10";
    private final String password = "060788avavav";
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get(TYT_BY_URL);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void loginTutByTest() {
        TutByPage tutByPage = new TutByPage(driver);
        LoginPage loginPage = tutByPage.clickMailLink();
        MailPage mailPage = loginPage.login(login, password);
        Assert.assertTrue(mailPage.isFormPresent(), "Form isn't present");
    }

    @Test(dependsOnMethods = {"loginTutByTest"})
    public void logOutTutByTest() {
        MailPage mailPage = new MailPage(driver);
        mailPage.logOut();
        YandexPage yandexPage = new YandexPage(driver);
        Assert.assertTrue(yandexPage.isInputFieldisPresent(), "Input field isn't on Yandex page");
    }
}
