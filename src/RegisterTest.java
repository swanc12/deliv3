/*
 * User Story: As an unregistered user
 * I would like to register an account
 * so that I can become a member of NeoGAF.
 * 
 * Author: Colin Swan
 */

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

import org.junit.Test;


public class RegisterTest{
	
	/*
	 * Given I am on the home page for NeoGAF,
	 * then a registration button should exist and is displayed.
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
	 * and the "Month", "Day", and "Year" fields are empty,
	 * when I click "proceed"
	 * then a message asking to enter a month appears.
	 */
	@Test
	public void testDOBMonthError(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com/forum/register.php");
		WebElement e = driver.findElement(By.xpath("//input[(@value=' Proceed ') and  (@class='button')]"));
		e.click();
		String currText = driver.switchTo().alert().getText();
		assertEquals("Select a month", currText);
		driver.quit();	
	}
	
	/*
	 * Given I am on the date of birth page,
	 * and the "Day" and "Year" fields are empty,
	 * when I click "proceed"
	 * then a message asking to enter a day appears.
	 */
	@Test
	public void testDOBDayError(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com/forum/register.php");
		Select month = new Select(driver.findElement(By.name("month")));
		month.selectByVisibleText("April");
		WebElement e = driver.findElement(By.xpath("//input[(@value=' Proceed ') and  (@class='button')]"));
		e.click();
		String currText = driver.switchTo().alert().getText();
		assertEquals("Select a day", currText);
		driver.quit();	
	}
	
	/*
	 * Given I am on the date of birth page,
	 * and the "Year" field is empty,
	 * when I click "proceed"
	 * then a message asking to enter a proper year appears.
	 */
	@Test
	public void testDOBYearError(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com/forum/register.php");
		Select month = new Select(driver.findElement(By.name("month")));
		month.selectByVisibleText("April");
		Select day = new Select(driver.findElement(By.name("day")));
		day.selectByVisibleText("1");
		WebElement e = driver.findElement(By.xpath("//input[(@value=' Proceed ') and  (@class='button')]"));
		e.click();
		String currText = driver.switchTo().alert().getText();
		assertEquals("Please enter a proper year", currText);
		driver.quit();	
	}
	
	/*
	 * Given I am on the Forum Rules Agreement Page,
	 * and I have not checked the "I have read, and agree to abide by the NeoGAF rules." box,
	 * when I click "Register",
	 * then a message declining my registration should appear.
	 */
	@Test
	public void testRegDeclinedPage(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com/forum/register.php");
		Select month = new Select(driver.findElement(By.name("month")));
		month.selectByVisibleText("April");
		Select day = new Select(driver.findElement(By.name("day")));
		day.selectByVisibleText("1");
		WebElement year = driver.findElement(By.name("year"));
		year.click();
		year.sendKeys(("1990"));
		WebElement e = driver.findElement(By.xpath("//input[(@value=' Proceed ') and  (@class='button')]"));
		e.click();
		e = driver.findElement(By.xpath("//input[(@value='Register') and  (@class='button')]"));
		e.click();
		e = driver.findElement(By.className("panelsurround"));
		String currText = e.getText();
		assertEquals("You have chosen not to accept the forum rules, so registration cannot continue."
				+ "\n\nClick here to return to the main forums page, or click the 'Back' button on your "
				+ "browser if you now want to agree with the forum rules.", currText);
		driver.quit();	
		
	}
	
	/*
	 * Given I am on the Forum Rules Agreement Page,
	 * and I have checked the "I have read, and agree to abide by the NeoGAF rules." box,
	 * when I click "Register",
	 * then I should be sent to the Registration page.
	 */
	@Test
	public void testRegisterPage(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com/forum/register.php");
		Select month = new Select(driver.findElement(By.name("month")));
		month.selectByVisibleText("April");
		Select day = new Select(driver.findElement(By.name("day")));
		day.selectByVisibleText("1");
		WebElement year = driver.findElement(By.name("year"));
		year.click();
		year.sendKeys(("1990"));
		WebElement e = driver.findElement(By.xpath("//input[(@value=' Proceed ') and  (@class='button')]"));
		e.click();
		e = driver.findElement(By.id("cb_rules_agree"));
		e.click();
		e = driver.findElement(By.xpath("//input[(@value='Register') and  (@class='button')]"));
		e.click();
		String currString = driver.getTitle();
		assertEquals("NeoGAF - Registration", currString);
		driver.quit();	
		
	}
	
	/*
	 * Given I am on the Registration page
	 * and no information has been filled out
	 * when I click "Complete Registration"
	 * then a message should appear indicating that I must fill out the password fields.
	 */
	@Test
	public void testRegisterPageEmptyAlert(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com/forum/register.php");
		Select month = new Select(driver.findElement(By.name("month")));
		month.selectByVisibleText("April");
		Select day = new Select(driver.findElement(By.name("day")));
		day.selectByVisibleText("1");
		WebElement year = driver.findElement(By.name("year"));
		year.click();
		year.sendKeys(("1990"));
		WebElement e = driver.findElement(By.xpath("//input[(@value=' Proceed ') and  (@class='button')]"));
		e.click();
		e = driver.findElement(By.id("cb_rules_agree"));
		e.click();
		e = driver.findElement(By.xpath("//input[(@value='Register') and  (@class='button')]"));
		e.click();
		e = driver.findElement(By.xpath("//input[(@value='Complete Registration') and  (@class='button')]"));
		e.click();
		String currString = driver.switchTo().alert().getText();
		assertEquals("Please fill out both password fields.", currString);
		driver.quit();	
		
	}
}



