package org.example.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSetup {
    private  static  WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                System.setProperty("webdriver.chrome.driver", "/Users/gauravkumar/Downloads/chromedriver-mac-x64/chromedriver");
                driver = new ChromeDriver();
            } catch (WebDriverException e) {
                System.err.println("Error in initializing web driver : " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Unexpected error occurred : " + e.getMessage());
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


