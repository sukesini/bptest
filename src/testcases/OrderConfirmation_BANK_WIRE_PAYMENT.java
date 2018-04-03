package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AddToCart_Page;
import pageObjects.Address_Page;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import pageObjects.MyAccount_Page;
import pageObjects.OrderConfirmation_Page;
import pageObjects.OrderSummary_Page;
import pageObjects.Payment_Page;
import pageObjects.ProceedToCheckOut_Page;
import pageObjects.SearchResult_Page;
import pageObjects.Shipping_Page;
import pageObjects.ShoppingCartSummary_Page;
import utilities.ReadExcel;
import utilities.ReadingConfigFile;
import utilities.SeleniumBaseClass;

public class OrderConfirmation_BANK_WIRE_PAYMENT extends SeleniumBaseClass {
	Home_Page hm; 
	LogIn_Page lp;
	MyAccount_Page ap;
	SearchResult_Page arp;
	AddToCart_Page atcp;
	ProceedToCheckOut_Page ptco;
	ShoppingCartSummary_Page scsp;
	Address_Page add;
	Shipping_Page sp;
	Payment_Page pp;
	OrderSummary_Page osp;
	OrderConfirmation_Page ocp;
	
	
	
	@BeforeSuite
	void DataReading(){
		ReadExcel.InsertExcelDataIntoMap(ReadingConfigFile.DataReadFromConf("DatasetColNum"));
	}
	
	@BeforeTest
	public void OpenApp(){
		driver = InitializeDriver();
		 hm = new Home_Page(driver);
		lp = new LogIn_Page(driver);
		ap = new MyAccount_Page(driver);
		arp=new SearchResult_Page(driver);
		atcp=new AddToCart_Page(driver);
		ptco=new ProceedToCheckOut_Page(driver);
		scsp=new ShoppingCartSummary_Page(driver);
		add=new Address_Page(driver);
		sp=new Shipping_Page(driver);
		pp=new Payment_Page(driver);
		osp=new OrderSummary_Page(driver);
		ocp=new OrderConfirmation_Page(driver);
	}
	
	@Test
	
	public void OrderConfirmation_BankWirePayment(){
		

		hm.signin();
		lp.LogIn();	
		ap.searchitems();
		arp.selectItem(ReadExcel.GetDataFromExcel("item"));
		atcp.AddToCart();
		ptco.ProceedToCheckOut();
		scsp.ShoppingCartSummary();
		add.AddressCheckOut();
		sp.AgreeTermsOfService();
		sp.ShippingCheckOut();
		pp.checkTotalSum();
	    pp.BankWirePayment();
	    osp.BankWireConfirmation();
	    ocp.OrderConfirmation();
		
			}
	
	
	
	@AfterTest
		void CloseApp(){
		CloseBrowser();
	}

}
