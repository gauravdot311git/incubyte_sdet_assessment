package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LumaHomePage {

    private final WebDriver driver;

    private final By signInXpath = By.xpath("(//a[contains(text(), 'Sign In')])[1]");
    private final By createAnAccountXpath = By.xpath("(//a[contains(text(), 'Create an Account')])[1]");

    public LumaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebUrl() {
        try {
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.get("https://magento.softwaretestingboard.com/");
        } catch (Exception e) {
            System.out.println("exception time out: " +e.getMessage() + "\n" + "continue to tests");
        }
        driver.manage().window().maximize();
    }

    public void verifyHomePage() {
        WebElement verifyHomePageObject = driver.findElement(By.xpath("//span[text()=\"Home Page\"]"));
        verifyHomePageObject.isDisplayed();
    }

    public void clickOnCreateAccount() {
        WebElement createAnAccountObject = driver.findElement(createAnAccountXpath);
        createAnAccountObject.click();
    }

    public void clickOnSignIn() {
        WebElement signInObject = driver.findElement(signInXpath);
        signInObject.click();
    }
}
