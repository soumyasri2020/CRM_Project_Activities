package CRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Activity6 {
	WebDriver driver;
	  @BeforeMethod()
	 
	  public void openBrowser() {
		   driver = new FirefoxDriver();
}
	  @Test
	  void test()
	  {
		  driver.get("http://alchemy.hguy.co/crm");
		
		 
	        WebElement userName = driver.findElement(By.xpath("//*[@id=\"user_name\"]"));
	        WebElement password = driver.findElement(By.xpath("//*[@id=\"username_password\"]"));
	        //Type credentials
	        userName.sendKeys("admin");
	        password.sendKeys("pa$$w0rd");
	       
	        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();
	        WebElement navigation = driver.findElement(By.id("grouptab_3"));
	       
	        System.out.println(navigation.getText());
	             
	       if( navigation.getText().contentEquals("ACTIVITIES"))
	 
	       {
	        System.out.println("Menu ACTIVITIES present");
		}
	       driver.close();
	}
	       
}