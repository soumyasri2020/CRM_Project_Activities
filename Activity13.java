package CRM;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity13 {
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void ReadPopup() throws Exception {
		
		  driver.manage().window().maximize();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/nav/div/div[2]/ul/li[1]/a"))); 
		  WebElement All=driver.findElement(By.xpath("//a[text()='All']")); All.click();
		  Thread.sleep(500); WebElement element = driver.findElement(By.xpath("//a[text()='All']/following::ul[1]/li/a[text()='Products']"));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		  Thread.sleep(500);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='All']/following::ul[1]/li/a[text()='Products']"))); 
		  WebElement products=driver.findElement(By.xpath("//a[text()='All']/following::ul[1]/li/a[text()='Products']"));
		  products.click();
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Products')]"))); Thread.sleep(500);
		 
		 
		
		//CSVReader reader=new CSVReader(new FileReader("src/Products.csv"));
		@SuppressWarnings("resource")
		CSVReader reader=new CSVReader(new FileReader("C:\\Users\\SofiaKamal\\Desktop\\Automation\\Selenium\\Products.csv"));
		
		List<String[]> list=reader.readAll();
		System.out.println("Total Number of rows "+list.size());
	
		Iterator<String[]> itr=list.iterator();
		String[] str = itr.next();
		while(itr.hasNext())
		{
			str = itr.next();
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'actionmenulink') and text()='Create Product']")));
			  WebElement createProd=driver.findElement(By.xpath("//div[contains(@class,'actionmenulink') and text()='Create Product']"));
			  createProd.click();
			  
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))); 
			 WebElement productname=driver.findElement(By.id("name"));
			 productname.sendKeys(str[0]);
			 
			 WebElement partnum=driver.findElement(By.id("part_number"));
			 partnum.sendKeys(str[1]);
			 
			 WebElement price=driver.findElement(By.id("price"));
			 price.sendKeys(str[2]);
			 
			 WebElement description=driver.findElement(By.id("description"));
			 description.sendKeys(str[3]);
			 
			 WebElement SAVE=driver.findElement(By.id("SAVE"));
			 SAVE.click();
			
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'actionmenulink') and text()='View Products']")));
		  WebElement viewProd=driver.findElement(By.xpath("//div[contains(@class,'actionmenulink') and text()='View Products']"));
		  viewProd.click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Products')]")));
		  Thread.sleep(500);
			WebElement product=driver.findElement(By.xpath("//a[contains(text(),'"+str[0]+"')]"));
			Assert.assertTrue(product.isDisplayed());
	  }
  @BeforeMethod
  public void setup() {
	driver  = new FirefoxDriver();
	wait = new WebDriverWait(driver,20);
	
	  driver.get("https://alchemy.hguy.co/crm/"); WebElement
	  username=driver.findElement(By.id("user_name")); WebElement
	  pwd=driver.findElement(By.id("username_password")); WebElement
	  formId=driver.findElement(By.id("form")); username.sendKeys("admin");
	  pwd.sendKeys("pa$$w0rd"); formId.submit();
	 
  }
  
  @AfterMethod
  public void teardown()
  {
	  driver.close();
  }
}