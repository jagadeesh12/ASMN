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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
	import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;


	import com.scholastic.torque.common.TestBaseProvider;
	import com.scholastic.torque.common.TestBase;


	public class AssignmnetmodalPageobject extends ParentPage{
		
		public AssignmnetmodalPageobject(WebDriver driver) {
			
			super(driver);
			ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
			PageFactory.initElements(finder, this);
			this.driver = driver;
			this.waitForPageLoad(DRIVER_WAIT);
		}
		
		WebDriver driver = TestBaseProvider.getTestBase().getDriver();
		final String PAGE_TITLE = "International Assessment";
	

		@FindBy(xpath = "//a[text()='Assign'][1]")
		private WebElement Assign;
		@FindBy(xpath = "//*[@id='single-button']")
		private WebElement selectbutton;
		@FindBy(xpath = "//a[text()='Assign'][1]")
		private WebElement Assigned;
		@FindBy(xpath = "//div[@class='modal-content']")
		private WebElement Assignmodalpopup;
		@FindBy(xpath = "//div[@class='btn-group ng-scope dropdown']//button")
		private WebElement selectclass;
		
		
		public void IsGradedropdownClicked() {
			
			this.sync(selectbutton).click();
			
	            
			}
	 public void ClickGrade(String Grade){
		  String xpath="//ul/li/a[contains(text(),'"+Grade+"')]";
		  driver.findElement(By.xpath(xpath)).click();
		  reportLog("Selected grade "+Grade+" from the dropdown");
		 }

	 
	 public void click_on_assign_book() throws InterruptedException {
			
		try{
			
			Assign.click();
			Thread.sleep(3000);
		}
		catch(Exception e){
			Thread.sleep(3000);
			this.sync(Assigned).click();
	}
	
	 }
	 WebDriverWait wait = new WebDriverWait(driver, 30);
	public boolean Assign_popup() {
		if ((Assignmodalpopup).isDisplayed())
			return true;
		else
			return false;

	}
public void Selectclass(){
	this.sync(selectclass).click();
	
}
public void Selectclassdropdown(String SelectClass){
	  String xpath="//ul/li/a[contains(text(),'"+SelectClass+"')]";
	  driver.findElement(By.xpath(xpath)).click();
	  reportLog("Selected Class "+SelectClass+" from the dropdown");
		
	}
public void selectdropdown2(String option) throws InterruptedException {

	driver.findElement(By.className("dropdown-menu")).click();
	
	Thread.sleep(3000);
	IsGradedropdownClicked();
	List<WebElement> options = driver.findElements(By
			.xpath("//ul[@class='dropdown-menu']/li"));
	for (WebElement opt : options) {
		if (opt.getText().equals(option)) {
			opt.click();
			return;
		}
}
	
	
}

public void selectdropdown8() throws InterruptedException {
	
	
	 List<WebElement> options =driver.findElements(By.xpath(".//*[@id='modal-body']/div/div[2]/div/div/ul"));
	   options.get(2).click();
	   
	    		//System.out.println(grade[i]+"grades");
	    		//if (options.get(i).getText().equals(grade[i])){
	    			//System.out.println(options.get(i).getText());
	            	 // System.out.println("macthed");

	    	}
public void Clickonassign() throws InterruptedException{
	this.sync(Assign).click();
    }

}
	    	
	    


