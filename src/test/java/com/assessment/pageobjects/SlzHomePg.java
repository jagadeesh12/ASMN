package com.assessment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.assessment.pageobjects.AssessmentPg;
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

public class SlzHomePg extends ParentPage {
	TestBase testBase = TestBaseProvider.getTestBase();
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();

	@FindBy(xpath = "//*[@id='topnav']/p[1]")
	private WebElement studentText;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Hi ')]")
	private WebElement greetText;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'zone=LF')]")
	private WebElement lpProduct;

	@FindBy(xpath = "//*[@id='product-access']/div/ul/li/a/img")
	private WebElement lpIcon;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Manage users')]")
	private WebElement manageUsersLink;

	public SlzHomePg(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	public String getUserGreetingText() {
		return this.getText(greetText);
	}

	public String getStudentGreetingText() {
		return this.getText(studentText);
	}

	public void goToManageUsersPg() {
		this.reportLog("Go to Manage Users Page");
		this.click(manageUsersLink);
	}

	public boolean closeWelcomePopup() {
		WebElement doNotShowWelcomeChkBx = this
				.getElement(By.xpath(".//span[contains(text(),'Do not show this message again')]"), 5);
		if (doNotShowWelcomeChkBx != null) {
			doNotShowWelcomeChkBx.click();
			WebElement welcomePopupOkBtn = this.getElement(By.xpath(".//button[contains(text(),'Close')]"));
			if (welcomePopupOkBtn != null) {
				welcomePopupOkBtn.click();
				this.reportLog("Closed Welcome Popup");
				return true;
			} else {
				this.reportLog("'Ok' button NOT displayed in Welcome popup");
				return false;
			}
		} else {
			this.reportLog("Welcome Popup NOT displayed");
		}
		return true;
	}

	/* accept Terms of service */
	public boolean acceptOfToSDialog() {
		WebElement dialogWe = this.getElement(By.id("ui-dialog-title-dialog"), 3);
		if (dialogWe != null) {
			WebElement tosPopupOkBtn = this.getElement(By.xpath("//button[span[text()='Ok']]"));
			tosPopupOkBtn.click();
			this.reportLog("Accepted the ToS");
			return true;
		}
		return false;
	}

	@Override
	protected void openPage() {
		// TODO Auto-generated method stub
	}

	// Assessment product launch method

	public AssessmentPg launchAssessment() throws InterruptedException {
		this.reportLog("Launch Assessment");
		if (!this.LaunchAssessmentLink()) {
			this.reportLog("[Error] Assessment product link NOT displayed");
			return null;
		}
		this.switchToNewWindow();
		return new AssessmentPg(driver);
	}

	public boolean LaunchAssessmentLink() {
		driver = TestBaseProvider.getTestBase().getDriver();
		this.sync(this.getElement(By.xpath(".//*[@alt='btn_pas']")));

		WebElement AssessmentLink = this.getElement(By.xpath(".//*[@alt='btn_pas']"));
		if (AssessmentLink != null) {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", AssessmentLink);
			// lpLink.click();
			return true;
		} else {
			this.reportLog("Assessment product link NOT displayed. If logging in first time, close the welcome popup");
			return false;
		}
	}
}
