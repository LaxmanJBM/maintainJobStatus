package mainJobStatus;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Browser;
import Utility.CommonFile;
import mainJobStatusScreen.MainJobStatus1;
import mainJobStatusScreen.MainJobStatus2;

public class MainJobStatusTest extends Browser{
	
	MainJobStatus1 jb1;
	MainJobStatus2 jb2;

	@BeforeMethod
	public void setup() throws Exception {

		initilization();
		jb1 = new MainJobStatus1();
		jb2 = new MainJobStatus2();
		jb1.verifyLoginApp();
		Thread.sleep(2000);

		jb1.verifyIFFBtn();
		Thread.sleep(2000);
		jb1.verifyOperationBtn();
		Thread.sleep(2000);
		jb1.verifMainJobStatusBtn();
		Thread.sleep(2000);
		jb2.verifyNewBtn();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}


	
	@Test( enabled =true)
	public void data() throws Exception {
		 FileInputStream file1=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\maintJobStatus\\TestData\\MaintainJobSt.xlsx");		
			XSSFWorkbook workbook=new XSSFWorkbook(file1);
			XSSFSheet sheet = workbook.getSheet("jobStatus");
			int rowcount = sheet.getLastRowNum();
			int row= rowcount - 6;
			int colcount = sheet.getRow(7).getLastCellNum();
			System.out.println("rowcount in test:"+row+" colcount in test:"+colcount);
		
		for(int exec=1;exec<=row;exec++) {
			Thread.sleep(2000);
		
			jb2.verifyBasicDetails(exec);
		
			System.out.println("*** JOB BOOKING DONE : "+exec+" ***");
	
	}
	
	}
	

	@AfterMethod
	
	public void exit(ITestResult b) throws Throwable
	{
		if(ITestResult.FAILURE == b.getStatus())
		{	
			CommonFile.captureScreenshotFaildTC(driver,b.getName());
		}
		Thread.sleep(2500);  
		driver.quit();
	
	}
	


}
