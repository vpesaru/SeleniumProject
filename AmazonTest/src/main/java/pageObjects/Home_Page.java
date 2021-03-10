package pageObjects;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Home_Page {
	
	WebDriver driver= null;
	
	public void Home_page (WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	@FindBy(id=	"nav-cart-count")
	private WebElement lnkcartIcon;

	@FindBy(xpath="//input[contains(@name,'submit.delete')]")
	private WebElement lnkdelete;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement txtSearch;
	
	@FindBy(id="nav-search-submit-button")
	private WebElement btnSubmit;
	
	@FindBy(xpath="(//img[@data-image-latency='s-product-image'])[1]")
	private WebElement imgLinkIcon;
	/*
	 * @FindBys({
	 * 
	 * @FindBy(xpath= "//div[@data-component-type='s-search-result']"),
	 * 
	 * @FindBy(xpath= "//div[@data-cel-widget='search_result_1']") }) private
	 * WebElement imgLinkIcon;
	 */
	@FindBy(xpath="(//span[@class='a-offscreen']/following-sibling::span)[1]")
	private WebElement lblPriceValue;
	
	@FindBy(id="add-to-cart-button")
	private WebElement btnAddCart;
	
	@FindBy(xpath = "(//span[contains(@class,'a-size-medium a-color-price')])[1]")
	private WebElement lblCartPrice;
	
	@FindBy(id="newBuyBoxPrice")
	private WebElement lblnewBoxPrice;
	
	@FindBy(xpath="//div[@id='hlb-subcart']/child::div[1]//span[2]")
			private WebElement lblCheckOutPrice;
	
	@FindBy(id="hlb-ptc-btn-native")
	private WebElement btnCheckOut;
	
	public void txtSearchBox(String text) {
		txtSearch.sendKeys(text);
		
	}
	
	public void btnSubmitButton() {
		btnSubmit.click();
	}
	
	public void imgClick() {
		imgLinkIcon.click();
	}
	
	public String getValueOfItemPrice() {
		String price = lblPriceValue.getText();
		return price;
	}
	
	public void clickAddCart() {
		btnAddCart.click();
	}
	
	public String getValueOfCartPrice() {
		
		if (lblCartPrice.isDisplayed()) {
			String cartPrice = lblCartPrice.getText();
			return cartPrice;
		}else {
			String cartPrice1= lblnewBoxPrice.getText();
			return cartPrice1;
		}
	}
	
	
	public String getValueCheckoutPrice() {
		String checkOutPrice = lblCheckOutPrice.getText();
		return checkOutPrice;
	}
	
	public void proceedCheckOut() {
		btnCheckOut.click();
		
	}
	
	public void clickCart() {
		lnkcartIcon.click();
	}
	
	public String getValueCart() {
		String value = lnkcartIcon.getText();
		return value;
	}
	
	public void lnkDelete() {
		lnkdelete.click();
	}
	
	
	
}
