package CRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver;

	@BeforeMethod()

	public void openBrowser() {
		driver = new FirefoxDriver();
	}

	@Test
	void test() {
		driver.get("http://alchemy.hguy.co/crm");

		String title = driver.getTitle();
		// Print the title of the page
		System.out.println("Page title is: " + title);
		driver.close();
	}
}