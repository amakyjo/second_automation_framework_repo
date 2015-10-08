package com.magicbricks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SellPropertyPage extends AbstractPage{

	public SellPropertyPage(WebDriver driver) {
		super(driver);
	}

	public void enterPropertyInfo(){
		try{
			logger.info("The enterPropertyInfo method has been initiated");
			driver.findElement(By.id("propertyForS")).click();
			
			WebElement propertyType = driver.findElement(By.id("propertyType"));
			Select selectPropertyType = new Select(propertyType);
			selectPropertyType.selectByVisibleText("Villa");
			logger.info("The property info has been entered successfully");
			
			WebElement propertyLocation = driver.findElement(By.id("quickCity"));
			Select selectPropertyLoc = new Select(propertyLocation);
			selectPropertyLoc.selectByVisibleText("New Delhi");
			logger.info("The property location has been entered successfully");
			
		}catch(Throwable t){
			logger.error("The enterPropertyInfo method has encountered error" +t);
			camera.takeShot("enterPropertyInfo");
		}
		
	}
}
