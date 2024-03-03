
package test_Book.POM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import test_Book.BaseClass;
 
public class GiftCardFormsNegative extends BaseClass {
	
	WebDriver driver;
	
	//Constructor
	public GiftCardFormsNegative(WebDriver driver)
	{
		this.driver=driver;
	}
	

	//Locators

	
	
	//Action
	public void GiftCardformNegative() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//input[@class='tDZNG _16Q29']")).sendKeys("5000"); // money
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@class='Upz18 _1hLiD UJU2v']")).click();
		driver.findElement(By.xpath("//select[@class='Upz18 _1hLiD UJU2v']/option[3]")).click();
		driver.findElement(By.xpath("//select[@class='Upz18 _1hLiD UJU2v'][2]")).click();
		driver.findElement(By.xpath("//select[@class='Upz18 _1hLiD UJU2v'][2]/option[3]")).click();
		// Button
		driver.findElement(By.xpath("//button[@class='_1IFIb _1fVSi action-button _1gIUf _1XfDi']")).click();

		// inserting values for from
		XSSFWorkbook workbook1 = null;

		try {
			FileInputStream fileInputStream = new FileInputStream(
					"C:\\Users\\2308540\\Downloads\\DisplayBookshelves 2\\DisplayBookshelves\\excel\\input.xlsx");
			workbook1 = new XSSFWorkbook(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		XSSFSheet xssfSheet = workbook1.getSheet("Sheet1");
		XSSFRow row = xssfSheet.getRow(0);
		XSSFCell cell = row.getCell(0);
		String c1 = cell.getStringCellValue();

		driver.findElement(By.name("recipient_name")).sendKeys(c1);
		row = xssfSheet.getRow(1);
		cell = row.getCell(0);
		String c2 = cell.getStringCellValue();
		driver.findElement(By.name("recipient_email")).sendKeys(c2);
		row = xssfSheet.getRow(2);
		cell = row.getCell(0);
		DataFormatter dFormatter = new DataFormatter();
		String c3 = dFormatter.formatCellValue(cell);
		driver.findElement(By.name("recipient_mobile_number")).sendKeys(c3);

		// inserting value for to
		row = xssfSheet.getRow(3);
		cell = row.getCell(0);
		String c4 = cell.getStringCellValue();
		driver.findElement(By.name("customer_name")).sendKeys(c4);
		row = xssfSheet.getRow(4);
		cell = row.getCell(0);
		String c5 = cell.getStringCellValue();
		driver.findElement(By.name("customer_email")).sendKeys(c5);
		row = xssfSheet.getRow(5);
		cell = row.getCell(0);
		String c6 = dFormatter.formatCellValue(cell);
		driver.findElement(By.name("customer_mobile_number")).sendKeys(c6);
		row = xssfSheet.getRow(6);
		cell = row.getCell(0);
		String c7 = (String) cell.getStringCellValue();
		driver.findElement(By.name("customer_address")).sendKeys(c7);
		row = xssfSheet.getRow(7);
		cell = row.getCell(0);
		String c8 = dFormatter.formatCellValue(cell);
		driver.findElement(By.name("zip")).sendKeys(c8);
		row = xssfSheet.getRow(8);
		cell = row.getCell(0);
		String c9 = cell.getStringCellValue();
		driver.findElement(By.name("message")).sendKeys(c9);
		Thread.sleep(3000);

		// click confirm button

		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(5000);
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		String repName = "Error_Message-SS-" + timeStamp + ".png";
		try {
		FileUtils.copyFile(source,new File("C:\\Users\\2308540\\Downloads\\DisplayBookshelves 2\\DisplayBookshelves\\ScreenShot\\"+repName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Error Message Screenshot is captured and saved successfully");	
			
	}
	
}
