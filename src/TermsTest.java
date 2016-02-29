/*
 * As a user
 * I would like to view the terms of service for NeoGAF
 * So that I can learn about the membership process and how I can avoid getting myself banned.
 * 
 * Author: Colin Swan
 */

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TermsTest{
	/*
	 * Given I am on the homepage
	 * When I click the TOS button
	 * Then I should be taken to the TOS forum post.
	*/
	@Test
	public void testHomepageTOS(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com");
		WebElement e = driver.findElement(By.className("toolbaricon-tos"));
		e.click();
		String currURL = driver.getTitle();
		assertEquals("Terms of Service - NeoGAF", currURL);
		driver.quit();
	}
	
	/*
	 * Given I am within the Gaming Discussion sub-forum
	 * When I click the TOS button
	 * Then I should be taken to the TOS forum post.
	*/
	@Test
	public void testGamingTOS(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com/forum/forumdisplay.php?f=2");
		WebElement e = driver.findElement(By.className("toolbaricon-tos"));
		e.click();
		String currURL = driver.getTitle();
		assertEquals("Terms of Service - NeoGAF", currURL);
		driver.quit();
	}
	
	/*
	 * Given I am within the Off Topic Discussion sub-forum
	 * When I click the TOS button
	 * Then I should be taken to the TOS forum post.
	*/
	@Test
	public void testOffTOS(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com/forum/forumdisplay.php?f=3");
		WebElement e = driver.findElement(By.className("toolbaricon-tos"));
		e.click();
		String currURL = driver.getTitle();
		assertEquals("Terms of Service - NeoGAF", currURL);
		driver.quit();
	}
	
	/*
	 * Given I am within the Off Topic Discussion sub-forum
	 * When I click the TOS button
	 * Then I should be taken to the TOS forum post.
	*/
	@Test
	public void testThreadTOS(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com");
		WebElement gamingElement = driver.findElement(By.id("f2"));
		WebElement e = gamingElement.findElement(By.className("forum-bit-lastpost-link"));
		e.click();
		e = driver.findElement(By.className("toolbaricon-tos"));
		e.click();
		String currURL = driver.getTitle();
		assertEquals("Terms of Service - NeoGAF", currURL);
		driver.quit();
		
	}
}