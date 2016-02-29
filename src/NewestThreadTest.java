/*
 * As a user
 * I would like to be able to open the most recent post in a sub-forum
 * So that I can keep up with current discussions amongst the community.
 * 
 * Author: Colin Swan
 */

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

import org.junit.Test;

public class NewestThreadTest{
	/*
	 * Given I am on the homepage
	 * when I click the button for the most recent Gaming Discussion post
	 * then I should be sent to a thread in the Gaming or Gaming Community sub-forum.
	*/
	@Test
	public void testRecentGamingPost(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com");
		WebElement gamingElement = driver.findElement(By.id("f2"));
		WebElement e = gamingElement.findElement(By.className("forum-bit-lastpost-link"));
		e.click();
		
		WebElement tab = driver.findElement(By.className("activetab"));
		WebElement tabLink = tab.findElement(By.tagName("a"));
		String linkURL = tabLink.getAttribute("href");
		
		boolean gamingSection = (linkURL.equals("http://www.neogaf.com/forum/forumdisplay.php?f=2") || linkURL.equals("http://www.neogaf.com/forum/forumdisplay.php?f=8"));
		
		assertTrue(gamingSection);
		driver.quit();
	}
	
	/*
	 * Given I am on the homepage
	 * when I click the button for the most recent Off Topic Discussion post
	 * then I should be sent to a thread in the Off Topic or Off Topic Community sub-forum.
	*/
	@Test
	public void testRecentOffPost(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com");
		WebElement offElement = driver.findElement(By.id("f3"));
		WebElement e = offElement.findElement(By.className("forum-bit-lastpost-link"));
		e.click();
		
		WebElement tab = driver.findElement(By.className("activetab"));
		WebElement tabLink = tab.findElement(By.tagName("a"));
		String linkURL = tabLink.getAttribute("href");
		
		boolean gamingSection = (linkURL.equals("http://www.neogaf.com/forum/forumdisplay.php?f=3") || linkURL.equals("http://www.neogaf.com/forum/forumdisplay.php?f=20"));
		
		assertTrue(gamingSection);
		driver.quit();
	}

	
}