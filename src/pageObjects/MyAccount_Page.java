package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReadExcel;

public class MyAccount_Page {
WebDriver driver;
@FindBy(className="icon-home")
WebElement homeicon;

@FindBy(xpath="//input[@id='search_query_top']")
WebElement searchbox;

@FindBy(name="submit_search")
WebElement searchicon;

	
	public MyAccount_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void searchitems(){
		searchbox.click();
				
		searchbox.sendKeys(ReadExcel.GetDataFromExcel("searchitems"));
		searchicon.click();
	if(driver.findElements(By.xpath("//div[@class='product-count']")).size()!=0)
		System.out.println("Passed:Search result is displayed");
	else
		System.out.println("Failed:No result displayed");	
	
	
	
		
	}
	
		

}
