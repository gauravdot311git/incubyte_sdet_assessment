package org.example;

import org.example.Browser.BrowserSetup;
import org.example.Pages.LumaHomePage;
import org.example.Pages.LumaSignInPage;
import org.example.Pages.LumaSingUpPage;
import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver;
        LumaHomePage lumaHomePage;
        LumaSingUpPage lumaSingUpPage;
        LumaSignInPage lumaSignInPage;
        String testEmail = "gaurav.kumar@gmail.com";
        String password = "abc123!@#";

        //this is only for testing
        driver = BrowserSetup.getDriver();
        lumaHomePage = new LumaHomePage(driver);
        lumaSingUpPage = new LumaSingUpPage(driver);
        lumaSignInPage = new LumaSignInPage(driver);

        lumaHomePage.openWebUrl();

        try {
            lumaHomePage.verifyHomePage();
            lumaHomePage.clickOnCreateAccount();
            lumaSingUpPage.setFirstName("Gaurav");
            lumaSingUpPage.setLastName("Kumar");
            lumaSingUpPage.setEmail(testEmail);
            lumaSingUpPage.setPassword(password);
            lumaSingUpPage.getPasswordMeter();
            lumaSingUpPage.setConfirmationPassword(password);
            lumaSingUpPage.clearPassword();
            lumaSingUpPage.clickOnCreateAccount();
            lumaSignInPage.setEmail(testEmail);
            lumaSignInPage.setPassword(password);
            lumaSignInPage.clickOnSignInButton();
        } catch (Exception e) {
            System.out.println("exception occurred : " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}