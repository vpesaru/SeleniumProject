package pageObjects;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;


public class Login_Page {
	
	final WebDriver driver;
	
	
	public Login_Page(WebDriver driver){
		this.driver = driver;
		
	}
	
	@FindBy(id="nav-link-accountList")
	private WebElement signMenuOption;
	
	@FindBy(id="ap_email")
	private WebElement txtEmailId;
	
	@FindBy(id="continue")
	private WebElement btnContinue;
	
	@FindBy(id="ap_password")
	private WebElement txtPassword;
	
	@FindBy(id="signInSubmit")
	private WebElement btnSignIn;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement txtSearch;
	
	@FindBy(id="nav-search-submit-button")
	private WebElement btnSubmit;
	
	public void LogIn_Action (String uName, String pwd) {
		Actions action = new Actions(driver);
		//WebElement signMenuOption = driver.findElement(By.id("nav-link-accountList"));
		action.moveToElement(signMenuOption).click().perform();
		txtEmailId.sendKeys(uName);
		btnContinue.click();
		txtPassword.sendKeys(pwd);
		btnSignIn.click();
	}


}
