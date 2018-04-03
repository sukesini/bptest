package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitForElement;

public class ProceedToCheckOut_Page {
	
 WebDriver driver;
	
	public ProceedToCheckOut_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[contains(.,'Proceed to checkout')]")
	WebElement ProceedToCheckOut;
	
	@FindBy(xpath="//h1[contains(.,'Shopping-cart')]")
	WebElement ProceedCartSummary;
	
		
	public void ProceedToCheckOut()
	{
		
		WaitForElement.VisibilityOfElement(driver, ProceedToCheckOut);
		ProceedToCheckOut.click();
		
		if(ProceedCartSummary.getText().contains("SHOPPING-CART SUMMARY"))
			System.out.println("Passed:Successfully proceeded to checkout");
		else
			System.out.println("Failed:Failed in proceeding to checkout");
			
		
		
	}
	
	
	
	
	}


