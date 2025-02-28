package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LumaHomePage {

    private WebDriver driver;

    private String signInXpath = "(//a[contains(text(), 'Sign In')])[1]";
    private String createAnAccountXpath = "(//a[contains(text(), 'Create an Account')])[1]";

    public LumaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebUrl() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    public void verifyHomePage() {
        WebElement verifyHomePageObject = driver.findElement(By.xpath("//span[text()=\"Home Page\"]"));
        verifyHomePageObject.isDisplayed();
    }

    public void clickOnCreateAccount() {
        WebElement createAnAccountObject = driver.findElement(By.xpath(createAnAccountXpath));
        createAnAccountObject.click();
    }

    public void clickOnSignIn() {
        WebElement signInObject = driver.findElement(By.xpath(signInXpath));
        signInObject.click();
    }
}
