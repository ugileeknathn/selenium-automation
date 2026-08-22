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
        	// Initialize page object once at class level
        	NaukriHomePage = new NaukriHomePage(driver);
    }
	
	 @Test
	    public void openWebsite() throws IOException {
		 Properties prop = new Properties();
	        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
			prop.load(fis);
		
	        String url = prop.getProperty("url");
	        String user = prop.getProperty("username");
	        String pass = prop.getProperty("password");
	        
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	     	NaukriHomePage.openUrl(url);
	     	NaukriHomePage.enterUsername(user);
	     	NaukriHomePage.enterPassword(pass);
	     	NaukriHomePage.clickdeleteResumeBtn();
	     	
	        System.out.println("Page Title: " + driver.getTitle());
	        driver.quit();
	    }
	 
	 @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
}
