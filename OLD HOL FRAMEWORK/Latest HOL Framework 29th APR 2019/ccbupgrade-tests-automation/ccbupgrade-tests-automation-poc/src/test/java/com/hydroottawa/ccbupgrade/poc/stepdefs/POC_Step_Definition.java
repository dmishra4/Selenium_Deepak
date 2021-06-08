package com.hydroottawa.ccbupgrade.poc.stepdefs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;
import com.hydroottawa.ccbupgrade.poc.utils.CCBUpgradeLib;
import com.hydroottawa.ccbupgrade.poc.utils.CommonFunctions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class POC_Step_Definition {

	@Given("^Open browser \"([^\"]*)\"$")
	public void open_browser(String browserName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		CommonFunctions.openBrowser(browserName);
		
	   
	}

	@When("^Login to CCB under \"([^\"]*)\" environment with user as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void login_to_CCB_under_environment_with_user_as_and_password_as(String environment, String username, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//CommonFunctions.openCCBURL(CommonFunctions.EnvironmentUtility(environment));
		CommonFunctions.openCCBURL("dev");
		CommonFunctions.screenshotfilename=CommonFunctions.getSnapshotBase64(CommonFunctions.driver, "openCCBURL");
		Reporter.addScreenCaptureFromPath(CommonFunctions.screenshotfilename);
		CommonFunctions.login(username,password);
		CommonFunctions.screenshotfilename=CommonFunctions.getSnapshotBase64(CommonFunctions.driver, "CCBHomePage");
		Reporter.addScreenCaptureFromPath(CommonFunctions.screenshotfilename);
		Thread.sleep(7000);
		CommonFunctions.driver.switchTo().frame("main");
		//Thread.sleep(8000);
	}

	@Then("^Ensure user will be landed to \"([^\"]*)\" after successful login$")
	public void ensure_user_will_be_landed_to_after_successful_login(String Title) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		CommonFunctions.CCBPageValidation(Title);
		CommonFunctions.screenshotfilename=CommonFunctions.getSnapshotBase64(CommonFunctions.driver, "CCBHomePage");
		Reporter.addScreenCaptureFromPath(CommonFunctions.screenshotfilename);
	   
	}

	@When("^Select \"([^\"]*)\" from \"([^\"]*)\" drop down list under \"([^\"]*)\"$")
	public void select_from_drop_down_list_under(String searchitem, String SearchBy, String searchpage) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		CommonFunctions.driver.switchTo().frame("tabPage");
		CCBUpgradeLib.CC_SearchBySelection(searchitem, searchpage);
		CommonFunctions.screenshotfilename=CommonFunctions.getSnapshotBase64(CommonFunctions.driver, "CCBHomePage");
		Reporter.addScreenCaptureFromPath(CommonFunctions.screenshotfilename);
	}

	@When("^Enter \"([^\"]*)\" in the Account ID input field and click on Search button$")
	public void enter_in_the_Account_ID_input_field_and_click_on_Search_button(String searchValue) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		CCBUpgradeLib.CC_SearchOperation(searchValue, "searchpage");
		Thread.sleep(3000);
		boolean flag;
		CommonFunctions.screenshotfilename=CommonFunctions.getSnapshotBase64(CommonFunctions.driver, "CCBHomePage");
		Reporter.addScreenCaptureFromPath(CommonFunctions.screenshotfilename);
		Thread.sleep(3000);
	//	CommonFunctions.driver.switchTo().frame("zoneMapFrame_2"); // Account Information Tab
	//	flag=CommonFunctions.driver.findElement(By.xpath("//img[@title='Show Context Menu - "+searchValue+"']")).isDisplayed();
		flag=CommonFunctions.driver.findElement(By.xpath("//*[@id='analyticsFilterText1']//*[text()='"+searchValue+"']")).isDisplayed();
		Assert.assertTrue(flag);
		System.out.println("Account Validation Done");
		CommonFunctions.screenshotfilename=CommonFunctions.getSnapshotBase64(CommonFunctions.driver, "CCBHomePage");
		Reporter.addScreenCaptureFromPath(CommonFunctions.screenshotfilename);
	//	CommonFunctions.driver.switchTo().parentFrame();//Back to tabPage frame from zoneMapFrame_2 frame
		CommonFunctions.driver.switchTo().parentFrame(); // Moved to main frame from tabPage frame
	}

	@When("^Navigate to below list from top to bottom in order to reach \"([^\"]*)\" page$")
	public void navigate_to_below_list_from_top_to_botton_in_order_to_reach_page(String pageName, List<String> navlist) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// We must be in main frame to use this step definition.
		for(int i=0;i<navlist.size();i++)
		{
			System.out.println(navlist.get(i));
			CCBUpgradeLib.menuNavigation(pageName,navlist.get(i),i);
		}
		
		Thread.sleep(5000);
		CommonFunctions.screenshotfilename=CommonFunctions.getSnapshotBase64(CommonFunctions.driver, "CCBHomePage");
		Reporter.addScreenCaptureFromPath(CommonFunctions.screenshotfilename);
	    
	}

	@When("^Enter below values in \"([^\"]*)\" page$")
	public void enter_below_values_in_page(String page, List<List<String>> listOflists) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		CommonFunctions.driver.switchTo().frame("tabPage");
		for(List<String> listString : listOflists)
		{       
			String field = listString.get(0);
			//System.out.println("The value of field is :: "+field);
			String value = listString.get(1);
			//System.out.println("The value of value is :: "+value);
			CCBUpgradeLib.MR_Upload_Staging(page,field, value);
			}
		Thread.sleep(4000);
		CommonFunctions.screenshotfilename=CommonFunctions.getSnapshotBase64(CommonFunctions.driver, "CCBHomePage");
		Reporter.addScreenCaptureFromPath(CommonFunctions.screenshotfilename);

		}

	

	@When("^Select \"([^\"]*)\" check box$")
	public void select_check_box(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		boolean flag;
		flag=CommonFunctions.driver.findElement(By.xpath("//input[@id='USE_ON_BILL_SW']")).isSelected();
		if (flag!=true)
		{
			CommonFunctions.driver.findElement(By.xpath("//input[@id='USE_ON_BILL_SW']")).click();
		}
		
		CommonFunctions.screenshotfilename=CommonFunctions.getSnapshotBase64(CommonFunctions.driver, "CCBHomePage");
		Reporter.addScreenCaptureFromPath(CommonFunctions.screenshotfilename);
	}

	@When("^Fill the \"([^\"]*)\" as mentioned below ::$")
	public void fill_the_as_mentioned_below(String arg1, List<List<String>> listoflists) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		CommonFunctions.driver.switchTo().frame("dataframe"); // Parent of dataframe is tabpage
		int nooflist = listoflists.size();
		for(int row =1 ;row<nooflist; row++)
		{
			JavascriptExecutor je = (JavascriptExecutor)CommonFunctions.driver;
			WebElement obj= CommonFunctions.driver.findElement(By.xpath("//img[@id='IM_STU:0$RegList_plusBtn']"));
			je.executeScript("arguments[0].scrollIntoView(true);", obj);
			CommonFunctions.driver.findElement(By.xpath("//img[@id='IM_STU:0$RegList_plusBtn']")).click();
		}
		int row=1;
		for (List<String> listStr : listoflists)
		{
			    
				String sequence = listStr.get(0);
				String read_type = listStr.get(1);
				String unit_of_measure = listStr.get(2);
				String time_of_use = listStr.get(3);
				String register_reading= listStr.get(4);
				CCBUpgradeLib.MeterRead(sequence, read_type,unit_of_measure,time_of_use,register_reading,row);
			    row+=1;
		}
		
		
		CommonFunctions.screenshotfilename=CommonFunctions.getSnapshotBase64(CommonFunctions.driver, "CCBHomePage");
		Reporter.addScreenCaptureFromPath(CommonFunctions.screenshotfilename);
		CommonFunctions.driver.switchTo().parentFrame();  //Switch to tabPage as tabPage is parent of dataframe.
		
	    
	}

	@When("^Click on \"([^\"]*)\" button$")
	public void click_on_button(String button) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// We must be in main frame to use this step definition.
	//	CommonFunctions.driver.switchTo().parentFrame(); // Switch to menu frame from tabPage frame..
	//	CCBUpgradeLib.clickButton_fmenu(button);
	//	Thread.sleep(2000);
	//	CommonFunctions.screenshotfilename=CommonFunctions.getSnapshotBase64(CommonFunctions.driver, "CCBHomePage");
	//	Reporter.addScreenCaptureFromPath(CommonFunctions.screenshotfilename);
	    
	}
	
	@When("^Click on \"([^\"]*)\" button in \"([^\"]*)\" page$")
	public void click_on_button_in_page(String button, String page) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		CommonFunctions.driver.switchTo().parentFrame(); // Switch to menu frame from tabPage frame..
		CCBUpgradeLib.clickButton_fmenu(button,page);
		Thread.sleep(2000);
		CommonFunctions.screenshotfilename=CommonFunctions.getSnapshotBase64(CommonFunctions.driver, "CCBHomePage");
		Reporter.addScreenCaptureFromPath(CommonFunctions.screenshotfilename);
		
	}
	
	@Then("^The value of \"([^\"]*)\" is displayed as \"([^\"]*)\" under \"([^\"]*)\" page$")
	public void the_value_of_is_displayed_as_under_page(String label, String value, String page) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		CommonFunctions.driver.switchTo().frame("tabPage"); // Switching main frame to tabPage frame.
		CCBUpgradeLib.verifyBatchJobStatus_ftabPage(label,value,page);
		CommonFunctions.screenshotfilename=CommonFunctions.getSnapshotBase64(CommonFunctions.driver, "CCBHomePage");
		Reporter.addScreenCaptureFromPath(CommonFunctions.screenshotfilename);
	    
	}
	
	@Then("^Click on \"([^\"]*)\" and then select \"([^\"]*)\" in \"([^\"]*)\" page$")
	public void click_on_and_then_select_in_page(String menu, String option, String page) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//CommonFunctions.driver.switchTo().frame("tabPage"); // Switching main frame to tabPage frame.
		CCBUpgradeLib.selectValue_ftabPage(menu, option, page);
		CommonFunctions.screenshotfilename=CommonFunctions.getSnapshotBase64(CommonFunctions.driver, "CCBHomePage");
		Reporter.addScreenCaptureFromPath(CommonFunctions.screenshotfilename);
	    
	}

	@When("^Close the browser$")
	public void close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	
}
