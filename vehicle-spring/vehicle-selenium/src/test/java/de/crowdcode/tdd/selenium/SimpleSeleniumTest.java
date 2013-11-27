package de.crowdcode.tdd.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SimpleSeleniumTest
{
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception
	{
		driver = new FirefoxDriver();
		baseUrl = "http://search.maven.org/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitled() throws Exception
	{
		driver.get(baseUrl + "/");
		assertEquals("The Central Repository Search Engine", driver.getTitle());
		driver.findElement(By.id("query")).clear();
		driver.findElement(By.id("query")).sendKeys("kissmda");
		driver.findElement(By.id("queryButton")).click();
		try
		{
			assertEquals("kissmda-parent", driver.findElement(By.linkText("kissmda-parent")).getText());
		} catch (Error e)
		{
			verificationErrors.append(e.toString());
		}
	}

	@After
	public void tearDown() throws Exception
	{
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString))
		{
			fail(verificationErrorString);
		}
	}

}
