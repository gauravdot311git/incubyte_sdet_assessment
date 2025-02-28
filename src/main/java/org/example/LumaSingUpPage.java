package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LumaSingUpPage {


    private WebDriver driver;
    WebElement passwordEdit = null;

    public LumaSingUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
        WebElement firstnameEdit = driver.findElement(By.id("firstname"));
        firstnameEdit.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        WebElement lastnameEdit = driver.findElement(By.id("lastname"));
        lastnameEdit.sendKeys(lastName);
    }

    public void setEmail(String email) {
        WebElement emailEdit = driver.findElement(By.xpath("//input[@name='email']"));
        emailEdit.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordEdit = driver.findElement(By.id("password"));
        passwordEdit.sendKeys(password);
    }

    public void setConfirmationPassword(String password) {
        WebElement confirmationPasswordEdit = driver.findElement(By.id("password-confirmation"));
        confirmationPasswordEdit.sendKeys(password);
    }

    public void clickOnCreateAccount() {
        WebElement createAccountButton = driver.findElement(By.xpath("//button[@title='Create an Account']"));
        createAccountButton.click();
    }

    public String getPasswordMeter() {
        WebElement passwordMeter = driver.findElement(By.id("password-strength-meter-label"));
        String text = passwordMeter.getText();
        return  text;
    }

    public void clearPassword() {
        passwordEdit.clear();
    }
}
