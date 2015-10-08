package com.magicbricks.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.magicbricks.utilities.Screenshot;
import com.magicbricks.utilities.UrlFormatter;


public class AbstractPage {

	protected static WebDriver driver;
	protected static Properties config = new Properties();
	protected static InputStream fis;
	protected static Screenshot camera;
	protected static Logger logger = LogManager.getLogger("TestLogger");

	public AbstractPage(WebDriver driver){
		this.driver = driver;
		
		camera = new Screenshot(driver);
		try {
			fis = new FileInputStream("C:\\Automation\\Projects\\second_automation_framework_repo\\SecondBasicFramework\\SecondBasicFramework\\src\\main\\resources\\testData.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openAndMaximizeBrowser(){
		try{
			logger.info("The openAndMaximiseBrowser method is started correctly");	
			driver.manage().window().maximize();
			logger.info("Browser has been maximized");
			String formatedUrl = UrlFormatter.formatUrl(config.getProperty("baseUrl"));
			logger.info("The Url has been formatted correctly");
			driver.navigate().to(formatedUrl);
			logger.info("The Web address has been loaded successfully");
		}catch(Throwable t){
			logger.error("The openAndMaximizeBrowser Method has encountered error" +t);
			camera.takeShot("openAndMaximizeBrowser");
		}
	}
	

	public void openSellPropertyPage() {
		try{
			logger.info("The openSellPropertyPage method has been initiated");
			driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div/div/div[2]/div[2]/ul/li[4]/a")).click();;
			logger.info("The sell/rent property link has been clicked successfully");
		}catch(Throwable t){
			logger.error("The openSellPropertyPage method has encountered error" +t);
			camera.takeShot("openSellPropertyPage");
		}
		
	}
	
	public void tearDownBrowser(){
		try{
			logger.info("The tearDownBrowser method has been initiated");
			driver.quit();
			logger.info("Browser has now quit");
			driver = null;
			logger.info("Browser has no value anymore");
		}catch(Throwable t){
			logger.error("The tearDownBrowser method has encountered error" +t);
			camera.takeShot("tearDownBrowser");
		}
	}
}
