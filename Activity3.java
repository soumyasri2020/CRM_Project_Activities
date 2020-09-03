package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;

	@BeforeMethod()

	public void openBrowser() {
		driver = new FirefoxDriver();
	}

	@Test
	void test() {
		driver.get("http://alchemy.hguy.co/crm");

		WebElement locator1 = driver.findElement(By.xpath("//*[@id=\"admin_options\"]"));

		String footer1 = locator1.getText();

		System.out.println(footer1);

		driver.close();

	}
}