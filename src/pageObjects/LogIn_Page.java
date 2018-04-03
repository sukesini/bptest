package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReadExcel;

public class LogIn_Page {
	
WebDriver driver;
	
	public LogIn_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(name="passwd")
	WebElement pwd;
	
	@FindBy(name="SubmitLogin")
	WebElement submit;
	
	@FindBy(partialLinkText="Forgot")
	WebElement forgotpwd;
	
	@FindBy(id="email_create")
	WebElement emailcreate;
	
	@FindBy(xpath="//p[@class='info-account']")
	WebElement MyAccount;
	
	public void LogIn()
	{
		
		
		email.sendKeys(ReadExcel.GetDataFromExcel("email"));
		pwd.sendKeys(ReadExcel.GetDataFromExcel("pwd"));
		submit.click();
		
		if(MyAccount.getText().contains("Welcome to your account"))
			System.out.println("Passed:Login is successful");
         else
	         System.out.println("Failed:Login is failed");
	}
	
	
	
	

	

}
