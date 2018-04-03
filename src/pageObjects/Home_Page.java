package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	 WebDriver driver;
	
	public Home_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}	
	
	@FindBy(className="login")
	WebElement SignIn;
	
	@FindBy(id="search_query_top")
	WebElement searchinHome;
	
	@FindBy(name="submit_search")
	WebElement submitsearch;
//
//	@FindBy(partialLinkText="WOMEN")
//	WebElement WOMEN;
//	
//	@FindBy(partialLinkText="DRESSES")
//	WebElement DRESSES;
	
//	@FindBy(linkText="T-SHIRTS")
//	WebElement TSHIRTS;
	
	@FindBy(xpath="//div[@class='shopping_cart']/a/b[.='Cart']")
	WebElement Cart;
	
	@FindBy(id="SubmitCreate")
	WebElement Authentication;
	
	
	
	public void signin(){
		
		SignIn.click();	

		
		if(Authentication.getText().contains("Create an account"))
			System.out.println("Passed:Authentication Page displayed");
         else
	         System.out.println("Failed:Authentication Page not displayed");
		
				}
			
	
	
	public void search(){
		
		searchinHome.sendKeys("dresses");
		
	}
	
public void submitsearch(){
		
		submitsearch.click();
		
	}
	
	
	

}
