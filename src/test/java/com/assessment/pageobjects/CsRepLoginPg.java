package com.assessment.pageobjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.assessment.keys.Keys.LoginPageLocators;
import com.assessment.keys.Keys.hooksConstants;
import com.scholastic.torque.common.TestBaseProvider;

public class CsRepLoginPg extends ParentPage {

	@FindBy(xpath = "//input[@name='email']")
	private WebElement csrepemail;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement csreppassword;

	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	private WebElement csrepLoginBtn;

	@FindBy(xpath = ".//*[@id='quicksearchQuery']")
	private WebElement searchOrgtxtbox;

	@FindBy(xpath = "//button[@ng-click='quickSearch()']/span")
	private WebElement searchOrgIcon;

	@FindBy(xpath = "//a[contains(text(),'Scholastic Learning Zone')]")
	private WebElement slzlink;

	WebDriver driver = TestBaseProvider.getTestBase().getDriver();

	public CsRepLoginPg(WebDriver driver) {
		super(driver);
		driver = TestBaseProvider.getTestBase().getDriver();
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	public void login(String username, String password, String csrepurl) {

		driver.navigate().to(csrepurl);
		csrepemail.clear();
		csrepemail.sendKeys(username);
		csreppassword.clear();
		csreppassword.sendKeys(password);
		lazyWait(2);
		try {
			csrepLoginBtn.click();
			System.out.println("==============Clicked on Login1");
			lazyWait(2);

		} catch (NoSuchElementException e) {
			e.printStackTrace();

		}

	}

	public void searchOrg(String OrgID) {
		searchOrgtxtbox.sendKeys(OrgID);
		searchOrgIcon.click();
		lazyWait(4);
	}

	public void clickOrganizationName(String orgName) {
		driver.findElement(
				By.xpath(".//*[@id='quick-search']/div[2]/section/table[1]/tbody/tr/td[2]/a[contains(text(),'" + orgName
						+ "')]"))
				.click();
		lazyWait(2);

	}

	public void clickScholasticLearningZone() {
		slzlink.click();
		lazyWait(2);
		this.switchToNewWindow();
	}

}
