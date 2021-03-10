package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import pageObjects.Login_Page;
import pageObjects.Home_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utility.Constants;

public class AmazonScript {
	static WebDriver driver;
	static Login_Page loginPage;
	static Home_Page homePage;
	private static String cartPrice, itemPrice, convertPrice;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Constants.Wait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constants.URL);
	}

	@Test
	public static void Cart() {
		// Pre-requisites : Before Adding the items in Cart , Verifying the Cart is
		// Empty other wise Delete it.
		loginPage = PageFactory.initElements(driver, Login_Page.class);
		homePage = PageFactory.initElements(driver, Home_Page.class);
		loginPage.LogIn_Action(Constants.User, Constants.Password);
		if (Integer.parseInt(homePage.getValueCart()) != 0) {
			homePage.clickCart();
			List<WebElement> ele = driver.findElements(By.xpath("//input[contains(@name,'submit.delete')]"));
			for (int i = 0; i < ele.size(); i++) {
				homePage.lnkDelete();
			}
		}
	}

	@Test(dependsOnMethods = { "Cart" }) // Reason for using this annotation is before adding item in the cart, Make sure he Pre-requiste should executed.
											
	public static void OrderExecution() {
		homePage.txtSearchBox(Constants.searchText);
		homePage.btnSubmitButton();
		itemPrice = homePage.getValueOfItemPrice();
		convertPrice = itemPrice.substring(0, 3) + "." + itemPrice.substring(4, 6);
		System.out.println(convertPrice);
		homePage.imgClick();
		cartPrice = homePage.getValueOfCartPrice();
		System.out.println(cartPrice);
		Assert.assertEquals(convertPrice, cartPrice);
		homePage.clickAddCart();
		Assert.assertEquals(cartPrice, homePage.getValueCheckoutPrice());
		homePage.proceedCheckOut();
	}

	@AfterClass
	public void tearDown() {
		// driver.close();
	}

}
