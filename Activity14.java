package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Activity14 {
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void ReadPopup() throws Exception {
	  	driver.manage().window().maximize();
	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/nav/div/div[2]/ul/li[1]/a")));
	 	WebElement Sales=driver.findElement(By.xpath("//a[text()='Sales']"));
	 	Sales.click();
	 	Thread.sleep(500);
	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sales']/following::ul[1]/li/a[text()='Opportunities']")));
	 	WebElement Salesopty=driver.findElement(By.xpath("//a[text()='Sales']/following::ul[1]/li/a[text()='Opportunities']"));
	 	Salesopty.click();
		Thread.sleep(500);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Opportunities')]")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr/td[1]/ul[contains(@class,'listViewLinkButton_top')]/li/a[contains(@title,'Filter') and contains(@class,'glyphicon-filter')]")));
		WebElement Filter=driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul[contains(@class,'listViewLinkButton_top')]/li/a[contains(@title,'Filter') and contains(@class,'glyphicon-filter')]"));
		Filter.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Advanced Filter')]")));
		WebElement Advancedfilter=driver.findElement(By.xpath("//a[contains(text(),'Advanced Filter')]"));
		Advancedfilter.click();
		
		Select OptyAmt=new Select(driver.findElement(By.id("amount_advanced_range_choice")));
		OptyAmt.selectByValue("greater_than");
		
		Select salesstage=new Select(driver.findElement(By.id("sales_stage_advanced")));
		salesstage.selectByValue("Prospecting");
		salesstage.selectByValue("Needs Analysis");
		salesstage.selectByValue("Proposal/Price Quote");
		
		Select leadsrc=new Select(driver.findElement(By.id("lead_source_advanced")));
		leadsrc.selectByValue("Existing Customer");
		leadsrc.selectByValue("Self Generated");
		leadsrc.selectByValue("Partner");
		
		WebElement direction=driver.findElement(By.xpath("//span[contains(text(),'Ascending')]"));
		direction.click();
		
		WebElement search=driver.findElement(By.id("search_form_submit_advanced"));
		search.click();
		Thread.sleep(500);
		List<WebElement> optydetails=driver.findElements(By.xpath("//form[2]/div[3]/table/tbody/tr"));
		for (WebElement x:optydetails)
		{
			System.out.println(x.getText());
			System.out.println("");
			
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/div[1]/div/div[3]/form[2]/div[3]/table/thead/tr[2]/td/table//li[1]/a[contains(@class,'glyphicon-remove')]")));
		WebElement removeFilter=driver.findElement(By.xpath("//body/div[2]/div[1]/div/div[3]/form[2]/div[3]/table/thead/tr[2]/td/table//li[1]/a[contains(@class,'glyphicon-remove')]"));
		removeFilter.click();

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