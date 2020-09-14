package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class Steps extends BaseClass {

	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\Drivers\\chromedriver_win32\\chromedriver.exe");						
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		driver.get(url);
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_Login() {
		lp.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {

		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("User click on Log out Link")
	public void user_click_on_Log_out_Link() {
		lp.clickLogout();
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	}

	//Customer feature step definition------------------------------------------
	
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {

		addcust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getPageTitle()); 	
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		addcust.clickOnCustomerMenu();
	}

	@When("click on customers menu item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(2000);
		addcust.clickOnCustomerMenuItems();
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() {
		addcust.clickOnAddNewBtn();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {

		Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getPageTitle()); 	
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws Throwable {
		String email=randomString()+"@gmail.com";
	    addcust.setMail(email);
	    addcust.setpassword("test1234");
	    // Registerd - default
	    // The customer can't be in both 'Guests' and 'Regustered' customer roles
	    addcust.customerRole("Guests");
	    Thread.sleep(5000);
	    
	    
	    addcust.setManagerOfVendor("Vendor 2");
	    addcust.setFname("Chittaranjan");
	    addcust.setLname("Swain");
	    addcust.setGender("Male");
	    addcust.setDOB("07/05/1989");
	    addcust.setCompanyName("QAHub");
	    addcust.adminContent("This is for testing....");
	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {
		addcust.clickonSaveButton();
		Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));
	}

	
}
