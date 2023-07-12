package mainJobStatusScreen;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Browser;

public class MainJobStatus1 extends Browser{
	
	@FindBy(xpath = "//input[@title='Username']")
	private WebElement username;
	@FindBy(xpath = "//input[@title='Password']")
	private WebElement pass;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//i[@class='nav-icon fa fa-forward']")
	private WebElement IFFBtn;
	@FindBy(xpath = "//span[text()='IFF Operations']")
	private WebElement IFFOperation;
	@FindBy(xpath = "//span[text()='Maintain Job Status']")
	private WebElement mainJobStatusBtn;

	public MainJobStatus1() {
		PageFactory.initElements(driver, this);
	}

	public void verifyLoginApp() throws Exception {
		username.sendKeys(readExcelFileFinal(4, 2));
		pass.sendKeys(readExcelFileFinal(4, 3));
		Thread.sleep(1000);
		loginBtn.click();

	}

	public void verifyIFFBtn() throws Exception {
		try {
			Thread.sleep(1000);
		IFFBtn.click();}
		catch(NoSuchElementException e) {
		}
	}

	public void verifyOperationBtn() throws Exception {
		Thread.sleep(500);
		IFFOperation.click();
	}
	public void verifMainJobStatusBtn() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-450)");
		Thread.sleep(1500);
		mainJobStatusBtn.click();
	}
}
