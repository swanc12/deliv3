import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

import org.junit.Test;


public class GAFTest{
	
	@Test
	public void testMain(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com");
		WebElement e = driver.findElement(By.name("description"));
		driver.quit();
		boolean test = true;
		assertEquals(true, test);
		
	}
	
}



