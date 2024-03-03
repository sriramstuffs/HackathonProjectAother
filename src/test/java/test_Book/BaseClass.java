package test_Book;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import test_Book.POM.DisplayBookShelvess;
import test_Book.POM.FilterTheBookShelves;
import test_Book.POM.GiftCardFormsNegative;
import test_Book.POM.GiftCardFormsPositive;
import test_Book.POM.GiftCardPage;
import test_Book.POM.PageObjectModel;
import test_Book.POM.Verify_Website;

//@Listeners(ExtentReportManager.class)
public class BaseClass  {
	static public WebDriver driver;
	@BeforeClass
	@Parameters({ "Browser", "Url" })
	void setup_Browser(String browser, String appUrl) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
		driver.get(appUrl);
		// Maximize the window.
		driver.manage().window().maximize();
	}
//*********************************************************************************************************************	
	
	
	@Test(priority = 1,groups= {})
	   void VerifyWebsite() throws InterruptedException, IOException {
		   System.out.println("==========================================================================");
		   System.out.println("TC_001_Verify_Website");
		   System.out.println("==========================================================================");
		   Verify_Website pageObjectModel = new Verify_Website(driver);
		   pageObjectModel.Verify();
	   }

	@Test(priority = 2)
	void displayBookShelves() throws InterruptedException, IOException {
		System.out.println("==========================================================================");
		System.out.println("TC_002_DisplayBookShelves");
		System.out.println("==========================================================================");
		DisplayBookShelvess pageObjectModel = new DisplayBookShelvess(driver);
		   pageObjectModel.DisplayBookShelves();
		
	}

	@Test(priority = 3)
	void ByAtHome() throws InterruptedException, IOException {
		System.out.println("==========================================================================");
		System.out.println("TC_003_FilterBookShelves");
		System.out.println("==========================================================================");
		FilterTheBookShelves pageObjectModel = new FilterTheBookShelves(driver);
		   pageObjectModel.FilterBookShelves();
		
	}

	@Test(priority = 4)
	void giftCard() throws InterruptedException, IOException {
		System.out.println("==========================================================================");
		System.out.println("TC_004_GiftCard");
		System.out.println("==========================================================================");
		GiftCardPage pageObjectModel = new GiftCardPage(driver);
		   pageObjectModel.GiftCard();
	}
	
	@Test(priority = 5)
	void giftCardformNegative() throws InterruptedException, IOException {
		System.out.println("==========================================================================");
		System.out.println("TC_005_GiftCardFormNegative");
		System.out.println("==========================================================================");
		GiftCardFormsNegative pageObjectModel = new GiftCardFormsNegative(driver);
		   pageObjectModel.GiftCardformNegative();
	}
	
	@Test(priority = 6)
	void giftCardformPositive() throws InterruptedException, IOException {
		System.out.println("==========================================================================");
		System.out.println("TC_006_GiftCardFormPositive");
		System.out.println("==========================================================================");
		GiftCardFormsPositive pageObjectModel = new GiftCardFormsPositive(driver);
		   pageObjectModel.GiftCardformPositive();
	}

	@AfterClass
	void close_Browser() {
		driver.quit();
	}

	public String captureScreen(String name) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\ExtentReport-SS\\" +  "ExtentReport_SS" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}


	

}
