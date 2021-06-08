package com.hydroottawa.ccbupgrade.poc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CommonFunctions {
	
	public static String glbpath = null;
	
	public static WebDriver driver;
	
	public static String screenshotfilename;
	/**
	 * Function to take the snapshot
	 * @param driver
	 * @param snapshotName
	 * @return
	 */
	
	public static String getSnapshotBase64(WebDriver driver, String snapshotName) {
		String timeStamp =null;
		FileInputStream fileInputStreamReader = null;
		String encodedBase64 = null;
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			String dir = System.getProperty("user.dir");
			glbpath = dir + "\\Screenshots\\";
			File dst = new File(glbpath +snapshotName + "_" + timeStamp + ".png");
			FileUtils.copyFile(src, dst);
			fileInputStreamReader = new FileInputStream(dst);
			byte[] bytes = new byte[(int)dst.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));						
		} catch (Exception e) {

			e.getMessage();
		}
	//return (snapshotName + "_" + timeStamp + ".png");
		return "data:image/png;base64,"+encodedBase64;
	}
	
	/**
	 * Function for open new browser.
	 * @param browserName
	 */
	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver_V16.exe");			
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver_v2.37.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer_v3.4.0_win32.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize(); // Maximize window
	}
	
	/**
	 * Function to navigate to the URL
	 * 
	 * @param Environment
	 *            - environment name e.g. dev1 / dev3
	 */
	public static void openCCBURL(String Environment) {
		try {
			if (Environment.equalsIgnoreCase("dev")) {
				driver.get("http://10.166.188.149:6600/ouaf");
			} else if (Environment.equalsIgnoreCase("QA")) {
				driver.get("http://10.166.188.149:6600/ouaf");
				Thread.sleep(5000);
			} else {
				System.out.println("Mentioned enviroment is not yet defined");
			}
		} catch (Exception e) {
			System.out.println("Mentioned environment is not yet defined");
			e.getMessage();
		}
	}
	
	/**
	 * Gets the system environment value for Environment name
	 * @param env
	 * @return
	 */

	public static String EnvironmentUtility (String env)
	{
		String ENV_KEY = "Environment_Name";
		String ENV_NAME = System.getenv(ENV_KEY);
		System.out.println("The value of ENV_Name is " +ENV_NAME);
		String ENV_KEY_REPLACEMENT_WORD = "%ENV%";			
		return env.replace(ENV_KEY_REPLACEMENT_WORD, ENV_NAME);
		
	}
	
	/**
	 * Function to login in the CCB 2.7 
	 * 
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	public static void login(String username, String password) throws Exception

	{
		
		
		  //ConfigReader configobj = new ConfigReader();
		  //driver.findElement(By.xpath("//input[@id='userId']")).sendKeys(configobj. getUsername(username));
		  //System.out.println("Username :: "+ configobj.getUsername(username));
		  //driver.findElement(By.xpath("//input[@id='password']")).clear();
		  //System.out.println("Password :: "+configobj.getPassword(password));
		 
		 // driver.findElement(By.xpath("//input[@id='password']")).sendKeys(configobj.getPassword(password)); 
		  
		  //System.out.println("Password :: "+configobj.getPassword(password));
		//  Thread.sleep(10000);
		 // driver.findElement(By.xpath("//input[@id='loginButton']")).click();
		 // Thread.sleep(10000); //CCBPageValidation();
		 	
		driver.findElement(By.xpath("//input[@id='userId']")).sendKeys("IGNITE1");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("IgIBM123#");
		driver.findElement(By.xpath("//input[@id='loginButton']")).click();
		//Thread.sleep(15000);
		//driver.switchTo().frame("main");
		
	}
	
	public static void CCBPageValidation(String Title)
	{
		
		
		//driver.switchTo().frame("topMenu");
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ptitle']")));		
		String PageTitle = driver.findElement(By.xpath("//*[@id='ptitle']")).getText();
		System.out.println("Page Title is :: "+PageTitle);
		Assert.assertEquals("Page Title did not match ",Title,PageTitle);
		
		
		
	}
	
	

}
