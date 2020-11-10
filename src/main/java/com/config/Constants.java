package com.config;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.pageobject.LivingPage;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Constants {
 public static WebDriver driver;
 public static WebElement element;
 public static Actions action;
 public static AShot ashot; 
 public static Screenshot sc;
 public static BufferedImage image;
 public static Logger logger;
 public static Object obj;
 public static JSONObject jsonObj;
 public static JSONArray jsonArray;
 public static Iterator itr;
 public static String expexted;
 public static ArrayList expectedList;
 public static String actual;
 public static ExtentTest test;
 public static ExtentReports extent;
 public static LivingPage livingPage;
}
