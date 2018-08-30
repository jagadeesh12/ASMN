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

public class HelpPageObject extends ParentPage {

	public HelpPageObject(WebDriver driver) {

		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	final String PAGE_TITLE = "International Assessment";

	@FindBy(xpath = "//a[@title='Need Help?']")
	private WebElement needhelp;

	public String Tooltiphelplink() throws InterruptedException {
		Thread.sleep(30000);

		WebElement element = driver.findElement(By.xpath("//i[@class='fa fa-question']"));
		Actions toolAct = new Actions(driver);
		toolAct.moveToElement(element).build().perform();
		WebElement toolTipElement = driver.findElement(By.xpath("//a[@title='Need Help?']"));
		toolAct.moveToElement(toolTipElement);

		toolAct.click();
		toolAct.perform();
		String toolTipText = toolTipElement.getText();
		System.out.println(toolTipText);
		return toolTipText;

	}

	public void verify_help_link_URL() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		lazyWait(15);
		String expected = "https://qa-assessment.scholasticlearningzone.com/educator.html#!/assessments";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);

	}

	public void verify_help_icon() {
		if (driver.findElements(By.xpath("//a[@title='Need Help?']")).size() != 0) {
			System.out.println("Element is Present");
		} else {
			System.out.println("Element is Absent");
		}
	}
}