package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummary_Page {
	
WebDriver driver;
	
	public ShoppingCartSummary_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//p[@class='cart_navigation clearfix']/a/span")
	WebElement SummaryCheckOut;
	
	@FindBy(xpath="//h1")
	WebElement Address;
	
	public void ShoppingCartSummary()
	{
		
		
		SummaryCheckOut.click();
		
		if(Address !=null)
			System.out.println("Passed:Summary is fine to be proceeded to Address section");
		else
			System.out.println("Failed:Summary is wrong");
			
		
		
	}

}
