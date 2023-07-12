package mainJobStatusScreen;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Base.Browser;

public class MainJobStatus2 extends Browser{
	@FindBy(xpath=" //input[@id='ctl00_ContentPlaceHolder1_ImgJobNo']")private WebElement jobNoD;
	@FindBy(xpath="//input[@id='amp_common_search_lookup_textbox_control__0']")private WebElement refText;
	@FindBy(xpath="//*[@id=\"amp_common_search_lookup_table_control_\"]/tbody//tr//td")private List<WebElement> allRefJob;
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ddlnextstat']")private WebElement nextStatus;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtstatdate']")private WebElement statusDate;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$imgOnceScheduleTime']")private WebElement time;
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ddlHH']")private WebElement hour;
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ddlMM']")private WebElement min;
	@FindBy(xpath="//a[text()='Apply']")private WebElement applyBtn;
	@FindBy(xpath="//textarea[@name='ctl00$ContentPlaceHolder1$txtremarks']")private WebElement remark;
//	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ImgSave\"]  | //*[@id=\"ctl00_ContentPlaceHolder1_btnreverse\"]")private List<WebElement> status; 
	@FindBy(xpath="//input[contains(@value,'Status')]")private List<WebElement> status;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_ImgSave']")private WebElement updateStatus;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$btnreverse']")private WebElement reverseStatus;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$btnClose']")private WebElement operComplete;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$txtcompdt']")private WebElement completionDate;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$ImgSave']")private WebElement statusname;
	
	@FindBy(xpath="//div[@class='fmBox ok']")private WebElement succ;
	@FindBy(xpath="(//a[text()='Close'])[2]")private WebElement closeBtn;
	
	@FindBy(xpath="//div[@class='fmBox ok']")private WebElement reverseSucc;
	@FindBy(xpath="(//a[text()='Close'])[2]")private WebElement reverseClose;
	
	
	public MainJobStatus2() {
		PageFactory.initElements(driver, this);
	}
	

	public void verifyNewBtn() throws Exception {
		Set<String> window = driver.getWindowHandles();

		Iterator<String> it = window.iterator();

		String mainpage = driver.getWindowHandle();
		while (it.hasNext()) {
			String str = it.next();
			if (!mainpage.equals(str)) {
				driver.switchTo().window(str);
			}
		}
	}

	
	public void verifyBasicDetails(int excel) throws Exception {
	
	  FileInputStream file5=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\maintJobStatus\\TestData\\MaintainJobSt.xlsx");	
		
		
			XSSFWorkbook workbook=new XSSFWorkbook(file5);
			XSSFSheet sheet = workbook.getSheet("jobStatus");
			int rowcount = sheet.getLastRowNum();
			int colcount = sheet.getRow(7).getLastCellNum();
			System.out.println("BasicDet rowcount:"+rowcount+"BasicDe colcount"+colcount);

			for(int i=7;i<=rowcount;i++)
			{
				XSSFRow celldata = sheet.getRow(i);	
				try {
		//		System.out.println("VALUE OF ID ="+ celldata.getCell(1).getNumericCellValue());
				int idNo = (int) celldata.getCell(1).getNumericCellValue();
				
				if(idNo == excel) {
					

//JOB NO
					Thread.sleep(2000);
					try {
					String jobno = celldata.getCell(2).getStringCellValue();
					
					System.out.println("Job No Btn is visible="+jobNoD.isDisplayed());
					jobNoD.click();
					refText.sendKeys(jobno);
					refText.sendKeys(Keys.ENTER);
					for(int i1=2;i1<=allRefJob.size();i1++) {
						if(allRefJob.get(i1).getText().equalsIgnoreCase(jobno)) {
							allRefJob.get(i1).click();}
						}}
					catch(Exception e) {Thread.sleep(1000);}     
					
//NEXT STATUS
					Thread.sleep(1000);
					try {
					String nextstat = celldata.getCell(3).getStringCellValue();
					Select s1=new Select(nextStatus);
					s1.selectByVisibleText(nextstat);}
					catch(Exception s) {
						Thread.sleep(1000);
					}	
					
//STATUS DATE
					
					Thread.sleep(1000);
					try {
					String date = celldata.getCell(4).getStringCellValue();
					statusDate.clear();
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("arguments[0].value='"+date+"'",statusDate);}
					catch(Exception p) {Thread.sleep(1000);}
					
					
//TIME
					Thread.sleep(1000);
					String hh = celldata.getCell(5).getStringCellValue();
					String mm = celldata.getCell(6).getStringCellValue();
					
					time.click();
					Thread.sleep(1000);
					Select se1=new Select(hour);
					se1.selectByVisibleText(hh);
					
					Thread.sleep(1000);
					Select se2=new Select(min);
					se2.selectByVisibleText(mm);
					
					Thread.sleep(1000);
					applyBtn.click();
					
//REMARKS
					
					Thread.sleep(1000);
					String rem = celldata.getCell(7).getStringCellValue();
					remark.clear();
					remark.sendKeys(rem);	
					                
					
//STATUS
					Thread.sleep(1000);
					String sta = celldata.getCell(8).getStringCellValue();
					
					String updateText = driver.findElement(By.name("ctl00$ContentPlaceHolder1$ImgSave")).getAttribute("value");
				    String reverseText = driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnreverse")).getAttribute("value");
				    
				    if(updateText.equalsIgnoreCase(sta)) {
				    		Thread.sleep(1000);
				    		updateStatus.click();
				    		Thread.sleep(2000);
				    		driver.findElement(By.xpath("(//a[text()='Close'])[2]")).click();}
			   else if( reverseText.equalsIgnoreCase(sta)) {
					      
				   try{
					      Thread.sleep(1000);
		    		       reverseStatus.click();
		    		       Thread.sleep(1500);
		    		       driver.switchTo().alert().accept();
		    		       Thread.sleep(1000);
		    		       reverseClose.click();}
				   catch(Exception e) {
			            Thread.sleep(1000);
			            driver.findElement(By.xpath("(//a[text()='Close'])[2]")).click();
			         }
				           }
//COMPLETION DATE
					Thread.sleep(1500);
					String compDate = celldata.getCell(9).getStringCellValue();
					JavascriptExecutor js1=(JavascriptExecutor)driver;
					js1.executeScript("arguments[0].value='"+compDate+"'", completionDate);
		
					
//CLOSE BUTTON
					
					Thread.sleep(1500);
					try {
					operComplete.click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("(//a[text()='Close'])[2]")).click();}
					catch(Exception e) {
						Thread.sleep(1000);
					}
					
			}
			}
				catch(NullPointerException e) {
					Thread.sleep(500);}
			
			}
}
}
