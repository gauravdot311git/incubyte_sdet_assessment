package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LumaUserAccountPage {

    //url after creating account -> https://magento.softwaretestingboard.com/customer/account/
    // my account verification xapath -> //span[text()='My Account']
    // to verify account created successfully check for this -> //span[text()='Welcome, %s %s!']
    // drop down button besides welcome full name --> (//button/span[text()='Change'])[1]
    // we will click on this and logout
    // sign out xpath  - > (//a[contains(text(), 'Sign Out')])[1]

    private final WebDriver driver;
//    private final By myAccount = By.xpath("//span[text()='My Account']");
    private final By dropdown = By.xpath("(//button/span[text()='Change'])[1]");
    private final By signOut = By.xpath("(//a[contains(text(), 'Sign Out')])[1]");
    WebDriverWait webDriverWait;


    public LumaUserAccountPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait =new WebDriverWait(driver, 5);
    }

    public boolean verifyWelcomeText(String firstName, String lastName) {
        By welcomeTextLocator = By.xpath("//span[text()='Welcome, " + firstName + " " + lastName + "!']");
        try {
            WebElement welcomeText = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(welcomeTextLocator));
            return welcomeText.isDisplayed();
        } catch (Exception e) {
            System.out.println("Exception occurred while waiting for welcome text to be visible after 5 seconds   : " + e.getMessage());
            return false;
        }
    }

    public void clickOnWelcomeDropdown() {
        WebElement dropDown = driver.findElement(dropdown);
        dropDown.click();
    }

    public void clickOnSignOut() {
        try {
            WebElement signOutButton = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(signOut));
            signOutButton.click();
        } catch (Exception e) {
            System.out.println("Exception occurred while waiting for sign out for 5 seconds : " + e.getMessage());
        }
    }
}
