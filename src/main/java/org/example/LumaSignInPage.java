package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LumaSignInPage {

    private WebDriver driver;

    public LumaSignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        WebElement emailEdit = driver.findElement(By.id("email"));
        emailEdit.sendKeys(email);
    }

    public void setPassword(String password) {
        WebElement passwordEdit = driver.findElement(By.id("pass"));
        passwordEdit.sendKeys(password);
    }

    public void clickOnSignInButton() {
        WebElement createAccountButton = driver.findElement(By.id("send2"));
        createAccountButton.click();
    }

}
