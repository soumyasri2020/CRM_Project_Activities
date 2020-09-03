package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;

	@BeforeMethod()

	public void openBrowser() {
		driver = new FirefoxDriver();
	}

	@Test
	void test() {
		driver.get("http://alchemy.hguy.co/crm");
		WebElement linkTextLocator = driver.findElement(By.linkText("SuiteCRM"));
		System.out.println("The url of the header is: " + linkTextLocator.getAttribute("href"));

		driver.close();
	}
}