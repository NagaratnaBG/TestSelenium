package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class testbase {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	
	@BeforeSuite
	public void setup() throws IOException{
		if (driver==null){
			
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
	        config.load(fis); //to load the browser method
	        log.debug("config file loaded");
	        
	        OR=new Properties();
	        fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
	        OR.load(fis); //to load the browser method
	        
		}
		 
		 if (config.getProperty("browser").equals("chrome")) {
			 
			 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver (1).exe");
			 driver=new ChromeDriver();
			 log.debug("chrome browser launched");
		 } else if (config.getProperty("browser").equals("firfox")) {
		 
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver (1).exe");
		 driver=new FirefoxDriver();
		 log.debug("config file loaded");
	
	}else if (config.getProperty("browser").equals("ie")) {
		 
		 System.setProperty("webdriver.Inter.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver (1).exe");
		driver=new InternetExplorerDriver();
	
	}
		 driver.get(config.getProperty("testsiteurl"));
		 log.debug("website url launched");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("timeunit")), TimeUnit.SECONDS);
	}
		 
	
	@AfterSuite
	public void teardown(){
		
	}

}
