package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_Parallel 
{
	private WebDriver driver=null;
	
	@BeforeClass
	
	@Parameters({"browser"})
	
	public void setUp(String browser)
	{
		if(browser.equals("firefox"))
		{
			System.out.println("system starts running in firefox");
			driver=new FirefoxDriver();
		}
		else if(browser.equals("chrome"));
		{
			System.out.println("system starts running in chrome");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sudheer\\git\\Selenium\\ImpQues\\exe\\chromedriver.exe");
			
			driver=new ChromeDriver();			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://test-popapp.rhcloud.com");
		
	}
	
	
	@Test
	public void testlogin()
	{
		WebElement dd_login=driver.findElement(By.xpath(".//*[@id='menu-navbar-collapse']/ul[4]/li/a"));
		dd_login.click();
		Actions actions=new Actions(driver);
		actions.moveToElement(dd_login).perform();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("gopi.kasu@gmail.com");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}

}
