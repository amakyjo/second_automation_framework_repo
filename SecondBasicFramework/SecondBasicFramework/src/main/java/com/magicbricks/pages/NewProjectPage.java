package com.magicbricks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewProjectPage extends AbstractPage{

	public NewProjectPage(WebDriver driver) {
		super(driver);	
	}
	
	public void searchNewProject(){
		try{
			logger.info("The searchNewProject method has been initiated");
			driver.findElement(By.id("keyword")).sendKeys("");;
			logger.info("The project location has been entered successfully");
			
			WebElement propertyType = driver.findElement(By.id("buy_propertyType"));
			Select selectPropertyType = new Select(propertyType);
			selectPropertyType.selectByVisibleText("flat");
			
		}catch(Throwable t){
			logger.error("The searchNewProject method has encountered error" +t);
			camera.takeShot("searchNewProject");
		}
		
	}

}
