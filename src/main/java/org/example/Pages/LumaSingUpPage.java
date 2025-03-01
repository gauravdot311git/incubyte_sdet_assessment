package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LumaSingUpPage {


    private final WebDriver driver;
    private WebElement passwordEdit = null;
    private WebElement confirmationPasswordEdit = null;
    private final By firstName = By.id("firstname");
    private final By lastName = By.id("lastname");
    private final By email = By.xpath("//input[@name='email']");
    private final By password = By.id("password");
    private final By confirmPassword = By.id("password-confirmation");
    private final By createAccount = By.xpath("//button[@title='Create an Account']");
    private final By passwordMeter = By.id("password-strength-meter-label");

    public LumaSingUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstNameString) {
        WebElement firstnameEdit = driver.findElement(firstName);
        firstnameEdit.sendKeys(firstNameString);
    }

    public void setLastName(String lastNameString) {
        WebElement lastnameEdit = driver.findElement(lastName);
        lastnameEdit.sendKeys(lastNameString);
    }

    public void setEmail(String emailString) {
        WebElement emailEdit = driver.findElement(email);
        emailEdit.sendKeys(emailString);
    }

    public void setPassword(String passwordString) {
        passwordEdit = driver.findElement(password);
        passwordEdit.sendKeys(passwordString);
    }

    public void setConfirmationPassword(String passwordString) {
        confirmationPasswordEdit = driver.findElement(confirmPassword);
        confirmationPasswordEdit.sendKeys(passwordString);
    }

    public void clickOnCreateAccount() {
        WebElement createAccountButton = driver.findElement(createAccount);
        createAccountButton.click();
    }

    public String getPasswordMeter() {
        WebElement passwordMeterObject = driver.findElement(passwordMeter);
        String text = passwordMeterObject.getText();
        System.out.println("password meter : " + text);
        return  text;
    }

    public void clearPassword() {
        passwordEdit.clear();
        confirmationPasswordEdit.clear();
        System.out.println("passwords cleared");
    }
}