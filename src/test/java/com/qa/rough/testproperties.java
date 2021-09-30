package com.qa.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class testproperties {
	
	public static void main(String[]args) throws IOException {
		
		System.out.println(System.getProperty("user.dir"));// to get the project directory
		Properties config = new Properties();
		Properties OR = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
        config.load(fis); //to load the browser method
        System.out.println(config.getProperty("browser"));
        OR=new Properties();
        fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
        OR.load(fis); //to load the browser method
        System.out.println(OR.getProperty("signin"));
	}

}
