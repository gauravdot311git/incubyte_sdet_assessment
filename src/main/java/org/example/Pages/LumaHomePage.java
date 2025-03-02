package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LumaHomePage {

    private final WebDriver driver;

    private final By signInXpath = By.xpath("(//a[contains(text(), 'Sign In')])[1]");
    private final By createAnAccountXpath = By.xpath("(//a[contains(text(), 'Create an Account')])[1]");
    private final By homePageText = By.xpath("//span[text()='Home Page']");
    private final String homePageUrl = "https://magento.softwaretestingboard.com/";

    public LumaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebUrl() {
        try {
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.get(homePageUrl);
        } catch (Exception e) {
            System.out.println("exception time out: " +e.getMessage() + "\n" + "continue to tests");
        }
        driver.manage().window().maximize();
    }

    public boolean verifyHomePageText() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        try {
            WebElement homePageTextObject = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(homePageText));
            return homePageTextObject.isDisplayed();
        } catch (Exception e) {
            System.out.println("Exception occurred while waiting for Home Page text to be visible after 10 seconds   : " + e.getMessage());
            return false;
        }
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
