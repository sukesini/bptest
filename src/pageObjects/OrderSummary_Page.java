package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummary_Page {
	
	
 WebDriver driver;
	
	public OrderSummary_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h3[contains(.,'Bank-wire payment')]")
	WebElement BankWireConfirmation;
	
	@FindBy(xpath="//h3[contains(.,'Check')]")
	WebElement CheckConfirmation;
	
	@FindBy(xpath="//button[@type='submit']/span[contains(.,'I confirm')]")
	WebElement ConfirmOrder;
	
	public void BankWireConfirmation()
	{
		if(BankWireConfirmation!=null)
			
			ConfirmOrder.click();
		else
			System.out.println("Fail:Valid confirmation page is not displayed.");
		
	}
	
	public void CheckConfirmation()
	{
		if(CheckConfirmation!=null)
			
			ConfirmOrder.click();
		else
			System.out.println("Fail:Valid confirmation page is not displayed.");
		
	}
	
	
	}


