package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import Utility.CommonFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser extends CommonFile{
	
	protected static WebDriver driver;

	public void initilization() throws Exception {
		
//Without Using Headless Browser			
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		driver = new ChromeDriver(options);
		driver.get(readExcelFileFinal(4, 1));
		driver.manage().window().maximize();    
		
		

//Using Headless Browser 			
/*		System.setProperty("webdriver.chrome.driver",
	            "C:\\Users\\Admin\\eclipse-workspace\\MainBooking\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*","ignore-certificate-errors"); 
	    options.addArguments("headless");
	    options.addArguments("window-size=1200x600");                                              //Its Run properly
	    driver = new ChromeDriver(options);
	 //   driver.get("https://contentstack.built.io");
	    driver.get(readExcelFileFinal(4, 1));	
		*/
		
	}

}
