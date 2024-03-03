
package test_Book.POM;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import test_Book.BaseClass;
 
public class FilterTheBookShelves extends BaseClass {
	
	WebDriver driver;
	
	//Constructor
	public FilterTheBookShelves(WebDriver driver)
	{
		this.driver=driver;
	}
	

	//Locators
	
	
	
	//Action
	public void FilterBookShelves() throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='In Stock Only']")).click();
		Thread.sleep(3000);
		WebElement priceElement=driver.findElement(By.xpath("//div[normalize-space()='Brand']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(priceElement).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"filters_brand_name_By_Bahcane\"]")).click();
		Thread.sleep(3000);
		System.out.println("*********==========================================");
		System.out.println("List of products in by at home:");
		List<WebElement> Nameofproduct = driver.findElements(By.xpath("//span[@class='name']"));
		List<WebElement> Priceofproduct = driver.findElements(By.xpath("//div[@class='price-number']/span"));
		System.out.println("Number of Product Available " + Nameofproduct.size());
		if (Nameofproduct.size() == 0) {
			System.out.println("No product");
		} else {
			// Top 3 Products.
			System.out.println("Name of Product: ");
			for (int i = 0; i < Nameofproduct.size(); i++) {
				System.out.println(Nameofproduct.get(i).getText() + "  " + Priceofproduct.get(i).getText());
			}
		}
		Thread.sleep(3000);
		// Extract the Name and Price of available product on the Excel Sheet.
		// Apache POI implemented here.
		FileOutputStream file = new FileOutputStream("C:\\Users\\2308540\\Downloads\\DisplayBookshelves 2\\DisplayBookshelves\\excel\\output2.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		for (int i = 0; i < Nameofproduct.size(); i++) {
			String name = Nameofproduct.get(i).getText();
			String price = Priceofproduct.get(i).getText();
			XSSFRow currentrow = sheet.createRow(i);
			XSSFCell cell = currentrow.createCell(0);
			XSSFCell cell1 = currentrow.createCell(1);
			cell.setCellValue(name);
			cell1.setCellValue(price);
		}
		workbook.write(file);
		workbook.close();
		file.close();

		actions.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(5000);
		
}
}		
