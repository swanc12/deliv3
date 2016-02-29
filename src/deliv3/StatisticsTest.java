package deliv3;
/*
 * User Story: As an unregistered user
 * I would like to register an account
 * so that I can become a member of NeoGAF.
 * 
 * Author: Colin Swan
 */

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class StatisticsTest{
	/*
	 * Given I am on the homepage
	 * then the forum-stats-bits element exists and is displayed.
	 */
	@Test
	public void testStatsElementDisplayed(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com");
		WebElement e = driver.findElement(By.className("forum-stats-bits"));
		assertTrue(e.isDisplayed());
		driver.quit();
	}
	
	/*
	 * Given I am on the homepage
	 * and the forum-stats-bits element exists
	 * then the threads variable should exist inside the forum-stats-bits element.
	 */
	@Test
	public void testStatsThreads(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com");
		WebElement e = driver.findElement(By.className("forum-stats-bits"));
		List<WebElement> varList = e.findElements(By.tagName("li"));
		boolean hasThreads = false;
		for(WebElement element : varList){
			if(element.getText().contains("Threads")){
				hasThreads = true;
			}
		}
		assertTrue(hasThreads);
		driver.quit();
	}
	
	/*
	 * Given I am on the homepage
	 * and the forum-stats-bits element exists
	 * then the posts variable should exist inside the forum-stats-bits element.
	 */
	@Test
	public void testStatsPosts(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com");
		WebElement e = driver.findElement(By.className("forum-stats-bits"));
		List<WebElement> varList = e.findElements(By.tagName("li"));
		boolean hasPosts = false;
		for(WebElement element : varList){
			if(element.getText().contains("Posts")){
				hasPosts = true;
			}
		}
		assertTrue(hasPosts);
		driver.quit();
	}
	
	/*
	 * Given I am on the homepage
	 * and the forum-stats-bits element exists
	 * then the members variable should exist inside the forum-stats-bits element.
	 */
	@Test
	public void testStatsMembers(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.neogaf.com");
		WebElement e = driver.findElement(By.className("forum-stats-bits"));
		List<WebElement> varList = e.findElements(By.tagName("li"));
		boolean hasMembers = false;
		for(WebElement element : varList){
			if(element.getText().contains("Members")){
				hasMembers = true;
			}
		}
		assertTrue(hasMembers);
		driver.quit();
	}
}