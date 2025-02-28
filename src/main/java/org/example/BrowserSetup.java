package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSetup {
    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "chrome driver path - i will add this later");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}


