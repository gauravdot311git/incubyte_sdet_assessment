package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LumaSignInPage {

    private WebDriver driver;
    private final WebDriverWait webDriverWait;
    private final By emailLocator = By.id("email");
    private final By passwordLocator = By.id("pass");
    private final By createAccountLocator = By.id("send2");

    public LumaSignInPage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 60);
    }

    public void setEmail(String emailString) {
        WebElement emailEdit = driver.findElement(emailLocator);
        emailEdit.clear();
        emailEdit.sendKeys(emailString);
    }

    public void setPassword(String passwordString) {
        WebElement passwordEdit = driver.findElement(passwordLocator);
        passwordEdit.clear();
        passwordEdit.sendKeys(passwordString);
    }

    public void clickOnSignInButton() {
        try {
            WebElement createAccountButton = webDriverWait.until(ExpectedConditions.elementToBeClickable(createAccountLocator));
            createAccountButton.click();
        } catch (Exception e) {
            System.out.println("Exception occurred while waiting for 'Create Account' button to be clickable after 30 seconds   : " + e.getMessage());
        }
    }
}
