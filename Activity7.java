package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Activity7 {
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void ReadPopup() throws Exception {
	  	driver.manage().window().maximize();
	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/nav/div/div[2]/ul/li[1]/a")));
	 	WebElement Sales=driver.findElement(By.xpath("//a[text()='Sales']"));
	 	Sales.click();
	 	Thread.sleep(500);
	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sales']/following::ul[1]/li/a[text()='Leads']")));
	 	WebElement Salesleads=driver.findElement(By.xpath("//a[text()='Sales']/following::ul[1]/li/a[text()='Leads']"));
		Salesleads.click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr/td[1]/ul[contains(@class,'listViewLinkButton_top')]/li/a[contains(@title,'Filter') and contains(@class,'glyphicon-filter')]")));
		WebElement Filter=driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul[contains(@class,'listViewLinkButton_top')]/li/a[contains(@title,'Filter') and contains(@class,'glyphicon-filter')]"));
		Filter.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name_advanced")));
		WebElement firstname=driver.findElement(By.id("first_name_advanced"));
		firstname.sendKeys("Sofia");
		WebElement Search = driver.findElement(By.id("search_form_submit_advanced"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Search);
		Search.click();
		Thread.sleep(500);
		WebElement AdditionalInfo=driver.findElement(By.xpath("//span[@title='Additional Details']"));
		AdditionalInfo.click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='phone']")));
		WebElement phone=driver.findElement(By.xpath("//span[@class='phone']"));
		System.out.println("Phone: "+phone.getText());
		
	  }
  @BeforeMethod
  public void setup() {
	driver  = new FirefoxDriver();
	wait = new WebDriverWait(driver,20);
	driver.get("https://alchemy.hguy.co/crm/");
	WebElement username=driver.findElement(By.id("user_name"));
	WebElement pwd=driver.findElement(By.id("username_password"));  
	WebElement formId=driver.findElement(By.id("form"));
	username.sendKeys("admin");
	pwd.sendKeys("pa$$w0rd");
	formId.submit();
  }
  
  @AfterMethod
  public void teardown()
  {
	  driver.close();
  }
}

