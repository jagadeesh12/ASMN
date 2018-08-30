
package com.assessment.pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
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

public class FooterPageObject extends ParentPage {

	public FooterPageObject(WebDriver driver) {

		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	final String PAGE_TITLE = "International Assessment";
	@FindBy(xpath = "//a[text()='Privacy Policy']")
	private WebElement privacypolicylink;
	@FindBy(xpath = ".//*[@id='pageContainer1']/xhtml:div[2]/xhtml:div[1]")
	private WebElement scholastictext;

	public boolean Isprivacypolicy() {
		this.sync(privacypolicylink).click();
		return false;

	}

	public String getscholasticText() {
		String scholastic1 = null;
		String text;
		scholastic1 = this.scholastictext.getText();
		text = ("Default text: " + scholastic1);
		System.out.println(text);
		return text;
	}

	public void verify_privacy_link_URL() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String expected = "http://www.scholasticlearningzone.com/docs/Scholastic_Learning_Zone_Privacy_Policy.pdf";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
	}

}
