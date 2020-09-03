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

public class Activity10 {
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void ReadDashlet() throws Exception {
	  	driver.manage().window().maximize();
	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/nav/div/div[2]/ul/li[1]/a")));
	 	Thread.sleep(500);
	 	List<WebElement> dashlet=driver.findElements(By.xpath("//td[@class='dashlet-title']"));
	 	System.out.println("Number of Dashlets in the Homepage: "+dashlet.size());
	 	System.out.println("Dashlet Titles are : ");
		for (WebElement x:dashlet)
		{
			System.out.println(x.getText());
			
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
	 // driver.close();
  }
}

