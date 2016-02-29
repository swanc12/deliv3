import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

import org.junit.Test;


public class GAFTest{
	
	/*
	 * Given I am on the home page for NeoGAF,
	 * then a registration button should exist.
	 */
	@Test
	public void testRegisterExists(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com");
		WebElement e = driver.findElement(By.className("submit"));
		assertTrue(e.isDisplayed());
		driver.quit();
		
	}
	
	/*
	 * Given a registration button exists,
	 * when I click the registration button,
	 * then I should be on the date of birth page.
	 */
	@Test
	public void testRegisterToDOB(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com");
		WebElement e = driver.findElement(By.className("submit"));
		e.click();
		String title = driver.getTitle();
		assertEquals("NeoGAF - Register", title);
		driver.quit();	
	}
	
	/*
	 *Given I am on the date of birth page,
	 *when I click the select element for "Month",
	 *and I choose a month,
	 *then the chosen month should be indicated as selected.
	 */
	@Test
	public void testDOBMonth(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com/forum/register.php");
		Select e = new Select(driver.findElement(By.name("month")));
		e.selectByVisibleText("April");
		WebElement selected = e.getFirstSelectedOption();
		String currText = selected.getText();
		assertEquals("April", currText);
		driver.quit();	
	}
	
	/*
	 *Given I am on the date of birth page,
	 *when I click the select element for "Day",
	 *and I choose a day,
	 *then the chosen day should be indicated as selected.
	 */
	@Test
	public void testDOBDay(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com/forum/register.php");
		Select e = new Select(driver.findElement(By.name("day")));
		e.selectByVisibleText("1");
		WebElement selected = e.getFirstSelectedOption();
		String currText = selected.getText();
		assertEquals("1", currText);
		driver.quit();	
	}
	
	/*
	 * Given I am on the date of birth page,
	 * when I click the input element for "Year",
	 * and I enter my year of birth,
	 * then the input box for year should contain my year of birth.
	 */
	@Test
	public void testDOBYear(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com/forum/register.php");
		WebElement e = driver.findElement(By.name("year"));
		e.click();
		e.sendKeys("1990");
		e.
		assertEquals("1990", e.getText());
		driver.quit();	
	}
	
}



