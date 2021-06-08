package com.hydroottawa.ccbupgrade.poc.utils;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CCBUpgradeLib {

	/**
	 * Function to select item from Search By option
	 * 
	 * @param searchitem
	 * @param searchpage
	 * @throws InterruptedException
	 */
    public static String MR_STAGE_UP_ID = null;
	public static void CC_SearchBySelection(String searchitem, String searchpage) throws InterruptedException

	{
		// CommonFunctions.driver.switchTo().frame("tabPage");
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='multiQueryZoneFilters1']")));
		WebElement searchBY = CommonFunctions.driver.findElement(By.xpath("//*[@id='multiQueryZoneFilters1']"));
		// WebDriverWait wait = new WebDriverWait(CommonFunctions.driver,50);
		// wait.until(ExpectedConditions.elementToBeSelected(searchBY));
		switch (searchpage) {
		case "Control Central":
			Select items = new Select(searchBY);
			items.selectByVisibleText(searchitem);
			break;
		default:
			System.out.println("Nothing is selected under" + searchpage);
		}
		//Thread.sleep(2000);
	}

	public static void CC_SearchOperation(String searchValue, String searchpage) {

		System.out.println("The value of serach is " + searchValue);
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='Search']")));
		CommonFunctions.driver.findElement(By.xpath("//*[@id='accountId1']")).sendKeys(searchValue);
		CommonFunctions.driver.findElement(By.xpath("//*[@value='Search']")).click();

	}

	public static void menuNavigation(String pageName, String navigation, int row) throws InterruptedException {
		switch (row) {
		case 0:
			CommonFunctions.driver.findElement(By.xpath("//*[text()='" + navigation + "']")).click();
			Thread.sleep(1000);
			break;
		case 1:
			CommonFunctions.driver.findElement(By.xpath("//*[text()='" + navigation + "']")).click();
			Thread.sleep(1000);
			break;
		case 2:
			CommonFunctions.driver.findElement(By.xpath("//*[text()='" + navigation + "']")).click();
			Thread.sleep(1000);
			break;
		case 3:
			CommonFunctions.driver.findElement(By.xpath("//*[text()='" + navigation + "']")).click();
			//Thread.sleep(2000);
			break;
		default:
			System.out.println("Check feature file. Might be navigation is not mentioned");

		}
	}

	public static void MR_Upload_Staging(String page, String field_name, String field_value) throws InterruptedException

	{

		if (page.equalsIgnoreCase("MR Upload Staging")) {
			switch (field_name) {
			case "BADGE NUMBER": {
				WebDriverWait wait = new WebDriverWait(CommonFunctions.driver,50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='BADGE_NBR']")));
				CommonFunctions.driver.findElement(By.xpath("//input[@id='BADGE_NBR']")).sendKeys(field_value);
				break;
			}
			case "DATE": {
				CommonFunctions.driver.findElement(By.xpath("//input[@id='READ_DTTM_FWDTTM_P1']")).clear();
				CommonFunctions.driver.findElement(By.xpath("//input[@id='READ_DTTM_FWDTTM_P1']"))
						.sendKeys(field_value);
				break;
			}
			case "TIME": {
				CommonFunctions.driver.findElement(By.xpath("//input[@id='READ_DTTM_FWDTTM_P2']")).clear();
				CommonFunctions.driver.findElement(By.xpath("//input[@id='READ_DTTM_FWDTTM_P2']"))
						.sendKeys(field_value);
				break;			
			}
			case "MR SOURCE": {
				
				WebElement MR_SOURCE= CommonFunctions.driver.findElement(By.xpath("//Select[@id='MR_SOURCE_CD']"));
				Select S1 = new Select(MR_SOURCE);
				S1.selectByVisibleText(field_value);				
				break;
			}
			default:
				Assert.fail("Required field " + field_name + " is not available in feature file");
			}
		} else if (page.equalsIgnoreCase("Batch Job Submission")) {
			switch (field_name) {
			case "BATCH CODE": {
				CommonFunctions.driver.findElement(By.xpath("//input[@id='BATCH_CD']")).sendKeys(field_value);
				CommonFunctions.driver.findElement(By.xpath("//input[@id='BATCH_CD']")).sendKeys(Keys.TAB);
				//Thread.sleep(2000);
				WebDriverWait wait = new WebDriverWait(CommonFunctions.driver,50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BATCH_DESCR']")));
				boolean flag= CommonFunctions.driver.findElement(By.xpath("//*[@id='BATCH_DESCR']")).isDisplayed();
				Assert.assertEquals("Batch Code description is missing under Batch Job Submission page ", true, flag);
				break;
			}
			default:
				Assert.fail("Required field " + field_name + " is not available in feature file");
			}
		}
	}
	
public static int MeterReadHeader(String colheader)

{
	//int colcount= CommonFunctions.driver.findElements(By.xpath("//table[@id='headerTable']/thead//th")).size();
	int tableHeaderIndex, HeaderNameIndex = 0;
	List<WebElement> HeaderValues = CommonFunctions.driver.findElements(By.xpath("//table[@id='headerTable']/thead//th"));
	for (tableHeaderIndex = 0; tableHeaderIndex < HeaderValues.size(); tableHeaderIndex++) 
	{
		String strHeader = (HeaderValues.get(tableHeaderIndex).getText()).trim();
		if (strHeader.equalsIgnoreCase(colheader)) 
		{
			System.out.println("The value of strHeader " + strHeader);
			break;
		}
	}

	HeaderNameIndex = tableHeaderIndex + 1;
	System.out.println("The "+colheader+" is located at column number " + HeaderNameIndex);
	return HeaderNameIndex;
}
	
	
	
	public static void MeterRead(String sequence, String read_type, String unit_of_measure, String time_of_use,
			String register_reading, int row) {
		int headercol_S = MeterReadHeader("SEQUENCE");
		CommonFunctions.driver
				.findElement(By.xpath("//table[@id='dataTable']//tbody/tr[" + row + "]/td[" + headercol_S + "]//input"))
				.sendKeys(sequence);
		int headercol_RT = MeterReadHeader("READ TYPE");
		Select s1 = new Select(CommonFunctions.driver.findElement(
				By.xpath("//table[@id='dataTable']//tbody/tr[" + row + "]/td[" + headercol_RT + "]//Select")));
		s1.selectByVisibleText(read_type);
		int headercol_UOM = MeterReadHeader("UNIT OF MEASURE");
		Select s2 = new Select(CommonFunctions.driver.findElement(
				By.xpath("//table[@id='dataTable']//tbody/tr[" + row + "]/td[" + headercol_UOM + "]//Select")));
		s2.selectByVisibleText(unit_of_measure);
		int headercol_TOU = MeterReadHeader("TIME OF USE");
		Select s3 = new Select(CommonFunctions.driver.findElement(
				By.xpath("//table[@id='dataTable']//tbody/tr[" + row + "]/td[" + headercol_TOU + "]//Select")));
		s3.selectByVisibleText(time_of_use);
		int headercol_RR = MeterReadHeader("REGISTER READING");
		CommonFunctions.driver
				.findElement(
						By.xpath("//table[@id='dataTable']//tbody/tr[" + row + "]/td[" + headercol_RR + "]//input"))
				.sendKeys(register_reading);

	}

	public static void clickButton_fmenu(String button, String page) throws InterruptedException {
		CommonFunctions.driver.findElement(By.xpath("//input[@name='" + button + "']")).click();
		Thread.sleep(4000);
		if (page.equalsIgnoreCase("MR Upload Staging")) {
			CommonFunctions.driver.switchTo().frame("tabPage");
			MR_STAGE_UP_ID = CommonFunctions.driver.findElement(By.xpath("//input[@id='MR_STAGE_UP_ID']")).getAttribute("value");
			System.out.println("The value of MR Upload Starging ID is :: " + MR_STAGE_UP_ID);
			CommonFunctions.driver.switchTo().parentFrame();
		}
		
	}
	
	public static void selectValue_ftabPage(String menu, String option ,String page) throws InterruptedException {
		
		if(page.equalsIgnoreCase("Batch Job Submission"))
		{
			CommonFunctions.driver.findElement(By.xpath("//img[@id='IM_Main_batCtx']")).click();
			Thread.sleep(3000);
			CommonFunctions.driver.switchTo().parentFrame(); // Switching tabPage frame to Main frame.
			String parent = CommonFunctions.driver.getWindowHandle();
			System.out.println("Parent window is :: "+parent);
			CommonFunctions.driver.findElement(By.xpath("//*[text()='"+option+"']")).click();
			Thread.sleep(3000);
			Set<String> windows= CommonFunctions.driver.getWindowHandles();
			for(String s:windows) {
				if(s.equalsIgnoreCase(parent))
				{
					System.out.println("I am in parent window now");
					
				}
				else
				{
					System.out.println("I am in child window now");
					CommonFunctions.driver.switchTo().window(s);
					Thread.sleep(2000);
					//CommonFunctions.driver.close();
					//CommonFunctions.driver.switchTo().window(parent);
					//System.out.println(" I am in parent wondow again");
					
				}
			}
		}
		
		
	}
	
	public static void verifyBatchJobStatus_ftabPage(String label,String value,String page) throws InterruptedException
	{
		String batch_job_status=null;
		batch_job_status=CommonFunctions.driver.findElement(By.xpath("//*[@id='BATCH_JOB_STAT_FLG']")).getText();
		System.out.println("The initial batch job status is :: "+batch_job_status);
		while(!batch_job_status.equalsIgnoreCase(value))
		{
			batch_job_status=CommonFunctions.driver.findElement(By.xpath("//*[@id='BATCH_JOB_STAT_FLG']")).getText();
			System.out.println("The value of batch job status is :: "+batch_job_status);
			CommonFunctions.driver.switchTo().parentFrame();
			CommonFunctions.driver.findElement(By.xpath("//input[@id='IM_REFRESH']")).click();
			Thread.sleep(4000);
			CommonFunctions.driver.switchTo().frame("tabPage");
		}
	}


}
