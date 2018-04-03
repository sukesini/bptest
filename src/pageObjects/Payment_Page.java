package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment_Page {
	
WebDriver driver;
	
	public Payment_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//table[@id='cart_summary']/tbody/tr/td[@class='cart_unit']/span/span[3]")
	WebElement OldPrice;
	
	@FindBy(xpath="//table[@id='cart_summary']/tbody/tr/td[@class='cart_unit']/span/span[2]")
	WebElement PricePercentReduction;
	
	@FindBy(xpath="//table[@id='cart_summary']/tbody/tr/td[@class='cart_unit']/span/span[1]")
	WebElement SpecialPriceAfterReduction;
	
	@FindBy(xpath="//table[@id='cart_summary']/tbody/tr/td[@class='cart_unit']/span")
	WebElement NormalPrice_NoDiscount;
	
	@FindBy(xpath="//table[@id='cart_summary']/tbody/tr/td[5]")
	WebElement Quantity;
	
	@FindBy(xpath="//table[@id='cart_summary']/tbody/tr/td[@class='cart_total']")
	WebElement TotalPrice;
	
	@FindBy(xpath="//table[@id='cart_summary']/tfoot/tr[@class='cart_total_price']/td[@id='total_product']")
	WebElement TotalProduct;
	
	@FindBy(xpath="//table[@id='cart_summary']/tfoot/tr[@class='cart_total_delivery']/td[@id='total_shipping']")
	WebElement TotalShipping;
	
	@FindBy(xpath="//table[@id='cart_summary']/tfoot/tr[@class='cart_total_price']/td[@id='total_price_container']")
	WebElement FinalPrice;
	
	@FindBy(partialLinkText="Pay by bank wire ")
	WebElement BankWirePayment;
	
	@FindBy(partialLinkText="Pay by check ")
	WebElement CheckPayment;
	
	@FindBy(xpath="//h1[contains(.,'Order')]")
	WebElement OrderSummary;
	
	@FindBy(xpath="//table[@id='cart_summary']/tfoot/tr[3]/td[2]")
	WebElement ShippingCharge;
	
	
	
	public void BankWirePayment()
	{
		int cts=checkTotalSum();
		
		if(cts==1)
		{
			BankWirePayment.click();
			
		}	      	    		  
		      
		
		else
		{
			System.out.println("Fail:TotalSum is not valid");
		}
		
		}
			
		
	
	
	public void CheckPayment()
	{
		int cts=checkTotalSum();
		
		if(cts==1)
			CheckPayment.click();
		else
			System.out.println("Fail:TotalSum is not valid");
			
		
	}
	
	public int checkTotalSum()
	{
		double gtp=getTotalPrice();
		System.out.println(gtp);
		String spc=ShippingCharge.getText().trim();
		String spc2=spc.substring(1);
		double spc3=Double.parseDouble(spc2);
		double Total=gtp+spc3;
		String fpp=FinalPrice.getText().trim();
		String fpp1=fpp.substring(1);
		double Final=Double.parseDouble(fpp1);
		
		if(Total==Final)
		{
			
			System.out.println("Passed: Total Sum is correct. Please proceed for payment");
			return 1;
			
			
		}
		else
		{
		
		System.out.println("Failed: Total Sum is correct. Please proceed for payment");
		return 2;
		
		   
		   
		}
		
	}
	
	public double getTotalPrice(){
		double UP=UnitPrice();
		System.out.println(UP);
		int qt=Quantity();
		System.out.println(qt);
		double tp=UP*qt;
		System.out.println(tp);
		String tp1=TotalPrice.getText().trim();
		String tp2=tp1.substring(1);
		double tp3=Double.parseDouble(tp2);
		
		
		if(tp==tp3)
		{
			System.out.println("Passed: SubTotal Price(UnitPrice*Qty) is correct");
		return tp3;
		}
		
		else
		{
			tp3=0.0;
			System.out.println("Failed: SubTotal Price(UnitPrice*Qty) is not correct");
			return tp3;
		}
	}
	
	
	public double UnitPrice()
	{
				
		if(PricePercentReduction!=null)
		{
		
			String discounted_price1=SpecialPriceAfterReduction.getText().trim();
			String str11=discounted_price1.substring(1,discounted_price1.length()-1);
						
			return Double.parseDouble(str11);
				
		}
		
		else
		{
			String normal_price1=NormalPrice_NoDiscount.getText().trim();
			String str12=normal_price1.substring(1, normal_price1.length()-1);
			return Double.parseDouble(str12);
			
					
		}
	}
	
	public int Quantity()
	{
		String qt1=Quantity.getText().trim();
		int qt2=Integer.parseInt(qt1);
		return qt2;
	}
}
			
				
	
//	public void ProceedforBankWirePayment()
//	
//	{
//		//boolean t=IsTotalAmountCorrect();
//		
//		float st=CheckSubTotalPrice();
//		float sp=Float.parseFloat(ShippingCharge.getText());
//		
//		float total=st+sp;
//		float fp=Float.parseFloat(FinalPrice.getText());
//		
//		
//		
//		if(total==fp)
//		{
//			BankWirePayment.click();
//			System.out.println("Passed:Final amount is correct.");
//		}
//		
//		else
//		{
//			System.out.println("Failed:Wrong in Final amount.");
//		}
//		
//		if (OrderSummary != null)
//			System.out.println("Passed: BankWire payment Order is successfuly placed.");
//		else
//			System.out.println("Failed:BankWire payment Order is not placed");
//		
//	}
//	
//public void ProceedforCheckPayment()
//	
//	{
//				
//	float st=CheckSubTotalPrice();
//	float sp=Float.parseFloat(ShippingCharge.getText());
//	
//	float total=st+sp;
//	float fp=Float.parseFloat(FinalPrice.getText());
//	
//		
//		
//		
//		if(total==fp)
//		{
//			CheckPayment.click();
//			System.out.println("Passed:Final amount is correct.");
//		}
//		
//		else
//		{
//			System.out.println("Failed:Wrong in Final amount.");
//		}
//		
//		if (OrderSummary != null)
//			System.out.println("Passed: Check payment Order is successfuly placed.");
//		else
//			System.out.println("Failed:Check payment Order is not placed");
//		
//	}
//	
//	
//
//	
//	
//	
//	
//
//}
