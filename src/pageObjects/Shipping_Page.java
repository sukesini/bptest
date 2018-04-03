package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shipping_Page {
WebDriver driver;
	
	public Shipping_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}	
	
	@FindBy(id="cgv")
	WebElement TermsOfService;
	
	@FindBy(name="processCarrier")
	WebElement ShippingCheckOut;
	
	@FindBy(xpath="//h1[contains(.,'Please choose your payment method')]")
	WebElement PaymentMethod;
	
	public void AgreeTermsOfService()
	{
		TermsOfService.click();
	}
	
	public void ShippingCheckOut()
	{
		ShippingCheckOut.click();
		
		if(PaymentMethod != null )
			System.out.println("Passed:Shipping charge is OK to be proceeded for Payment");
		else
			System.out.println("Failed:Wrong in Shipping charge. Do not proceed for Payment");
	}

}
