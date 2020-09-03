package CRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Activity9 {
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Leads')]")));
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr/td[1]/ul[contains(@class,'listViewLinkButton_top')]/li/a[contains(@title,'Filter') and contains(@class,'glyphicon-filter')]")));
		//WebElement Filter=driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul[contains(@class,'listViewLinkButton_top')]/li/a[contains(@title,'Filter') and contains(@class,'glyphicon-filter')]"));
		//Filter.click();
		@SuppressWarnings("unused")
		List<WebElement> Filter=driver.findElements(By.xpath("//form[2]/div[3]/table/tbody/tr"));
		for (int i=1;i<=10;i++)
		{
			WebElement LeadDetails=driver.findElement(By.xpath("//form[2]/div[3]/table/tbody/tr["+i+"]/td[3]"));
			WebElement LeadUser=driver.findElement(By.xpath("//form[2]/div[3]/table/tbody/tr["+i+"]/td[8]"));
			System.out.println("Name "+i+" : "+LeadDetails.getText()+ " and User : "+LeadUser.getText() );
			
		}
		
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

