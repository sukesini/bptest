package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumBaseClass {
	public WebDriver driver;
	
	static{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			}
	
	public WebDriver InitializeDriver(){
		InitializeBrowser();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(ReadingConfigFile.DataReadFromConf("URL"));
		driver.manage().window().maximize();
		
		return driver;
	}
	
	private void InitializeBrowser(){
		switch (ReadingConfigFile.DataReadFromConf("BROWSER_NAME")){
		
		case "chrome":
			driver = new ChromeDriver(); 
			break;
		case "firefox":
			driver = new FirefoxDriver(); 
			break;
		case "internetexplorer":
			driver = new InternetExplorerDriver(); 
			break;
		}
	}
	
	public void CloseBrowser(){
		if(driver != null)
			driver.quit();
	}
}
