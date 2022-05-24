package com.sample.web;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ApplicationForm {
	
	@Test
	public void keyInApplicationForm() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/resources/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/automation-practice-form");
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[normalize-space()='Student Registration Form']")));
		
		driver.findElement(By.xpath("//h5[normalize-space()='Student Registration Form']")).getText().equals("Student Registration Form");
		
		driver.findElement(By.xpath("//*[@id='firstName']")).click();
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Sheldon");

		driver.findElement(By.xpath("//*[@id='lastName']")).click();
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Cooper");
		
	
		driver.findElement(By.xpath("//*[@id='genterWrapper']/div[2]/div[1]/label")).click();
		
		driver.quit();
	}
}
