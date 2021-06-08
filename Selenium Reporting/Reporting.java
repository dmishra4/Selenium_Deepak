package testng.reports;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;


//import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver; 

public class Reporting {
	
	String screentshotPath ;
	File scrFile;
	private static ExtentReports extent;
	String ScreenshotLocation;
	
	public ExtentReports initialize(ExtentTest test,Reporting report,String scenarioName)
	{
		//Check if reports folder exists or else create
		File directory = new File(System.getProperty("user.dir")+"\\"+"Reports");
	    if (! directory.exists()){
	        directory.mkdir();
	    }
	    //Check if screenshots folder within reports folder exists or else create
  		File directorySS = new File(System.getProperty("user.dir")+"\\"+"Reports\\screenshots");
  	    if (! directorySS.exists()){
  	        directorySS.mkdir();
  	    }
	  	    
		extent = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\"+scenarioName+"_"+GetDateTime() +".html", true);
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\"+"extent-config.xml"));
		return extent;
	}
	
	public void endTest(ExtentTest test)
	{
		extent.endTest(test);
		extent.flush();
	}
	
	public void ReportPasswithscreenshot(ExtentTest test, String StepName,String ScreenShotname) throws Exception
	{
		screentshotPath= ScreenShotname+GetDateTime()+".png";
		takeScreenShot(screentshotPath);
		Reporter.log(StepName, true);
		test.log(LogStatus.PASS,StepName,test.addScreenCapture(screentshotPath.replace(System.getProperty("user.dir"), "..")));
	}
	
	public void ReportPassEmbedDocument(ExtentTest test, String StepName,String DocumentPath) throws Exception
	{
		Reporter.log(StepName, true);
		test.log(LogStatus.PASS, "<a href='file:///"+DocumentPath+"'>Link to the docment</a>");
	}
	
	/*
	 *  Below function without take screen shot attaching the existing screen shot to extend report 
	 *  
	 */
	public void ReportPassAttachScreenshot(ExtentTest test, String StepName,String ScreenShotname) throws Exception
	{
		Reporter.log(StepName, true);
		test.log(LogStatus.PASS,StepName,test.addScreenCapture(ScreenShotname.replace(System.getProperty("user.dir"), "..")));
	}
	/*
	 * Below function without take screen shot attaching the existing screen shot to extend report
	 */
	public void ReportFailAttachScreenshot(ExtentTest test, String StepName,String ScreenShotname) throws Exception
	{
		
		Reporter.log(StepName, false);
		test.log(LogStatus.FAIL,StepName,test.addScreenCapture(ScreenShotname.replace(System.getProperty("user.dir"), "..")));
		//Reporter.
	}
	public void ReportPasswithscreenshotForSap(ExtentTest test, String StepName,String ScreenShotname) throws Exception
	{
		screentshotPath= ScreenShotname+GetDateTime()+".png";
		takeScreenShotRobot(screentshotPath);
		Reporter.log(StepName, true);
		test.log(LogStatus.PASS,StepName,test.addScreenCapture(screentshotPath.replace(System.getProperty("user.dir"), "..")));
	}
	
	public void ReportPass(ExtentTest test, String StepName){
		Reporter.log(StepName, true);
		test.log(LogStatus.PASS, StepName,"");
	}
	
	public void ReportFailwithscreenshot(ExtentTest test, String StepName,String ScreenShotname) throws Exception
	{
		screentshotPath= ScreenShotname+GetDateTime()+".png";
		takeScreenShot(screentshotPath);
		Reporter.log(StepName, false);
		test.log(LogStatus.FAIL,StepName,test.addScreenCapture(screentshotPath.replace(System.getProperty("user.dir"), "..")));
		//Reporter.
	}
	
	public void ReportFailwithscreenshotForSap(ExtentTest test, String StepName,String ScreenShotname) throws Exception
	{
		screentshotPath= ScreenShotname+GetDateTime()+".png";
		takeScreenShotRobot(screentshotPath);
		Reporter.log(StepName, false);
		test.log(LogStatus.FAIL,StepName,test.addScreenCapture(screentshotPath.replace(System.getProperty("user.dir"), "..")));
	}
	
	public void ReportFail(ExtentTest test, String StepName){
		Reporter.log(StepName, false);
		test.log(LogStatus.FAIL, StepName,"");
	}
	
	public void takeScreenShot (String fileName) throws Exception
	{
		Thread.sleep(3000);
	
		scrFile  = ((TakesScreenshot)getWebDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,new File(fileName));
	 
	}
	
	public void takeScreenShotRobot (String fileName) throws Exception
	{
		Robot robot = new Robot();
		BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(screenShot, "JPG", new File(fileName));
	}
	public String GetDateTime ()
	{
		      int day, month, year;
		      int second, minute, hour;
		      GregorianCalendar date = new GregorianCalendar();
		 
		      day = date.get(Calendar.DAY_OF_MONTH);
		      month = date.get(Calendar.MONTH);
		      year = date.get(Calendar.YEAR);
		 
		      second = date.get(Calendar.SECOND);
		      minute = date.get(Calendar.MINUTE);
		      hour = date.get(Calendar.HOUR);
		 return Integer.toString(day)+Integer.toString(month+1)+Integer.toString(year)+Integer.toString(hour)+Integer.toString(minute)+Integer.toString(second);
	}
	
}
	
	
