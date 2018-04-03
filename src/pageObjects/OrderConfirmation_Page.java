package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmation_Page {
WebDriver driver;
	
	public OrderConfirmation_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//p/strong")
	WebElement OrderConfirmation;
	
	public void OrderConfirmation()
	{
		if(OrderConfirmation!=null)
			System.out.println("Pass:Order is successfully placed");
		else
			System.out.println("Fail:Order is not correctly placed");
	}
	}


