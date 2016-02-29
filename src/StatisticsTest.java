/*
 * User Story: As a user
 * I would like to see activity statistics on the home page
 * So that I know how active the community is.
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
	 * then the forum statistics should be displayed
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
	 * and the forum statistics are displayed
	 * then the number of threads should be displayed in the statistics display
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
	 * and the forum statistics are displayed
	 * then the number of posts should be displayed in the statistics display
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
	 * and the statistics are displayed
	 * then the number of members should be displayed in the statistics display.
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