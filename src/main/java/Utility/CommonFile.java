package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CommonFile {
	
public static WebDriver driver;
	
	public static String readExcelFile(int row,int col) throws Exception
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\maintJobStatus\\TestData\\MaintainJobSt.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("jobStatus");
		String value = excelSheet.getRow(row).getCell(col).getStringCellValue();
	 	return value;
	}
	
	public static void captureScreenshotFaildTC(WebDriver driver, String nameOfMethod) throws Throwable
	{
		Date d=new Date();
		String date = d.toString().replace(" ", "-").replace(":", "-");
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\Admin\\eclipse-workspace\\maintJobStatus\\failedScreenShot\\"+ nameOfMethod +","+date+".png");
		FileHandler.copy(source, destination);
	}
	
	
	
	public static String readExcelFileFinal(int row,int col) throws Exception
	{
		FileInputStream fileF=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\maintJobStatus\\TestData\\MaintainJobSt.xlsx");
		Sheet excelSheet = WorkbookFactory.create(fileF).getSheet("jobStatus");
		String value = excelSheet.getRow(row).getCell(col).getStringCellValue();
	 	return value;
	}


}
