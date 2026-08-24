package com.example.selenium_automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.NaukriHomePage;

public class NaukariMe {
    
    WebDriver driver;
    NaukriHomePage NaukriHomePage;
    
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        NaukriHomePage = new NaukriHomePage(driver);
    }
    
    @Test
    public void openWebsite() throws IOException, InterruptedException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);

        String url = prop.getProperty("naukariurl");
        String user = prop.getProperty("username");
        String pass = prop.getProperty("password");
        String filepath = System.getProperty("user.dir") + "/src/test/resources/Tanuja_Ugile.pdf";

        NaukriHomePage.openUrl(url);
        NaukriHomePage.enterUsername(user);
        NaukriHomePage.enterPassword(pass);
        NaukriHomePage.clickLoginButton();
        NaukriHomePage.clickmyProfileBtn();
        NaukriHomePage.clickdeleteResumeBtn();
        NaukriHomePage.clickconfirmDeleteBtn();

        // ✅ Upload directly (no popup)
        NaukriHomePage.selectResumeFile(filepath);

        Thread.sleep(2000); // optional pause
    }
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
