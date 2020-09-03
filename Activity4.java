package CRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Activity4 {
	WebDriver driver;
	  @BeforeMethod()
	 
	  public void openBrowser() {
		   driver = new FirefoxDriver();
}
	  @Test
	  void test()
	  {
		  driver.get("http://alchemy.hguy.co/crm");
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		 
	        WebElement userName = driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
	        WebElement password = driver.findElement(By.xpath("//*[@id=\"username_password\"]"));
	        //Type credentials
	        userName.sendKeys("admin");
	        password.sendKeys("pa$$w0rd");
	        //Click Log in
	        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();
	      
	        //Print login message
	       
	        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[3]/div/div/p/a"), "Email Settings"));
	        WebElement homepagetext = driver.findElement(By.xpath("/html/body/div[3]/div/div/p/a"));
	      
	      
	        System.out.println("Text on the locator is: " +homepagetext.getText());
	    		  
	     
	        //Close browser
	        driver.close();
}}