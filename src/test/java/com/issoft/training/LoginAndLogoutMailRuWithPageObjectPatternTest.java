package com.issoft.training;

import com.issoft.training.pages.MailPage;
import com.issoft.training.pages.MailRuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginAndLogoutMailRuWithPageObjectPatternTest {

    private final static String login = "seleniumtests10";
    private final static String password = "060788avavav";
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }

    @Test
    public void loginMailRuTest() {
        MailRuPage mailRuPage = new MailRuPage(driver);
        mailRuPage.openMailRuPage();
        mailRuPage.loginInMailRu(login, password);
        MailPage mailPage = new MailPage(driver);
        Assert.assertTrue(mailPage.isElementInboxButtonPresentOnMailPage(), "Element inbox isn't on the page");
    }

    @Test(dependsOnMethods = {"loginMailRuTest"} )
    public void logOutMailRuTest() {
        MailPage mailPage = new MailPage(driver);
        mailPage.logOutFromMail();
        MailRuPage mailRuPage = new MailRuPage(driver);
        Assert.assertTrue(mailRuPage.isElementFindButtonPresentOnMailRuPage(), "Element inbox isn't on the page");
    }
}
