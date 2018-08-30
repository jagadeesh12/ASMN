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

public class AssessmentlogoPageobject extends ParentPage {

	public AssessmentlogoPageobject(WebDriver driver) {

		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	final String PAGE_TITLE = "International Assessment";

	@FindBy(xpath = "//img[@src='assets/images/asmnt-prime-reading-logo.png']")
	private WebElement Assessment_logo;

	@FindBy(xpath = "//a[contains(.,' Assessments')]")
	private WebElement Assessments;

	@FindBy(xpath = "//a[contains(.,' Reports')]")
	private WebElement Reports;

	@FindBy(xpath = "//h2[text()='Assessments']")
	private WebElement AssessmentsPage;

	@FindBy(xpath = "//h2[contains(.,'Reports')]")
	private WebElement ReportsPage;

	@FindBy(xpath = "//a[@ui-sref='educator.home']/img")
	private WebElement Logo;

	@FindBy(xpath = "//h2[contains(.,'Home')]")
	private WebElement Homepage;

	@FindBy(xpath = ".//*[@id='dd-sort']")
	private WebElement ClassDropdown;

	@FindBy(xpath = "//a[@title='Logout']/i")
	private WebElement Logout;

	public boolean Assessmentlogoimg() {
		try {
			this.Assessment_logo.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void verifylogo() {
		if (driver.findElements(By.xpath("//img[@src='assets/images/asmnt-prime-reading-logo.png']")).size() != 0) {
			System.out.println("logo is Present");
		} else {
			System.out.println("logo is Absent");
		}
	}

	public void clickOnAssessment() {
		try {

			this.sync(Assessments).click();
			this.lazyWait(5);
			System.out.println("Clicked on Assessment link");

		} catch (NoSuchElementException e) {

		}
	}

	public boolean verifyAssessmentPage() {
		try {
			this.AssessmentsPage.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public boolean verifyClassDropdown() {
		try {
			this.ClassDropdown.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void clickOnLogo() {
		try {
			this.sync(Logo).click();
			this.lazyWait(5);

		} catch (NoSuchElementException e) {
			e.printStackTrace();

		}

	}

	public boolean verifyHomePage() {
		try {
			this.Homepage.getTagName();
			return true;

		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public void clickOnReports() {
		try {
			this.sync(Reports).click();
			this.lazyWait(5);
		} catch (NoSuchElementException e) {
			e.printStackTrace();

		}
	}

	public void clickClassDropdown() {
		try {
			this.ClassDropdown.click();

		} catch (NoSuchElementException e) {
			e.printStackTrace();

		}
	}

	public void logout() {
		try {
			this.Logout.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();

		}
	}

	public void selectClass(String classname) {
		String cname = "//a[contains(text(),'" + classname + "')]";
		driver.findElement(By.xpath(cname)).click();
		reportLog("Selected Class" + classname + " from the dropdown");
		this.lazyWait(3);
	}

	public boolean verifyReportsPage() {
		try {
			this.Reports.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
