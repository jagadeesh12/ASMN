package com.assessment.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class ReportsPage extends ParentPage {
	public ReportsPage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	@FindBy(xpath = ".//h2[contains(text(),'Class Assessment List')]")
	private WebElement StudentAssListLabel;
	@FindBy(xpath = ".//section[1]/div[1]/div/a")
	private WebElement StudentAssesListReport;
	@FindBy(xpath = ".//h2[contains(text(),'Class Assessment List')]")
	private WebElement StudentAssListPgLabel;
	@FindBy(xpath = ".//*[@class='assessment-section']/div[1]/span/h2")
	private WebElement StdAssesmntListClassName;
	@FindBy(xpath = ".//*[@class='assessment-section']/div[2]//h2")
	private WebElement StdAssesmntListnoOfStudent;
	@FindBy(xpath = ".//*[@id='dd-calender']")
	private WebElement assesmentDropdown;
	@FindBy(xpath = ".//table//tbody/tr[1]")
	private WebElement assesmentScoreTable;

	@FindBy(xpath = ".//table//tbody/tr[1]/td[1]/a")
	private WebElement studentTableLink;
	@FindBy(xpath = ".//table//tbody/tr[1]/td[1]/a")
	private WebElement studentScoreLink;
	@FindBy(xpath = ".//*[@id='dd-calender']")
	private WebElement assesmentDropdownTakenList;

	public boolean isStudentAssesmentListDisplayed() {
		return this.sync(StudentAssListLabel).isDisplayed();

	}

	public void clickStudentAssesList() throws InterruptedException {
		lazyWait(10);
		driver.findElement(By.xpath(".//*[@id='dd-sort']")).click();
		lazyWait(2);
		driver.findElement(By.xpath(".//*[@id='dd-sort']/..//ul/li/a[contains(text(),'Maths-Class1')]")).click();
		lazyWait(5);
		System.out.println(StudentAssesListReport.isDisplayed());
		lazyWait(5);
		this.sync(StudentAssesListReport);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("var y= document.getElementsByTagName('a');y[15].click();"); 
		lazyWait(10);

	}

	public boolean isStudentAssesmentListPgDisplayed() {
		lazyWait(5);
		return this.sync(StudentAssListPgLabel).isDisplayed();

	}

	public boolean isStudentAssesmentClassNameDisplayed() {
		return this.sync(StdAssesmntListClassName).isDisplayed();

	}

	public boolean isStudentAssesmentListNofStudentsDisplayed() {
		return this.sync(StdAssesmntListnoOfStudent).isDisplayed();

	}

	public boolean AssesmentTakenDropdown() {

		return this.sync(assesmentDropdown).isDisplayed();
	}

	public boolean isAssesementScoreTableDisplayed() {
		return this.sync(StdAssesmntListnoOfStudent).isDisplayed();

	}

	public void clickAssesmentDropdown() {
		this.sync(assesmentDropdownTakenList);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", assesmentDropdownTakenList);

	}

	public void selectAssesement() {
		// Select sel = new Select(assesmentDropdownTakenList);
		// sel.selectByVisibleText("PA_1A_5.3 Solid Shape Patterns");
		this.sync(driver.findElement(By.xpath(".//div/ul/li/a[contains(text(),'PA_1A_5.3 Solid Shape Patterns')]")))
				.click();

	}

	public boolean isSelectedDropdownDisplayed() {
		lazyWait(10);
		String txt = this.sync(driver.findElement(By.xpath(".//*[@id='dd-calender']"))).getText();

		return txt.contains("PA_1A_5.3 Solid Shape Patterns");
	};

	public boolean isMultipleAssesmentTakenDisplayed() {
		this.sync(driver.findElement(By.xpath("//table/tbody/tr")));
		List<WebElement> ele = driver.findElements(By.xpath("//table/tbody/tr"));
		return (ele.size() > 0);
	}

	public void clickStudentLink() {
		lazyWait(10);
		this.sync(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/a"))).click();

	}

	public boolean isStudentPAgeDisplayed() {
		lazyWait(5);
		this.sync(driver.findElement(By.xpath(".//div[1]/h5/span")));
		return driver.findElement(By.xpath(".//div[1]/h5/span")).getText().contains("Student");

	}

	public void clickScoreLink() {
		lazyWait(5);
		this.sync(driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]/a//span"))).click();

	}

	public boolean isScorePAgeDisplayed() {
		lazyWait(5);
		this.sync(driver.findElement(By.xpath(".//div[1]/h5/span")));
		return driver.findElement(By.xpath(".//section[2]/div[2]/div/span[2]")).getText().contains("Score");
	}

	public boolean IsScoreToolTipisDisplayed() {
		lazyWait(5);

		return driver.findElement(By.xpath("(.//*[@class='progress'])[1]")).getAttribute("uib-tooltip")
				.contains("of the total score was answered correctly");
	}

}
