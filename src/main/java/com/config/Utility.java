package com.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	/**
	 * This method will open Object Repository Properties and return value associate with key
	 * 
	 * @param key
	 * @return value in form of{@code String}
	 * @author Sujit Kolhe
	 */
	public static String getProperty(String key,String filepath) {
		String value = null;
		FileInputStream fis;
		try {
			fis=new FileInputStream(filepath);
			Properties prop= new Properties();
			prop.load(fis);
			value =prop.getProperty(key);
		} catch (IOException e) {
			System.out.println("Unable to load Properties File");
			e.printStackTrace();
		}
		return value;
	}
	
	/*
	 * This method captures screenshot with Current Date formats for the viewport using TakesScreenshot interface
	 * and returns the Image
	 * 
	 * @Param:Accepts parameter the file-format in which we need the output Image
	 * 
	 * @Param:Accepts parameter as the location in which we want to save the
	 * screenshot taken
	 * 
	 * @author Sujit Kolhe
	 */
	public static String captureScreenshot(WebDriver driver,String fileName) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		DateFormat dateTimeFormat= new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
		Date currentDate= new Date();
		String ScrrenshotPath= System.getProperty("user.dir")+"/Screenshot/"+fileName+" "+dateTimeFormat.format(currentDate);
		try {
			FileUtils.copyFile(src, new File (ScrrenshotPath));
		} catch (IOException e) {
			System.out.println("Screenshot result failed" + e.getMessage());
			e.printStackTrace();
		}
		return ScrrenshotPath;
	}
}
