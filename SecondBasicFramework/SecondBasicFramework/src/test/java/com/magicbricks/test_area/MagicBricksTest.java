package com.magicbricks.test_area;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.magicbricks.pages.AbstractPage;
import com.magicbricks.pages.SellPropertyPage;


public class MagicBricksTest {
	
	private WebDriver driver;
	private AbstractPage abstractPage;
	private SellPropertyPage sellPropPage;
	
	
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		abstractPage = new AbstractPage(driver);
		sellPropPage = new SellPropertyPage(driver);
		
		abstractPage.openAndMaximizeBrowser();
	}
	

	@Test
	public void sellProperty(){
		abstractPage.openSellPropertyPage();
		sellPropPage.enterPropertyInfo();
	}
	@After
	public void closeBrowser(){
		abstractPage.tearDownBrowser();
}
	
	
}


