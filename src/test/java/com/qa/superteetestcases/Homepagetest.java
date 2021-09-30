package com.qa.superteetestcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.base.testbase;

public class Homepagetest extends testbase{
	
	@Test
	public void clickonsignin() {
		
		driver.findElement(By.xpath(OR.getProperty("poplink"))).click();

}
}
