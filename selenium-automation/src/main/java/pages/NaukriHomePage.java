package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NaukriHomePage {

				WebDriver driver;
				
				public NaukriHomePage(WebDriver driver) {
			        this.driver = driver;
			    }

			    // Locators using XPath
			    By usernameField = By.xpath("//input[@id='usernameField']");
			    By passwordField = By.xpath("//input[@id='passwordField']");
			    By loginButton   = By.xpath("//button[text()='Login']");
			    By myProfileBtn  = By.xpath("(//div[@class='view-profile-wrapper']/a)[1]");
			    By deleteResumeBtn  = By.xpath("//span[@data-title='delete-resume']");
			    
			    
		        
			    // Actions
			    public void openUrl(String url) {
			        driver.get(url);
			    }
			    
			    public void enterUsername(String username) {
			        driver.findElement(usernameField).sendKeys(username);
			    }

			    public void enterPassword(String password) {
			        driver.findElement(passwordField).sendKeys(password);
			    }

			    public void clickLoginButton() {
			        driver.findElement(loginButton).click();
			    }
			    
			    public void clickmyProfileBtn() {
			        driver.findElement(myProfileBtn).click();
			    }
			    
			    public void clickdeleteResumeBtn() {
			        driver.findElement(deleteResumeBtn).click();
			    }

}
