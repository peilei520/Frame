package com.peilei.framework;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.Browser;
import driver.DriverFactory;

@Test
public class BaseCase {
	public static RemoteWebDriver driver = null;

	@BeforeClass
	@Parameters("browser")
	public void init(@Optional("IE_BROWER") Browser browser){
		 driver = DriverFactory.getDriver(browser);

	}
	@AfterClass
	public void kill(){
		if(driver != null && driver instanceof RemoteWebDriver){
//			driver.quit();
		}
	}
	//获取窗口句柄
		public void Handles(){
			 Set<String> windowHandle = driver.getWindowHandles();
			if(windowHandle !=null && windowHandle.size()>0){
				Object[] array = windowHandle.toArray();
				String Handle = array[array.length-1].toString();
				if(Handle != null && Handle.trim().length()>0){
					driver.switchTo().window(Handle);
				}
				windowHandle.clear();
			}
		}
	
		
	}


