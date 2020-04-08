package com.test.CAUK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SmokeSuite {
	public  WebDriver driver;
	
	
	@BeforeMethod
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "D://Gouranga_Software//Selenium_All//ChromeDriver_Updated//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.cambridgeassessment.org.uk/");
		
		//https://www.cambridgeassessment.org.uk/
	}
	
	@AfterMethod
	public void trailing() {
		driver.quit();
	}
	
	@Test
	public void pagetitletest() {
		String homepagetitle=driver.getTitle();
		String extitle="The University's international exams group | Cambridge Assessment";
		Assert.assertEquals(extitle, homepagetitle);
	}
	

}
