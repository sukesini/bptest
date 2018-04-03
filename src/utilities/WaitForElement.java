package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {
	
	 public static boolean VisibilityOfElement(WebDriver driver, WebElement ele){
		boolean isElementVisible = false;
		WebDriverWait wait = new WebDriverWait(driver, 40);
		if(wait.until(ExpectedConditions.visibilityOf(ele)) != null)
			isElementVisible = true;
		
		return isElementVisible;
	}
	
}
