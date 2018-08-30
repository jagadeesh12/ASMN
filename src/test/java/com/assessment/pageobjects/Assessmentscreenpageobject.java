package com.assessment.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.scholastic.torque.common.TestBaseProvider;

public class Assessmentscreenpageobject extends ParentPage {

	public Assessmentscreenpageobject(WebDriver driver) {

		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	final String PAGE_TITLE = "International Assessment";

	@FindBy(xpath = "//assessment-card/a/span[contains(text(),'Start')]")
	private WebElement StartButton;
	@FindBy(xpath = "//*[@id='start-page-description']/div/p")
	private WebElement Startpopmessage;
	@FindBy(xpath = "//div[@class='timer']")
	private WebElement Timer;
	@FindBy(xpath = ".//*[@id='learnosity_assess']/div/div[2]/div[3]/div/div[1]/div/span[2]")
	private WebElement Elaspedtime;
	@FindBy(xpath = ".//*[@id='learnosity_assess']/div/div[2]/div[3]/div/button")
	private WebElement pasuebutton;
	@FindBy(xpath = ".//*[@id='test-pause-dialog']/div/div/div[3]/button")
	private WebElement continuebutton;
	@FindBy(xpath = ".//*[@id='test-pause-dialog']/div/div")
	private WebElement popupactivity;

	public void click_on_start_button() {
		StartButton.click();
	}

	// WebDriverWait wait = new WebDriverWait(driver, 3000);
	public String verifystartpopup(String popupmessage) {
		WebElement e = driver.findElement(By.id("//*[@id='start-page-description']/div/p"));
		System.out.println("getText() " + e.getText());
		String Expected = e.getText();
		return Expected;

	}//

	public boolean clickontimer() {
		boolean result = false;
		if (Elaspedtime.isDisplayed()) {
			result = true;
		}
		return result;
	}

	// WebDriverWait wait = new WebDriverWait(driver, 3000);
	// public boolean clickonpause(){
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='learnosity_assess']/div/div[2]/div[3]/div/button")));
	// boolean result=false;
	// if(pasuebutton.isEnabled()){
	// pasuebutton.click();
	// result=true;

	// return result;
	//

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public boolean verifytimerelapsedtime() {
		WebElement strvalue = driver
				.findElement(By.xpath(".//*[@id='learnosity_assess']/div/div[2]/div[3]/div/div[1]/div/span[3]"));
		String strng = strvalue.getText();
		System.out.println(strng);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//*[@id='learnosity_assess']/div/div[2]/div[3]/div/button")));
		boolean result = false;
		if (pasuebutton.isEnabled()) {
			pasuebutton.click();
			result = true;
			WebElement string1 = driver
					.findElement(By.xpath(".//*[@id='learnosity_assess']/div/div[2]/div[3]/div/div[1]/div/span[3]"));
			String string2 = string1.getText();
			System.out.println(string2);
			if (strng.equals(string2))
				System.out.println("strng and string2 are equal");
			else
				System.out.println("strng and string2 are not equal");
		}

		return result;
	}

	public boolean activitypopup() {
		boolean result = false;
		if (popupactivity.isDisplayed()) {
			return result = true;
		}
		return result;
	}

	public void continuebuttton() {
		this.sync(continuebutton).click();

	}

	public void Quit() throws InterruptedException {

		WebElement quitlogo = driver
				.findElement(By.xpath(".//*[@id='learnosity_assess']/div/div[3]/div[2]/div/button[1]"));
		Actions ToolTip1 = new Actions(driver);
		ToolTip1.moveToElement(quitlogo).clickAndHold(quitlogo).perform();
		Thread.sleep(3000);
		ToolTip1.clickAndHold(quitlogo).perform();
		String ToolTipText = quitlogo.getAttribute("data-original-title");
		Assert.assertEquals(ToolTipText, "Quit");

		Thread.sleep(2000);
		System.out.println("Tooltip value is: " + ToolTipText);

	}

	public void fullscreen() throws InterruptedException {
		WebElement fullscreenicon = driver
				.findElement(By.xpath(".//*[@id='learnosity_assess']/div/div[3]/div[2]/div/button[2]"));
		Actions ToolTip1 = new Actions(driver);
		ToolTip1.moveToElement(fullscreenicon).clickAndHold(fullscreenicon).perform();
		Thread.sleep(3000);
		ToolTip1.clickAndHold(fullscreenicon).perform();
		String ToolTipText = fullscreenicon.getAttribute("data-original-title");

		// Assert.assertEquals(ToolTipText, "Quit");
		System.out.println("Tooltip value is: " + ToolTipText);

	}

	public void accessbility() throws InterruptedException {
		WebElement fullscreenicon = driver
				.findElement(By.xpath(".//*[@id='learnosity_assess']/div/div[3]/div[2]/div/button[3]"));
		Actions ToolTip1 = new Actions(driver);
		ToolTip1.moveToElement(fullscreenicon).clickAndHold(fullscreenicon).perform();
		Thread.sleep(3000);
		ToolTip1.clickAndHold(fullscreenicon).perform();
		String ToolTipText = fullscreenicon.getAttribute("data-original-title");
		// Assert.assertEquals(ToolTipText, "Quit");

		System.out.println("Tooltip value is: " + ToolTipText);
	}

	public void calculator() throws InterruptedException {
		WebElement fullscreenicon = driver
				.findElement(By.xpath(".//*[@id='learnosity_assess']/div/div[3]/div[2]/div/button[4]"));
		Actions ToolTip1 = new Actions(driver);
		ToolTip1.moveToElement(fullscreenicon).clickAndHold(fullscreenicon).perform();
		Thread.sleep(3000);
		ToolTip1.clickAndHold(fullscreenicon).perform();
		String ToolTipText = fullscreenicon.getAttribute("data-original-title");
		// Assert.assertEquals(ToolTipText, "Quit");

		System.out.println("Tooltip value is: " + ToolTipText);

	}

	public void flagitem() throws InterruptedException {
		WebElement fullscreenicon = driver
				.findElement(By.xpath(".//*[@id='learnosity_assess']/div/div[3]/div[2]/div/button[5]"));
		Actions ToolTip1 = new Actions(driver);
		ToolTip1.moveToElement(fullscreenicon).clickAndHold(fullscreenicon).perform();
		Thread.sleep(3000);
		ToolTip1.clickAndHold(fullscreenicon).perform();
		String ToolTipText = fullscreenicon.getAttribute("data-original-title");
		// Assert.assertEquals(ToolTipText, "Quit");

		System.out.println("Tooltip value is: " + ToolTipText);

	}

}
