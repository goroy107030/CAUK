package com.test.CAUK;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class SmokeSuite {
	public  WebDriver driver;
	
	
	@BeforeMethod
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "D://Gouranga_Software//Selenium_All//ChromeDriver_Updated//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.cambridgeassessment.org.uk/");
		
		//https://www.cambridgeassessment.org.uk/
	}
	
	@AfterMethod
	public void trailing() {
		driver.quit();
	}
	
	@Test(enabled=false)
	public void pagetitletest() {
		String homepagetitle=driver.getTitle();
		String extitle="The University's international exams group | Cambridge Assessment";
		Assert.assertEquals(extitle, homepagetitle);
		System.out.println(homepagetitle);
	}
	@Test(enabled=false)
	public void printtest() {
		Assert.assertEquals(true, false);
		
	}
	
@Test
public void aboutuslinkTest() {
	
		
	 WebElement aboutuslink=driver.findElement(By.xpath("//*[@class='navigation_list']/li[2]"));
	 WebElement ourstructure=driver.findElement(By.xpath("//*[contains(text(),'Our structure')]"));
	 Actions act=new Actions(driver);
	 try {
		 boolean a=aboutuslink.isDisplayed();
		 System.out.println(a);
	 act.moveToElement(aboutuslink).perform();
	 Thread.sleep(3000);
	 ourstructure.click();
	 Thread.sleep(5000);
	 //act.moveToElement(ourstructure).perform();
	 //act.click();
	 String expagetitle=driver.getTitle();
	 System.out.println(expagetitle);
	 Assert.assertTrue(expagetitle.contains("Our structure"));
	 }catch(Exception e) {
		System.out.println(e); 
	 }finally {
		 System.out.println("Execution complete");
	 }
	
}
@Test
public void outvaluesTest() {
	WebElement aboutus=driver.findElement(By.xpath("//*[@class='navigation_list']/li[2]"));
	WebElement ourvalue=driver.findElement(By.xpath("//*[contains(text(),'Our value')]"));
	try {
	Actions act=new Actions(driver);
	act.moveToElement(aboutus).perform();
	Thread.sleep(3000);
	ourvalue.click();
	Thread.sleep(3000);
	String pagetitle=driver.getTitle();
	Assert.assertTrue(pagetitle.contains("Our values"));
	}catch(Exception e) {
		System.out.println(e);
	}finally {
		System.out.println("Execution Complete");
	}
	
	
	
	
}
}
