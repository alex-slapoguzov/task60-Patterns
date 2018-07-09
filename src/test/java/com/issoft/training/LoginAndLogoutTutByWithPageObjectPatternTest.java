package com.issoft.training;

import com.issoft.training.pages.LoginPage;
import com.issoft.training.pages.MailPage;
import com.issoft.training.pages.TutByPage;
import com.issoft.training.pages.YandexByPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginAndLogoutTutByWithPageObjectPatternTest {

    private final static String login = "seleniumtests10";
    private final static String password = "060788avavav";
    private final String TYT_BY_URL = "https://www.tut.by/";


    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get(TYT_BY_URL);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @Test
    public void loginTytByTest() {
        TutByPage tutByPage = new TutByPage(driver);
        LoginPage loginPage = tutByPage.clickMailLink();
        loginPage.loginInTytBy(login, password);
        MailPage mailPage = loginPage.clickSubmitButton();
        Assert.assertTrue(mailPage.isMailPage(), "Element inbox isn't on the page");
    }

    @Test(dependsOnMethods = {"loginTytByTest"})
    public void logOutTytByTest() {
        MailPage mailPage = new MailPage(driver);
        mailPage.logOutFromMail();
        YandexByPage yandexByPage = new YandexByPage(driver);
        Assert.assertTrue(yandexByPage.isInputFieldInYandexByPage(), "Input field isn't on yandex page");
    }
}
