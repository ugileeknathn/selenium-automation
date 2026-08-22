package com.example.selenium_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DailyAutomationTest1 {
    @Test
    public void openWebsite() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");
        System.out.println("Page Title: " + driver.getTitle());
        driver.quit();
    }
}
