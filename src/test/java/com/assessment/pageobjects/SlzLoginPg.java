package com.assessment.pageobjects;

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
import com.scholastic.torque.common.TestBase;
import com.scholastic.torque.common.TestBaseProvider;

public class SlzLoginPg extends ParentPage implements LoginPageLocators, hooksConstants {
	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	private String launchUrl = null;
	private String userName = "";
	private String password = "";
	TestBase testBase = TestBaseProvider.getTestBase();

	@FindBy(how = How.ID_OR_NAME, using = "username")
	private WebElement usernameTextBox;

	@FindBy(how = How.ID_OR_NAME, using = "password")
	private WebElement passwordTextBox;

	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	private WebElement login;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutLink;

	@FindBy(how = How.CSS, using = "p.warning")
	private WebElement loginError;

	@FindBy(xpath = LOGIN_UNAME_TEXTBOX_SDM)
	private WebElement loginunametextboxsdm;

	@FindBy(xpath = LOGIN_PWD_TEXTBOX_SDM)
	private WebElement loginpwdtextboxsdm;

	@FindBy(id = LOGIN_SIGNIN_BUTTON_SDM)
	private WebElement loginsigninbuttonsdm;

	@FindBy(xpath = ".//img[@alt='btn_lf']")
	private WebElement lpLink;

	@FindBy(xpath = "//a[contains(text(),'Scholastic Learning Zone')]")
	private WebElement SLZPassthoghLnk;

	@FindBy(xpath = "//*[contains(text(),'Loading')]")
	private WebElement LoadingImage;

	@FindBy(xpath = "//*[@id='quicksearchQuery']")
	private WebElement SearchTextBox;

	@FindBy(xpath = "//a[contains(text(),'breaking bad 6')]")
	private WebElement SchoolNameSLZ;

	@FindBy(xpath = "//button[@ng-click='quickSearch()']")
	private WebElement SearchButton;

	public SlzLoginPg(WebDriver driver) {
		super(driver);
		driver = TestBaseProvider.getTestBase().getDriver();
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	public String getURL() {
		return launchUrl;
	}

	public boolean launchSlz() {
		/*
		 * loadConf(); boolean areParamsPresent = ParentPage.appConfig
		 * .containsKey("app.url.base") && ParentPage.appConfig.containsKey("app.login")
		 * && ParentPage.appConfig.containsKey("org.id"); if (!areParamsPresent) { this.
		 * reportLog("[Error] AUT info required. Base URL, Login URL or Ord Id is not passed or empty"
		 * ); return false; } String baseUrl =
		 * ParentPage.appConfig.getProperty("app.url.base") .trim(); String loginUrl =
		 * ParentPage.appConfig.getProperty("app.login").trim(); String csRepLoginUrl =
		 * ParentPage.appConfig.getProperty( "app.csrep.login").trim();
		 * 
		 * String orgId = ParentPage.appConfig.getProperty("org.id").trim();
		 * 
		 * boolean isAppConfigProper = baseUrl.isEmpty() || loginUrl.isEmpty() ||
		 * csRepLoginUrl.isEmpty(); if (!isAppConfigProper) { launchUrl = baseUrl +
		 * loginUrl + orgId; this.reportLog("Launch Slz Login Page..");
		 * this.reportLog("URL: " + launchUrl);
		 * 
		 * if (launchUrl != null) { driver.get(launchUrl); //
		 * driver.navigate().refresh(); // logout if already logged in this.logout(); }
		 * 
		 * return true; } else { this.
		 * reportLog("[Error] AUT info required. Base URL, Login URL or Ord Id is not passed or empty"
		 * ); this.reportLog("Base URL: " + baseUrl); this.reportLog("Login URL: " +
		 * loginUrl); this.reportLog("Org Id: " + orgId); return false; }
		 */
		String launchUrl = testBase.getContext().getString(URL);
		if (launchUrl != null) {
			// driver.get(launchUrl);
			// driver.navigate().refresh();
			// logout if already logged in
			this.logout();
			return true;
		}
		return false;
	}

	public boolean launchSlzForCSRep() {
		boolean areParamsPresent = ParentPage.appConfig.containsKey("app.csrep.login");
		if (!areParamsPresent) {
			this.reportLog("[Error] AUT info required. Base URL, Login URL or Ord Id is not passed or empty");
			return false;
		}
		String baseUrl = ParentPage.appConfig.getProperty("app.url.base").trim();
		String csRepLoginUrl = ParentPage.appConfig.getProperty("app.csrep.login").trim();

		String orgId = ParentPage.appConfig.getProperty("org.id").trim();

		boolean isAppConfigProper = baseUrl.isEmpty() || orgId.isEmpty() || csRepLoginUrl.isEmpty();
		if (!isAppConfigProper) {
			launchUrl = baseUrl + csRepLoginUrl;
			this.reportLog("Launch Slz Login Page for CSRep..");
			this.reportLog("URL: " + launchUrl);

			if (launchUrl != null) {
				driver.get(launchUrl);
				// logout if already logged in
				this.logout();
			}

			return true;
		} else {
			this.reportLog("[Error] AUT info required. Base URL, Login URL or Ord Id is not passed or empty");
			this.reportLog("Base URL: " + baseUrl);
			return false;
		}
	}

	public void logout() {

		/*
		 * String xpath; String baseUrl =
		 * ParentPage.appConfig.getProperty("app.url.base") .trim();
		 * System.out.println(baseUrl); if ((baseUrl.contains("qa-slz2")) ||
		 * (baseUrl.contains("stress"))) { xpath = "slz-logout"; } else
		 */
		String xpath = "slz-logout";
		WebElement logoutElement = this.getElement(By.id(xpath), 5);
		if (logoutElement != null) {
			System.out.println(logoutElement.isDisplayed());
			this.reportLog("Logout from Slz Home");
			if (logoutElement.isDisplayed())
				logoutElement.click();
			driver.navigate().refresh();
		}
	}

	public SlzHomePg login(String username, String password) {
		this.userName = username;
		this.password = password;
		this.reportLog("Login to Scholastic Learning Zone(" + username + "/" + password + ")");
		/*
		 * this.type(usernameTextBox, username); this.type(passwordTextBox, password);
		 * passwordTextBox.submit();
		 */
		WebElement uidE = this.getElement(By.name("UserName"));
		WebElement passE = this.getElement(By.name("password"));
		WebElement btnSubmit = this.getElement(By.xpath(".//button[contains(text(),'Login')]"));

		this.type(uidE, userName);
		this.type(passE, password);
		btnSubmit.click();
		return new SlzHomePg(driver);
	}

	/*
	 * public SlzCSRHomePg loginAsCSRep() { this.userName =
	 * this.getUserId(LitProUserType.CS_REP); this.password = "welcome1";
	 * 
	 * WebElement uidE = this.getElement(By.id("email")); WebElement passE =
	 * this.getElement(By.id("password")); WebElement btnSubmit =
	 * this.getElement(By.id("submit-button"));
	 * 
	 * this.type(uidE, userName); this.type(passE, password); btnSubmit.click();
	 * 
	 * return new SlzCSRHomePg(driver); } /* /* private String getBrowserString(){
	 * switch(SharedDriver.ACTIVE_BROWSER){ case FIREFOX: return "fx"; case CHROME:
	 * return "cr"; case IE: return "ie"; default: return "fx"; }
	 */
	// }

	public String getLoginErrorText() {
		return loginError.getText();
	}

	public String getUserCreds() {
		if (!this.userName.isEmpty() || !this.password.isEmpty())
			return this.userName + "/" + this.password;
		else
			return "";
	}

	public void clickForgotPasswordLink() {
		this.sync(driver.findElement(By.xpath(".//a[@href='#forgotPassword']"))).click();
	}

	public void isErrorMessageDisplayed() {
		this.sync(driver.findElement(By.xpath("(.//h4)[1]"))).getText().contains("Having trouble signing in?");
	}

	@Override
	protected void openPage() {
		// TODO Auto-generated method stub

	}

	public String getSchoolname() {
		return SlzLoginPg.Schoolname;
	}

	public void setSchoolname(String Schoolname) {
		SlzLoginPg.Schoolname = Schoolname;
	}

	public static String Schoolname;
}