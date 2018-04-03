package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitForElement;

public class AddToCart_Page {
	
WebDriver driver;
	
	public AddToCart_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}	
	
	@FindBy(xpath="//button[@class='exclusive']")
	WebElement AddToCart;
	
	@FindBy(xpath="//span[contains(.,'Proceed to checkout')]")
	WebElement ProceedToCheckOut;
	
	public void AddToCart()
	{
		
		AddToCart.click();
		WaitForElement.VisibilityOfElement(driver, ProceedToCheckOut);
		if(ProceedToCheckOut != null)
			System.out.println("Passed:Item is added to cart");
		else
			System.out.println("Failed:Item is not added to cart");	
			
				
	}
	}


