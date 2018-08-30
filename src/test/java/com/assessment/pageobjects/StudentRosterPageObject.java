package com.assessment.pageobjects;
import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;
import java.util.Iterator;
import java.util.List;
	import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
	import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
	import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

	import com.scholastic.torque.common.TestBaseProvider;
	import com.scholastic.torque.common.TestBase;


	public class StudentRosterPageObject extends ParentPage{
		
		public StudentRosterPageObject(WebDriver driver) {
			
			super(driver);
			ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
			PageFactory.initElements(finder, this);
			this.driver = driver;
			this.waitForPageLoad(DRIVER_WAIT);
		}
		@FindBy(xpath = "//a[span[contains(text(),'Reports')]]")
		private WebElement reportstab;
		
		@FindBy(xpath = ".//*[@id='dd-sort']")
		private WebElement selectdropdown;
		
		public void clickReportstButton() {
			this.sync(reportstab).click();
			
		}
		public void clickdropdown() {
			this.sync(selectdropdown).click();
		
		
	}
		
				
	}
	