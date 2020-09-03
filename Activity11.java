package CRM;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
public class Activity11 {
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'actionmenulink') and text()='Import Leads']")));
		WebElement importmenu=driver.findElement(By.xpath("//div[contains(@class,'actionmenulink') and text()='Import Leads']"));
		importmenu.click();
		WebElement userfile=driver.findElement(By.id("userfile"));
		File file=new File("C:\\Users\\SarojSahoo\\Leads.csv");
		userfile.sendKeys(file.getAbsolutePath());
		WebElement Next=driver.findElement(By.id("gonext"));
		Next.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Confirm Import File Properties')]")));
		Next=driver.findElement(By.id("gonext"));
		Next.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Confirm Field Mappings')]")));
		Next=driver.findElement(By.id("gonext"));
		Next.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Check for Possible Duplicates')]")));
		WebElement importnow=driver.findElement(By.id("importnow"));
		importnow.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'View Import Results')]")));
		WebElement finished=driver.findElement(By.id("finished"));
		finished.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'actionmenulink') and text()='View Leads']")));
		WebElement Viewleadmenu=driver.findElement(By.xpath("//div[contains(@class,'actionmenulink') and text()='View Leads']"));
		Viewleadmenu.click();
		Thread.sleep(1000);
			
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