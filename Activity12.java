package CRM;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
public class Activity12 {
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void ReadPopup() throws Exception {
	  	driver.manage().window().maximize();
	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/nav/div/div[2]/ul/li[1]/a")));
	 	WebElement Sales=driver.findElement(By.xpath("//a[text()='Activities']"));
	 	Sales.click();
	 	Thread.sleep(500);
	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Activities']/following::ul[1]/li/a[text()='Meetings']")));
	 	WebElement Salesleads=driver.findElement(By.xpath("//a[text()='Activities']/following::ul[1]/li/a[text()='Meetings']"));
		Salesleads.click();
		Thread.sleep(500);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Schedule Meeting')]")));
		WebElement schedule_meeting=driver.findElement(By.xpath("//div[contains(text(),'Schedule Meeting')]"));
		schedule_meeting.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'CREATE')]")));
		
		WebElement Subject=driver.findElement(By.id("name"));
		Subject.sendKeys("Test Meeting 4");
		
		WebElement description=driver.findElement(By.id("description"));
		description.sendKeys("Test Meeting description 2");
		
		WebElement search_first_name=driver.findElement(By.id("search_first_name"));
		search_first_name.sendKeys("Sofia");
		
		WebElement invitees_search=driver.findElement(By.id("invitees_search"));
		invitees_search.click();
		
		//search_first_name=driver.findElement(By.id("search_first_name"));
		search_first_name.sendKeys("test");
		
		//WebElement invitees_search=driver.findElement(By.id("invitees_search"));
		invitees_search.click();
		WebElement SAVE_HEADER=driver.findElement(By.id("SAVE_HEADER"));
		SAVE_HEADER.click();
		
		WebElement view_meeting=driver.findElement(By.xpath("//div[contains(text(),'View Meetings')]"));
		view_meeting.click();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Meetings')]")));
		WebElement meeting=driver.findElement(By.xpath("//a[contains(text(),'Test Meeting 4')]"));
		Assert.assertTrue(meeting.isDisplayed());
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