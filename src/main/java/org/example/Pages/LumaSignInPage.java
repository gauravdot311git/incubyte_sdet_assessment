package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LumaSignInPage {

    private WebDriver driver;
    private final By email = By.id("email");
    private final By password = By.id("pass");
    private final By createAccount = By.id("send2");

    public LumaSignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String emailString) {
        WebElement emailEdit = driver.findElement(email);
        emailEdit.sendKeys(emailString);
    }

    public void setPassword(String passwordString) {
        WebElement passwordEdit = driver.findElement(password);
        passwordEdit.sendKeys(passwordString);
    }

    public void clickOnSignInButton() {
        WebElement createAccountButton = driver.findElement(createAccount);
        createAccountButton.click();
    }
}
