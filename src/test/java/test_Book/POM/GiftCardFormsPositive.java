
package test_Book.POM;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import test_Book.BaseClass;
 
public class GiftCardFormsPositive extends BaseClass {
	
	WebDriver driver;
	
	//Constructor
	public GiftCardFormsPositive(WebDriver driver)
	{
		this.driver=driver;
	}
	

	//Locators
	
	
	
	//Action
	public void GiftCardformPositive() throws InterruptedException, IOException {
		Thread.sleep(5000);
		driver.findElement(By.name("recipient_email")).clear();
		driver.findElement(By.name("recipient_email")).sendKeys("Shakti@gmail.com");
		
		
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(5000);
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		String repName = "GiftCard-SS-" + timeStamp + ".png";
		try {
		FileUtils.copyFile(source,new File("C:\\Users\\2308540\\Downloads\\DisplayBookshelves 2\\DisplayBookshelves\\ScreenShot\\"+repName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("GiftCard Screenshot is captured and saved successfully");
	}
		
	
}
