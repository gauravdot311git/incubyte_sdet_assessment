package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LumaHomePage {

    private final WebDriver driver;
    private final WebDriverWait webDriverWait;

    private final By signInXpath = By.xpath("(//a[contains(text(), 'Sign In')])[1]");
    private final By createAnAccountXpath = By.xpath("(//a[contains(text(), 'Create an Account')])[1]");
    private final By homePageText = By.xpath("//span[text()='Home Page']");
    private final String homePageUrl = "https://magento.softwaretestingboard.com/";

    public LumaHomePage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 60);
    }

    public void openWebUrl() {
        try {
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.get(homePageUrl);
        } catch (Exception e) {
            System.err.println("Unexpected error occurred while opening url: " + e.getMessage());
        }
        driver.manage().window().maximize();
    }

    public boolean verifyHomePageText() {
        try {
            WebElement homePageTextObject = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(homePageText));
            return homePageTextObject.isDisplayed();
        } catch (Exception e) {
            System.out.println("Exception occurred while waiting for Home Page text to be visible after 30 seconds   : " + e.getMessage());
            return false;
        }
    }

    public void clickOnCreateAccount() {
        try {
            WebElement createAnAccountObject = webDriverWait.until(ExpectedConditions.elementToBeClickable(createAnAccountXpath));
            createAnAccountObject.click();
        } catch (Exception e) {
            System.out.println("Exception occurred while waiting for 'Create Account' button to be clickable after 30 seconds   : " + e.getMessage());
        }
    }

    public void clickOnSignIn() {
        try {
            WebElement signInObject = webDriverWait.until(ExpectedConditions.elementToBeClickable(signInXpath));
            signInObject.click();
        } catch (Exception e) {
            System.out.println("Exception occurred while waiting for 'Sign In' button to be clickable after 10 seconds   : " + e.getMessage());
        }
    }
}
