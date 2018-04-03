package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Address_Page {
	
WebDriver driver;
	
	public Address_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}	
	
	@FindBy(xpath="//button[@name='processAddress']")
	WebElement AddressCheckOut;
	
	@FindBy(xpath="//h1[contains(.,'S')]")
	WebElement Shipping;
	
	public void AddressCheckOut()
	{
		AddressCheckOut.click();
		
		if(Shipping != null)
			System.out.println("Passed: Adress is OK to be proceeded");
		else
			System.out.println("Failed:Wrong in Address");
				
		
		
		
	}

}
