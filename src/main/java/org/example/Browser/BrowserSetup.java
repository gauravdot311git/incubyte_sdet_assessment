package org.example.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSetup {
    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/gauravkumar/Downloads/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}


