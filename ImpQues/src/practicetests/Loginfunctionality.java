package practicetests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Loginfunctionality 
{
	public static void main(String[] args) throws Exception
	{
	
	WebDriver driver=new FirefoxDriver();
	driver.get("http://test-popapp.rhcloud.com/#/main");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	WebElement dd_login=driver.findElement(By.xpath(".//*[@id='menu-navbar-collapse']/ul[4]/li/a"));
	dd_login.click();
	Actions actions=new Actions(driver);
	actions.moveToElement(dd_login).perform();
	driver.findElement(By.linkText("Login")).click();
	driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("gopi.kasu@gmail.com");
	driver.findElement(By.id("password")).sendKeys("password");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	driver.quit();

}
}
