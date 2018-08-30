package com.assessment.pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import com.scholastic.torque.common.TestBaseProvider;
import com.scholastic.torque.common.TestBase;

public class ClassGradeDropdown extends ParentPage {

	public ClassGradeDropdown(WebDriver driver) {

		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	final String PAGE_TITLE = "International Assessment";

	@FindBy(xpath = "//*[@id='single-button']")
	private WebElement selectbutton;
	@FindBy(xpath = "//a[text()='Grade 1 ']")
	private WebElement Grade1;
	@FindBy(xpath = "//a[text()='Grade 2 ']")
	private WebElement Grade2;
	@FindBy(xpath = "//a[@href='/logout']")
	private WebElement logOutLink;
	@FindBy(xpath = "//i[@class='fa fa-check pull-right icon-check cursor-pointer ng-scope']")
	private WebElement deafult;
	@FindBy(xpath = "//*[@id='single-button']/span[1]")
	private WebElement defaultword;
	@FindBy(xpath = "//i[@class='fa fa-star pull-right icon-check ng-scope']")
	private WebElement star;
	@FindBy(xpath = "//img[@src='assets/images/info-icon.png']")
	private WebElement defaultttooltip;

	public boolean IsGradedropdownClicked() {
		try {
			this.sync(selectbutton).click();
			return true;
		} catch (NoSuchElementException e) {
			return false;

		}
	}

	public boolean IsGradedisplayed(String Grades) {
		try {
			this.sync(Grade1).click();
			return true;
		} catch (NoSuchElementException e) {
			return false;

		}
	}

	public boolean clickLogoutButton() {
		try {
			this.sync(logOutLink).click();
			return true;
		} catch (NoSuchElementException e) {
			return false;

		}
	}

	public void selectdrop(String option) throws InterruptedException {

		driver.findElement(By.className("dropdown-menu")).click();
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));
		for (WebElement opt : options) {
			if (opt.getText().equals(option)) {
				opt.click();
				return;
			}
		}

	}

	public boolean IsdeafultcheckmarkClicked() {
		try {
			this.sync(deafult).click();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	/*
	 * public boolean IsdeafultcheckmarkClickedGrade() throws InterruptedException{
	 * 
	 * try{ if(star.isDisplayed()){ IsGradedropdownClicked(); Thread.sleep(3000);
	 * this.sync(Grade2).click(); Thread.sleep(3000); this.sync(deafult).click(); }
	 * else{ this.sync(deafult).click(); } return true; } catch
	 * (NoSuchElementException e){ return false; } }
	 */

	public void dropdown() throws InterruptedException {
		// driver.findElement(By.className("dropdown-menu")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='single-button']")));
		IsGradedropdownClicked();
		Thread.sleep(6000);

		// Get all options
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li[@class='ng-scope']"));
		WebElement xpathofnewdefult = null;
		// Get the length
		System.out.println(options.size());

		// Loop to print one by one
		for (int j = 1; j <= options.size(); j++) {

			if (options.get(j).getText().contains("Default")) {
				continue;
			} else {
				// xpathofnewdefult=options.get(j);
				this.sync(options.get(j)).click();
				this.sync(deafult).click();
				break;

			}
		}
		// System.out.println(xpathofnewdefult + "Rachna");
	}

	public void selectdropdown8() throws InterruptedException {
		String[] grade = { "Grade 1", "Grade12", "Grade 2", "Grade 3", "Grade 4", "Grade 5", "Grade 6", "Grade 10",
				"Grade1A", "Grade1b", "Grade1c", "Grade@#$%$", "GradeABC", "Grade_1", "Grade_A", "Year 1", "Year 2",
				"Year 3" };
		driver.findElement(By.className("dropdown-menu")).click();
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));

		Thread.sleep(3000);

		{
			for (int i = 0; i < grade.length; i++) {
				System.out.println(options.get(i).getText() + "matched");
				System.out.println(grade[i] + "grades");
				// if (options.get(i).getText().equals(grade[i])){
				// System.out.println(options.get(i).getText());
				// System.out.println("macthed");

			}

		}

	}

	public void selectdropdown9() {
		String init[] = { "Grade 1", "Grade12", "Grade 2", "Grade 3", "Grade 4", "Grade 5", "Grade 6", "Grade 10",
				"Grade1A", "Grade1b", "Grade1c", "Grade@#$%$", "GradeABC", "Grade_1", "Grade_A", "Year 1", "Year 2",
				"Year 3" };

		// create one list
		List list = new ArrayList(Arrays.asList(init));

		System.out.println("List value before: " + list);

		// sort the list
		Collections.sort(list);

		System.out.println("List value after sort: " + list);

	}

	// public void selectdefault(){
	// this.sync(defaultword).click();

	// public void Selectstar(){
	// this.sync(star).click();

	public void Isstariconpresent() {

		if (driver.findElements(By.xpath("star")).size() != 0) {
			System.out.println("Element is Present");
		} else {
			System.out.println("Element is Absent");
		}
	}

	public void defaultttooltip() {
		WebElement element = driver.findElement(By.xpath("//img[@src='assets/images/info-icon.png']"));

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();

		WebElement subElement = driver.findElement(By.xpath("//i[@class='icon-info-circle']"));
		action.moveToElement(subElement);

		action.click();

		action.perform();

	}

	public String getdefaultText() {
		String defaulttext = null;
		String text;
		defaulttext = this.defaultword.getText();
		text = ("Default text: " + defaulttext);
		System.out.println(text);
		return text;
	}

	public void Defaulttextispresent() {
		if (driver.getPageSource().contains("Grade 3 is the default view")) {
			System.out.println("Text is present");
		} else {
			System.out.println("Text is absent");
		}

	}

}