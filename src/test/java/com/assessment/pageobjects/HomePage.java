package com.assessment.pageobjects;

import java.util.NoSuchElementException;

import javax.enterprise.inject.Instance;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.json.simple.JSONArray;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.scholastic.torque.common.TestBaseProvider;

public class HomePage extends ParentPage {
	public HomePage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
		this.waitForPageLoad(DRIVER_WAIT);
	}

	WebDriver driver = TestBaseProvider.getTestBase().getDriver();
	final String PAGE_TITLE = "International Assessment";

	@FindBy(xpath = "//a[contains(text(),'All')]")
	private WebElement All_link;

	@FindBy(xpath = "//a[contains(text(),'Not Attempted')]")
	private WebElement Not_Attempted_link;

	@FindBy(xpath = "//a[contains(text(),'In Progress')]")
	private WebElement In_Progress_link;

	@FindBy(xpath = "//a[contains(text(),'Already Attempted')]")
	private WebElement Already_Attempted_link;

	@FindBy(xpath = "//img[@alt='My Assessments']")
	private WebElement My_Assessment_left_panel_tab;

	@FindBy(xpath = "//img[@alt='logo']")
	private WebElement Assessment_logo;

	@FindBy(xpath = "//a[contains(text(),'Load More')]")
	private WebElement Load_More;

	@FindBy(xpath = "//li[contains(text(),'Welcome,')]")
	private WebElement greetText;

	@FindBy(xpath = "//span[contains(text(),'Assessments')]]")
	private WebElement assessmenttab;
	@FindBy(xpath = "//a[span[contains(text(),'Reports')]]")
	private WebElement reportstab;
	@FindBy(xpath = "//a[@href='/logout']")
	private WebElement logOutLink;
	@FindBy(xpath = "//a[@title='Need Help?']")
	private WebElement needhelp;
	@FindBy(xpath = "//*[@id='single-button']")
	private WebElement selectbutton;
	@FindBy(xpath = "//i[@class='fa fa-check pull-right icon-check cursor-pointer ng-scope']")
	private WebElement deafult;
	@FindBy(xpath = "//a[@href='#!/assessmentDetails/187']")
	private WebElement assessment;
	@FindBy(xpath = "//div[@class='btn-group ng-scope dropdown']//button")
	private WebElement selectclassdropdown;
	@FindBy(xpath = "//a[text()='Assign to all instead?']")
	private WebElement selectalllink;
	// @FindBy(xpath = "//button[@class='btn btn-primary']")
	@FindBy(xpath = "//button[contains(text(),'Assign')]")
	private WebElement assignbutton;
	@FindBy(xpath = "//div[@class='modal-content']")
	private WebElement successfullytext;
	@FindBy(xpath = "//i[@class='fa fa-times pull-right cursor-pointer']")
	private WebElement closebutton;
	@FindBy(xpath = "//a[text()='Privacy Policy']")
	private WebElement privacypolicylink;
	@FindBy(xpath = "//span[@class='ng-scope']")
	private WebElement start;
	@FindBy(xpath = "//i[@class='fa fa-star pull-right icon-check ng-scope']")
	private WebElement star;

	@FindBy(xpath = "//h2[contains(.,'My Assessments')]")
	private WebElement stuHomePage;

	@FindBy(xpath = "//button[contains(.,'Next')]")
	private WebElement Nextbtn;

	@FindBy(xpath = "//a[contains(.,' Results')]")
	private WebElement stuResultsPage;

	@FindBy(xpath = "//h2[contains(.,'My Result')]")
	private WebElement stuMyResultPage;

	@FindBy(xpath = "//a[@ui-sref='student.assessments']/img")
	private WebElement stuLogo;

	// @FindBy(xpath="//*[@id='learnosity_assess']//span[contains(text(),'Finish')]")
	@FindBy(xpath = "//button[contains(.,'Finish')]")
	private WebElement Finishbtn;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	private WebElement submitOKBtn;

	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement assessmentClose;

	@FindBy(xpath = "//a[contains(.,' Results')]")
	private WebElement trueradiobtn;

	public String getUserGreetingText() {
		String userfirstname = null;
		String text;
		userfirstname = this.greetText.getText();
		text = ("Home Page Greeting text: " + userfirstname);
		System.out.println(text);
		return text;
	}

	public boolean verifyStudentAssessmentPage() {
		lazyWait(5);
		try {
			this.sync(stuHomePage).getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean verifyStudentResultPage() {
		try {
			this.stuMyResultPage.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean verifyAssessmentDisplayed() {
		try {
			this.AssessmentName.getTagName();
			reportLog("Student is able to find assigned assessment " + AssessmentName.getText());
			return true;
		} catch (NoSuchElementException e) {
			reportLog("Studnet is not able to find assigned assessment");
			return false;
		}
	}

	public boolean verifyNextButton() {
		try {
			this.Nextbtn.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean Load_more_text() {

		try {
			this.Load_More.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean Assessment_logo_img() {
		try {
			this.Assessment_logo.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean My_Assessment_left_panel_tab_verify() {
		try {
			this.My_Assessment_left_panel_tab.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean Already_Attempted_link_header() {
		try {
			this.Already_Attempted_link.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean In_Progress_link_header() {
		try {
			this.In_Progress_link.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean Not_Attempted_link_header() {
		try {
			this.Not_Attempted_link.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean All_link_header() {
		try {
			this.All_link.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void clickAssesmentButton() {
		this.sync(assessmenttab).click();
	}

	public void clickReportstButton() {
		this.sync(reportstab).click();

	}

	public void clickLogoutButton() {
		this.sync(logOutLink).click();
	}

	public void clickneedhelpbutton() {
		this.sync(needhelp).click();
	}

	public boolean isLogoutDisplayed() {
		return this.sync(logOutLink).isDisplayed();
	}

	public void clickdropdown() {
		this.sync(selectbutton).click();
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

	public void clickGradedropdown() {
		this.sync(deafult).click();

	}

	public void clickassessment() {

		this.sync(assessment).click();
	}

	public void selectassessment() throws InterruptedException {
		/*
		 * List<WebElement> Assign = driver.findElements(By
		 * .xpath("//a[text()='Assign']"));
		 */

		List<WebElement> Assign = driver.findElements(By.xpath("//a[text()='Assign']"));

		Assign.get(0).click();
	}

	public void selectclasss() {

		this.sync(selectclassdropdown).click();

	}

	public void selectdropdown2(String option) throws InterruptedException {

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

	public void selectcheckbox() throws InterruptedException {
		List<WebElement> list = driver.findElements(By.xpath(".//*[@id='checkbox0']"));
		Thread.sleep(3000);
		Boolean is_selected = list.get(0).isSelected();
		if (is_selected == true) {
			Thread.sleep(3000);
			list.get(1).click();
		} else {

			list.get(0).click();
			{

			}

		}

	}

	public void alllinks() {
		this.sync(selectalllink).click();
	}

	public void assignbutton() {
		this.sync(assignbutton).click();

	}

	public String getsuccessfullymessageText() {
		String Successfullmessage = null;
		String text;
		Successfullmessage = this.successfullytext.getText();
		text = ("sucessfulltext: " + Successfullmessage);
		System.out.println(text);
		return text;
	}

	public void closebutton() {
		this.sync(closebutton).click();
	}

	public void privacypolicy() {
		this.sync(privacypolicylink).click();

	}

	public void privacypolicyswitch() {
		this.switchToNewWindow();

	}

	public void start() {
		this.sync(start).click();

	}

	public void starbutton() {
		this.sync(star).click();
	}

	public void Clickdeafult() {
		this.sync(deafult).click();
	}

	public void selectdropdown8() throws InterruptedException {
		String[] grade = { "Grade 1", "Grade12", "Grade 2", "Grade 3", "Grade 4", "Grade 5", "Grade 6", "Grade 10",
				"Grade1A", "Grade1b", "Grade1c", "Grade@#$%$", "GradeABC", "Grade_1", "Grade_A", "Year 1", "Year 2",
				"Year 3" };

		driver.findElement(By.className("dropdown-menu")).click();
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));
		System.out.println(options);
		Thread.sleep(3000);
		for (WebElement we : options) {
			for (int i = 0; i < grade.length; i++) {
				if (we.getText().equals(grade[i])) {
					System.out.println("Matched");

				}
			}
		}
	}

	public void selectdropdown9() {
		String init[] = { "Grade 1", "Grade12", "Grade 2", "Grade 3", "Grade 4", "Grade 5", "Grade 6", "Grade 10",
				"Grade1A", "Grade1b", "Grade1c", "Grade@#$%$", "GradeABC", "Grade_1", "Grade_A", "Year 1", "Year 2",
				"Year 3" };

		List list = new ArrayList(Arrays.asList(init));

		System.out.println("List value before: " + list);

		Collections.sort(list);

		System.out.println("List value after sort: " + list);
	}

	/*---------------------------------------------------------------------------------------------------------------------------*/
	public void ClickGrade(String Grade) {

		String xpath = "//ul/li/a[contains(text(),'" + Grade + "')]";
		driver.findElement(By.xpath(xpath)).click();
		reportLog("Selected grade " + Grade + " from the dropdown");
	}

	public boolean AssessmentOfNumber(int AssessNum) {
		lazyWait(2);
		boolean result = false;
		int count = driver.findElements(By.xpath("//section/div//assessment-card")).size();
		try {
			if (LoadMore.isDisplayed())
				result = true;

		} catch (Exception e) {
			result = false;
		}

		if (result) {
			if (count == AssessNum) {
				reportLog("The number of Assessment shown in a page --> " + count);
				result = true;
			}
			if (count < AssessNum) {
				reportLog("The MAX number of Assessment shown in the page is MORE then " + AssessNum);
				result = true;
			}
			if (count > AssessNum) {
				reportLog("The MAX number of Assessment shown in the page is LESS then " + AssessNum);
			}
		}
		return true;
	}

	public boolean NumberofAssessLoadMore(int AssessNum) {
		boolean result = false;
		reportLog("Number of assessment after clicking on load more button");
		for (int i = 2; i < 30; i++) {
			try {
				if (LoadMore.isDisplayed()) {
					LoadMore.click();
					reportLog("Clicked on Load more button");
					lazyWait(3);
					int count = driver.findElements(By.xpath("//section/div//assessment-card")).size();
					if (count == AssessNum * i) {
						reportLog("The number of Assessment shown in a page --> " + count);
						result = true;
					}
					if (count < AssessNum * i) {
						reportLog("The MAX number of Assessment shown in the page is LESS then : Expected :"
								+ AssessNum * i + " Actual " + count);
						result = true;
					}
					if (count > AssessNum * i) {
						reportLog("The MAX number of Assessment shown in the page is MORE then  : Expected :"
								+ AssessNum * i + " Actual " + count);
						result = false;
					}
				}
			} catch (Exception e) {
				reportLog("No more Load more button are avaible");
				break;
			}
		}
		return true;
	}

	public boolean NumberofAssessRow(int AssessNum) {
		lazyWait(2);
		boolean result = false;
		int count = driver.findElements(By.xpath("//section[1]/div//assessment-card")).size();

		if (count == AssessNum) {
			reportLog("The number of Assessment shown in a Row is correct --> " + count);
			result = true;
		}
		if (count < AssessNum) {
			reportLog("Please selecte a different class which has more then 3 assessments --> Actual assessement "
					+ count);
		}
		if (count > AssessNum) {
			reportLog("Number of Assessments in a Row is more then expected " + count);
		}
		return result;
	}

	public boolean LoadMoreBtn(String btnTxt) {
		String Xpath = "//a[contains(text(),'" + btnTxt + "')]";
		return (driver.findElements(By.xpath(Xpath)).size() == 0) ? false : true;
	}

	public boolean TitleofAssess() {
		boolean result = false;
		int i = driver.findElements(By.xpath("//assessment-card/h1/a")).size();
		int j = driver.findElements(By.xpath("//assessment-card")).size();
		reportLog("Number of Assessment " + j);
		reportLog("Number of Assessment with titles " + i);
		if (i == j) {
			result = true;
		}
		return result;
	}

	public boolean QuesofAssess() {
		boolean result = false;
		int i = driver.findElements(By.xpath("//assessment-card/h3")).size();
		int j = driver.findElements(By.xpath("//assessment-card")).size();
		reportLog("Number of Assessment " + j);
		reportLog("Number of Assessment with Questions " + i);
		if (i == j) {
			result = true;
		}
		return result;
	}

	public void clickTopLft(String Attempts) {
		String xapths = null;
		if (Attempts.equals("Not Attempted")) {
			xapths = "//ul/li[2]/a[contains(text(),'" + Attempts + "')]";
		}
		if (Attempts.equals("In Progress")) {
			xapths = "//ul/li[3]/a[contains(text(),'" + Attempts + "')]";
		}
		driver.findElement(By.xpath(xapths)).click();
		lazyWait(5);
	}

	public boolean ProgressBar() {
		boolean result = false;
		int i = driver.findElements(By.xpath("//assessment-card/h3")).size();
		int j = driver.findElements(By.xpath("//assessment-card/div[@class='progress']")).size();
		reportLog("Number of Assessment " + j);
		reportLog("Number of Assessment with progress bar " + i);
		if (i == j) {
			result = true;
		}
		return result;
	}

	public boolean ProgressBarZeroPer() {
		boolean result = false;
		reportLog("I should validate the progress bar");
		try {
			driver.findElement(By.xpath("//section[1]/div[1]//assessment-card//div[@class='progress-bar not-started']"))
					.isDisplayed();
			driver.findElement(By.xpath("//section[1]/div[1]//assessment-card//a/span[contains(text(),'Start')]"))
					.isDisplayed();
			result = true;
		} catch (NoSuchElementException ignored) {
			result = false;
		}
		String title = Assesstitle1.getText();
		AssessTitle(title);
		return result;
	}

	public void clickOnReports() {
		reportLog("Student Clicked on assessment name");
		stuResultsPage.click();
		lazyWait(3);
	}

	public void clickStudentLogo() {
		reportLog("Student Clicked on Logo image");
		stuLogo.click();
		lazyWait(3);
	}

	public void clickOnAssessmentName() {
		reportLog("Student Clicked on assessment name");
		lazyWait(4);
		if (isLoadmoreDisplayed()) {
			LoadMore.click();
		}
		lazyWait(4);
		AssessmentName.click();
		lazyWait(10);

	}

	public void ClickOnStrtBtn() {
		reportLog("Student Clicked on Start assessment button");
		// StartBtn.click();
		try {//
			lazyWait(5);
			startAssessmentBtn.click();
		} catch (Exception e) {

		}
		lazyWait(3);
		reportLog("Assessment started by student");
		lazyWait(5);
	}

	public void submitAssessment() {
		int radio = driver.findElements(By.xpath("(//*[contains(text(),'True')])")).size();
		System.out.println("Number of radio button are" + radio);
		for (int i = 1; i <= radio; i++) {
			String trueRbXpath = "(//*[contains(text(),'True')])";
			lazyWait(3);
			driver.findElement(By.xpath(trueRbXpath + "[" + i + "]")).click();
			lazyWait(3);
			if (i != radio) {
				System.out.println("Clicking on Next button");
				Nextbtn.click();
			} else {
				System.out.println("Clicking on Finish Else block");
				lazyWait(5);
				Finishbtn.click();
			}

		}
		// System.out.println("Clicking on Finish inside loop");
		lazyWait(5);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submitOKBtn);
		reportLog("Studnet Clicked on assessment submit button");
		lazyWait(5);
		assessmentClose.click();
		reportLog("Studnet closes assessment window");

	}

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public String AssessPopupMess(String Message) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='start-page-description']/div/p")));
		String Expected = PopMessage.getText();
		return Expected;
	}

	public void StartBtnPopup() {
		StrtBtnPop.click();
		reportLog("Clicked on the Start button of the Pop up message");
	}

	public void QuitAssement() {
		reportLog("Quitting the assessment");
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//*[@id='learnosity_assess']//button[@data-original-title='Quit']")));
		lazyWait(4);
		QuitAssessment.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='test-save-submit']//button[2]")));
		lazyWait(4);
		QuitButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='myModal']//button[1]")));
		lazyWait(4);
		driver.findElement(By.xpath(".//*[@id='myModal']//button[1]")).click();
		reportLog("Quited the assessment");
	}

	public boolean ProgressFifty() throws InterruptedException {

		boolean result = false;
		reportLog("I am validating the progress bar");
		int row = driver.findElements(By.xpath("//section[1]/div//assessment-card/h1/a")).size();
		int column = driver.findElements(By.xpath("//section/div[1]/div/assessment-card/h1/a")).size();
		for (int j = 0; j <= row; j++) {
			for (int i = 0; i <= column; i++) {
				String xpath = "//section[" + j + "]/div[" + i + "]/div/assessment-card";
				String Title = driver.findElement(By.xpath(xpath + "/h1/a")).getText();
				if (Title.equalsIgnoreCase(getAssessTitle())) {
					System.out.println(driver.findElement(By.xpath(xpath + "/a/span")).getText());
					driver.findElement(By.xpath(xpath + "/a/span")).click();
					result = true;
				}
			}
		}
		return result;
	}

	public void UnAssign() {
		if (AssignedStatus.getText().contains("Assigned")) {
			reportLog("Assessemnt is already assigned we are unassigning it");
			AssignedStatus.click();
			selectclassdropdown.click();
			SelectClass.click();
			lazyWait(4);
			int i = driver.findElements(By.xpath("//input[@checked='checked']")).size();
			System.out.println("Number of students-->" + i);
			reportLog("Un assinging the assessments from students");
			for (int j = 1; j <= i; j++) {
				String xpaths = "//div[@ng-repeat='student in assign.students'][" + j + "]//label";
				driver.findElement(By.xpath(xpaths)).click();
			}
			AssginBtn.click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[@class='modal-header border-none']/i")));
			Closepop.click();
			reportLog("Assessemnt unassigned is completed");
		} else {
			reportLog("This Assessemnt is already Unassigned");
		}

	}

	@FindBy(xpath = "//div[@class='modal-header border-none']/i")
	private WebElement Closepop;

	@FindBy(xpath = "//button[contains(text(),'Assign')]")
	private WebElement AssginBtn;

	@FindBy(xpath = ".//*[@id='modal-body']//li[5]/a")
	private WebElement SelectClass;

	// @FindBy(xpath = "//section/div//assessment-card/a")
	@FindBy(xpath = "(//section/div//assessment-card/a)[1]")
	private WebElement AssignedStatus;

	@FindBy(xpath = "//section[1]/div[1]//assessment-card//h1")
	private WebElement Assesstitle1;

	@FindBy(css = ".lrn_btn_blue.test-dialog-quit")
	private WebElement QuitButton;

	@FindBy(xpath = ".//*[@id='learnosity_assess']//button[@data-original-title='Quit']")
	private WebElement QuitAssessment;

	@FindBy(xpath = ".//*[@id='learnosity_assess']//button[contains(text(),'Start')]")
	private WebElement StrtBtnPop;

	@FindBy(xpath = ".//*[@id='start-page-description']/div/p")
	private WebElement PopMessage;

	@FindBy(css = ".lrn_btn_blue.btn-lg.start-test-btn")
	private WebElement StartBtn;

	@FindBy(xpath = "//assessment-card/h1/a[contains(text(),' Topic 12.1: Chance')]")
	private WebElement AssessmentName;

	@FindBy(xpath = ".//section[1]/div[1]/div/assessment-card/a")
	private WebElement startAssessmentBtn;

	@FindBy(xpath = "//assessment-card/div[2]//span[@ng-switch-when='1']")
	private WebElement ZeroPretage;

	@FindBy(xpath = "//assessment-card/div[@class='progress']")
	private WebElement progressbar;

	@FindBy(xpath = "//assessment-card/h1/a")
	private WebElement AsseTitle;

	@FindBy(xpath = "//a[contains(text(),'Load More')]")
	private WebElement LoadMore;

	public void OpenAssessment(String Assessment) {
		lazyWait(4);
		while (isLoadmoreDisplayed()) {
			LoadMore.click();
		}
		System.out.println("Before Clicking");
		String Xpath = "//assessment-card/h1/a[contains(text(),'" + Assessment + "')]";
		System.out.println(Xpath);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
		lazyWait(4);

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", driver.findElement(By.xpath(Xpath)));
		Assessment = Assessment.replace(":", "");
		System.out.println(Assessment);
		setJSON_FILE_PATH(Assessment);
		// click(driver.findElement(By.xpath(Xpath)));
		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//*[@class='lrn-dialog-footer']/button[contains(text(),'Start')]")));
			JavascriptExecutor executor2 = (JavascriptExecutor) driver;
			executor2.executeScript("arguments[0].click();", StartBtn);
			StartBtn.click();
		} catch (Exception e) {
			System.out.println("Its already taken assesment");
		}
	}

	/*
	 * public HashMap<String, String> CompleteAssessment(String Questions,
	 * String Type){ HashMap<Integer, String> util = new HashMap<Integer,
	 * String>(); util.put(Question, Type); DragDrop(); }
	 */
	public void CompleteAssessment() {
		lazyWait(10);
		String type = null;
		boolean flag = false;
		int noOfQuestions;
		while (!flag) {
			boolean previous = this.sync(driver.findElement(By.xpath(".//*[@title='Previous']"))).isEnabled();
			System.out.println(previous);
			if (previous) {
				driver.findElement(By.xpath(".//*[@title='Previous']")).click();
			} else {
				flag = true;
			}
		}
		noOfQuestions = getJsonLength();
		System.out.println(noOfQuestions);
		for (int i = 0; i < noOfQuestions; i++) {
			int j = i + 1;
			// driver.navigate().refresh();
			// this.sync(driver.findElement(By.xpath("(.//*[@class='lrn_question'])[1]/div/div/p[1]")));
			String que1 = getquestion(j);
			String que = driver.findElement(By.xpath(que1)).getText();
			String qid = driver.findElement(By.xpath("(.//*[@class='lrn_question']/..)[" + j + "]")).getAttribute("id");
			System.out.println(qid);
			String[] lastqid = qid.split("_");
			System.out.println(lastqid[1]);
			System.out.println("question" + que);
			que = lastqid[1];
			System.out.println("jjj" + que);
			type = readDataFromJson(que, "type");
			String[] noOfTypeofQue = type.split("_");
			for (int k = 0; k < noOfTypeofQue.length; k++) {
				System.out.println(noOfTypeofQue[k]);
				Answerthequestion(que, noOfTypeofQue[k]);
			}
			System.out.println(isQuizOver());
			if (i <= noOfQuestions) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@title='Next']")));
				System.out.println("clicking next");
				lazyWait(5);
			}
		}
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@title='Finish']")));
		lazyWait(4);
		completeAssesment();
	}

	private void completeAssesment() {
		lazyWait(4);
		this.sync(driver.findElement(By.xpath(".//button[starts-with(@class,'test-dialog-save-submit')]"))).click();
		lazyWait(4);
		this.sync(driver.findElement(By.xpath(".//button[contains(text(),'Close')]"))).click();
	}

	private String getquestion(int j) {
		String xpath;
		boolean flag;
		try {
			(new WebDriverWait(driver, 3)).until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(.//*[@class='lrn_question'])[" + j + "]/p[1]")));
			flag = false;
		} catch (Exception e) {
			flag = true;
		}
		if (flag)
			return "(.//*[@class='lrn_question'])[" + j + "]";
		else
			return "(.//*[@class='lrn_question'])[" + j + "]/p[1]";

	}

	private void Answerthequestion(String que, String type) {
		int k = 0;
		int n = 0;
		System.out.println(type);
		System.out.println(que);
		if (type.equals("Checkbox"))
			k = 1;
		else
			k = 2;

		System.out.println(k);

		if (type.equals("Checkbox")) {
			String x = readDataFromJson(que, "xpath");
			boolean f = clickcheckbox(x);
		}
		if (type.equals("Drag and drop")) {
			JSONArray y = readDataFromJsonasArray(que, "DropDownArray");
			for (int m = 0; m <= y.size() / 2; m=m+2) {
				n = m + 1;
				System.out.println(y.get(m).toString());
				System.out.println(m);
				System.out.println(n);
				dragDrop(y.get(m).toString(), y.get(n).toString());
				
			}
		}

			if (type.equals("Dropdown"))
				selectfroDropDown(readDataFromJson(que, "Number"), que);
			if (type.equals("Editbox"))
				SendkeysEditbox(readDataFromJson(que, "xpath"), que);

		
	}

	private void SendkeysEditbox(String xpath, String que) {
		String val =readDataFromJson(que, "value");
		this.sync(driver.findElement(By.xpath(xpath))).sendKeys(val);
	}

	private void selectfroDropDown(String string, String que) {
		int no = Integer.parseInt(string);
		for (int i = 1; i <= no; i++) {
			WebElement src = this.sync(driver.findElement(By.xpath(readDataFromJson(que, "Dropdown" + i))));
			Select dropdown = new Select(src);
			dropdown.selectByIndex(1);
		}

	}

	private boolean dragDrop(String srcpath, String destpath) {
		// int no = Integer.parseInt(string);
		lazyWait(3);
		// for (int i = 1; i <= no; i++) {
		// String xpath=DragFrom
		WebElement src = (driver.findElement(By.xpath(srcpath)));
		WebElement dest = (driver.findElement(By.xpath(destpath)));
		DragDrop(src, dest);
		// }
		return true;

	}

	private boolean clickcheckbox(String xpath) {
		System.out.println("inside chkbox");
		// this.click(driver.findElement(By.xpath(xpath)));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
		return true;

	}

	public void DragDrop(WebElement From, WebElement To) {
		(new Actions(driver)).dragAndDrop(From, To).perform();
		lazyWait(3);
	     From.click();
	}

	private boolean isQuizOver() {
		try {

			Thread.sleep(3000);
			if (driver.findElement(By.xpath(".//*[@title='Finish']")).isDisplayed())
				return true;
		} catch (Exception e) {
		}
		return false;
	}

	public void isDescriptionDisplayed() {
		// TODO Auto-generated method stub

	}

	public boolean isNoOfquestionsDisplayed() {
		lazyWait(15);
		this.sync(driver.findElement(By.xpath(".//*[@class='lrn-pager']/ul/li")));
		return driver.findElement(By.xpath(".//*[@class='lrn-pager']/ul/li")).isDisplayed();
	}

	public void clickResultsbutton() {
		lazyWait(10);
		this.sync(driver.findElement(By.xpath("//a[span[contains(text(),'Results')]]")));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath(".//a[span[contains(text(),'Results')]]")));
		executor.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//a[span[contains(text(),'Results')]]")));
		// driver.findElement(By.xpath(".//*[@class='main-navigation']//li[2]/a")).sendKeys(Keys.ENTER);
		lazyWait(10);
	}

	public boolean isLoadmoreDisplayed() {
		boolean result = false;
		try {
			if (LoadMore.isDisplayed())
				result = true;

		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public void clickOnAnyOtherPlace() {
		lazyWait(5);
    this.sync(driver.findElement(By.xpath(".//*[@class='assessments']"))).click();
	}

	public boolean isPopUpDisplayed() {
      return  this.sync(driver.findElement(By.xpath(".//*[@id='myModal']/div/div/h2"))).isDisplayed();
	}

	public void ClosePopUp() {
       this.sync(driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div/button[2]"))).click();
	}

	public boolean IsAssingmentContinued() {
      return this.sync(driver.findElement(By.xpath(".//*[@class='timer']"))).isDisplayed();
	}

}