
package test_Book.POM;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import test_Book.BaseClass;
 
public class Verify_Website extends BaseClass {
	
	WebDriver driver;
	
	//Constructor
	public Verify_Website(WebDriver driver)
	{
		this.driver=driver;
	}
	

	//Locators

	
	
	//Action
	public void Verify() throws InterruptedException, IOException {
		   Thread.sleep(10000);
		   System.out.println("Urban Ladder!! Verification Under Process!!");
					// Verify the appropriate site is opened.
		   				Thread.sleep(3000);
					    if (driver.getTitle().contains("Buy Furniture Online and Get up to 50% Off | Shop Now - Urban Ladder")) {
					        System.out.println("**Urban Ladder site is opened!!**");
					    } else {
					        System.out.println("Urban Ladder site is not opened!! :(");
					       }
					 //Capture Screenshot 1
					     Thread.sleep(2000);
					     TakesScreenshot ts1= (TakesScreenshot)driver; 
					     File src1=ts1.getScreenshotAs(OutputType.FILE);
						 File trg1=new File("C:\\Users\\2308540\\Downloads\\DisplayBookshelves 2\\DisplayBookshelves\\ScreenShot\\HomePage.png");
						 FileUtils.copyFile(src1, trg1);
						 Thread.sleep(5000);
				   }
		
	}
