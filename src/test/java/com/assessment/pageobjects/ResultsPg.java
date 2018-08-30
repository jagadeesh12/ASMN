package com.assessment.pageobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.scholastic.torque.common.TestBaseProvider;

//import pageobject.ParentPage;

public class ResultsPg extends ParentPage {
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	final String PAGE_TITLE = "Scholastic";

	@FindBy(xpath = "//button[contains(text(),'Get Started')]")
	private WebElement letsGetStartedBtn;

	@FindBy(xpath = "//button[contains(text(),'Go On')]")
	private WebElement goOndBtn;

	@FindBy(xpath = "(//div[@class='quizContentDiv']//div[contains(@class,'answertext')])[1]")
	private WebElement firstAnswer;

	@FindBy(xpath = "(//div[contains(@class,'answertext')])[2]")
	private WebElement secAnswer;

	@FindBy(xpath = "(//div[contains(@class,'answertext')])[3]")
	private WebElement thirdAnswer;

	@FindBy(xpath = "(//div[contains(@class,'answertext')])[4]")
	private WebElement fourthAnswer;

	@FindBy(xpath = "//div[contains(@class,'testIcon-0-true')]")
	private WebElement firstAnswerSelected;

	@FindBy(xpath = "//div[@class='quizContentDiv']/div[@class='selected-true']")
	private WebElement selectedAnsText;

	@FindBy(xpath = "//div[@class='buttonArea']/button[contains(text(),'Next')]")
	private WebElement nextBtn;

	@FindBy(xpath = "//div[@class='sriQuizPage']/div[contains(@class, 'question')]")
	private WebElement questionText;

	@FindBy(xpath = "//div[contains(text(),'Congratulations')]")
	private WebElement congratsMessage;

	@FindBy(xpath = "//button[contains(text(),'Create Reading List')]")
	private WebElement creatingReadingListBtn;

	@FindBy(xpath = ".//*[@class='lex ng-binding']")
	private WebElement Lexilescoreendtest;
	@FindBy(xpath = ".//a[contains(text(),'Logout')]")
	private WebElement logout;

	@FindBy(xpath = "//button[@class='btn btn-teal btn-circle ng-scope']")
	private WebElement CrossOnTab;

	@FindBy(xpath = ".//div[@class='litpro-quitTestDialogDiv row ng-scope']//strong")
	private WebElement CrossOnTabConformation;

	@FindBy(xpath = "//button[contains(text(),'Yes, quit')]")
	private WebElement YesquitBtn;
	@FindBy(xpath = "//button[contains(text(),'Skip')]")
	private WebElement Skipbutton;

	@FindBy(xpath = "//button[contains(text(),'Go On')]")
	private WebElement GoOnButton;

	public ResultsPg(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}


	

	public boolean LexileScore() {
		if (Lexilescoreendtest.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean NoLexileScore() {
		if (Lexilescoreendtest.isDisplayed()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean verifyDirectionValue(String value) {

		boolean flag = false;

		WebElement infoTextElement = this.getElement(By.xpath(".//*[@id='ng-app']/body/div[6]/div[2]"));
		this.reportLog(infoTextElement.getText());
		if (infoTextElement != null) {
			String infoTextString = infoTextElement.getText();
			this.reportLog("Info Text: " + infoTextString);
			if (infoTextString.contains(value)) {
				this.reportLog("Direction Page data  found ");
				flag = true;
			} else {
				this.reportLog("No direction page data not found");
				flag = false;
			}

		}
		return flag;
	}

	

	
	public void closePopup() {
		reportLog("Closing the test popup to interupt the test");
		CrossOnTab.click();
		try {
			if (CrossOnTabConformation.isDisplayed()) {
				reportLog(CrossOnTabConformation.getText());
				YesquitBtn.click();
				reportLog("Pressed button " + YesquitBtn.getText());
			}
		} catch (Exception e) {

		}
	}

	public boolean startPauseAssessment() {
		boolean flag = false;
		this.reportLog("Click 'Lets get started' button");
		this.click(letsGetStartedBtn);

		// check if there are any assessment left or left the earlier assessment
		// incomplete
		WebElement infoTextElement = this.getElement(By.xpath("//h2[@class='infotext']/strong"));
		if (infoTextElement != null) {
			this.lazyWait(5);
			String infoTextString = infoTextElement.getText();
			this.reportLog("Info Text: " + infoTextString);
			if (infoTextString.contains("You are resuming a test you started earlier")) {
				this.reportLog("Resumed the earlier test");
				this.click(this.goOndBtn);
				flag = true;
			}
		}

		return flag;
	}

	public void Handletestalert() {
		logout.click();
		reportLog("Logging out as a student");
		/*
		 * lazyWait(5); Alert alert = driver.switchTo().alert(); alert.accept();
		 * lazyWait(5);
		 */

		switchToNewWindow();
	}

	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}

	public boolean isTotalNoAssDisplayed() {
		this.sync(driver.findElement(By.xpath(".//*[@class='assessment-section']/div[3]//span[2]")));
		return driver.findElement(By.xpath(".//*[@class='assessment-section']/div[3]//span[2]")).getText().contains("Reattempted");
	}

	public boolean isAToNAssTakenMoreThanOnce() {
		this.sync(driver.findElement(By.xpath(".//*[@class='assessment-section']/div[2]//span[2]")));
		return driver.findElement(By.xpath(".//*[@class='assessment-section']/div[2]//span[2]")).getText().contains("Average Number of Assessments Taken");
		
		
	}

	public boolean isAvgScoreDisplayed() {
		this.sync(driver.findElement(By.xpath(".//*[@class='assessment-section']/div[1]//span[2]")));
		return driver.findElement(By.xpath(".//*[@class='assessment-section']/div[1]//span[2]")).getText().contains("Average Score");
		
	}
	public boolean isAssesmentScoreDateDisplayed() {
		boolean flag;
		this.sync(driver.findElement(By.xpath(".//table/thead/tr/th[1]")));
		flag= driver.findElement(By.xpath(".//table/thead/tr/th[1]")).getText().contains("Assessment");
		 flag= driver.findElement(By.xpath(".//table/thead/tr/th[2]")).getText().contains("Score");
		flag =driver.findElement(By.xpath(".//table/thead/tr/th[3]")).getText().contains("Date");
	return flag;
	
	}
	
	public void clickAssesmentLink(){
		lazyWait(5);
		this.sync(driver.findElement(By.xpath(".//tbody/tr[1]/td[1]/a/span"))).click();
	}
	public boolean issingleAssesmentResultdisplayed() {
		this.sync(driver.findElement(By.xpath(".//div/h2[contains(text(),'Attempt')]")));
		return driver.findElement(By.xpath(".//div/h2[contains(text(),'Attempt')]")).isDisplayed();
		
	}
	
}