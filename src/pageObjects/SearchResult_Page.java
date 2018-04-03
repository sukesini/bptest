package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResult_Page {
	
	WebDriver driver;
	
	public SearchResult_Page(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Printed Summer Dress")
	WebElement YellowPrintedSummerDress;
	
	@FindBy(linkText="Printed Dress")
	WebElement OrangePrintedDress;
	
	@FindBy(linkText="Faded Short Sleeve T-shirts")
	WebElement FadedT;
	
	@FindBy(linkText="Blouse")
	WebElement Blouse;
	
	public void selectItem(String item){
		
		driver.findElement(By.linkText(item)).click();
		if(driver.findElement(By.linkText("Write a review")) != null)
			System.out.println("Passed:Require item is selected");
		else
			System.out.println("Failed:Require item does not exist anymore");		
		
		
	}

}
