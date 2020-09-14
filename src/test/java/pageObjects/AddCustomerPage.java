package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By lnkCustomers_menu = By.xpath("//a[@href='#']/span[contains(text(),'Customers')]");
	By lnkCustomers_menuitem = By.xpath("//span[@class='menu-item-title'][text()='Customers']");

	By btnAddnew = By.xpath("//a[@class='btn bg-blue']");

	By txt_Email = By.xpath("//input[@class='form-control text-box single-line' and @id='Email']");
	By txt_password = By.xpath("//input[@id='Password' and @name='Password']");

	By txt_fname = By.xpath("//input[@id='FirstName']");
	By txt_lname = By.xpath("//input[@id='LastName']");

	By rd_male = By.id("Gender_Male");
	By rd_female = By.id("Gender_Female");

	By Dateof_birth = By.id("DateOfBirth");

	By txt_companyname = By.xpath("//input[@id='Company']");
	By chk_taxexempt = By.id("IsTaxExempt");

	By newsletter = By.xpath("//div[@id='customer-info']/div[2]/div[1]/div[9]/div[2]/div/div[1]/div");
	By yourstore_name = By.xpath("//li[text()='Your store name']");
	By Teststore_2 = By.xpath("//li[text()='Test store 2']");

	By customer_role = By.xpath("//div[@id='customer-info']/div[2]/div[1]/div[10]/div[2]/div/div[1]/div");
	By Administrators_role = By.xpath("//li[text()='Administrators']");
	By ForumModerators_role = By.xpath("//li[text()='Forum Moderators']");
	By Guests_role = By.xpath("//li[text()='Guests']");
	By Registered_role = By.xpath("//li[text()='Registered']");
	By Vendors_role = By.xpath("//li[text()='Vendors']");
	By deleterole = By.xpath("//span[@title='delete']");

	By Manager_vendor = By.xpath("//select[@data-val-required='The Manager of vendor field is required.']");
	By chk_Active = By.id("Active");

	By txt_admincmnt = By.id("AdminComment");
	By txt_Admincomment = By.xpath("//span[@data-valmsg-for='AdminComment']"); // Not Correct

	By save_btn = By.xpath("//button[@name='save']");

	// Implementing all ACTION methods
	
	public String getPageTitle() {
		return ldriver.getTitle();

	}

	public void clickOnCustomerMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}

	public void clickOnCustomerMenuItems() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}

	public void clickOnAddNewBtn() {
		ldriver.findElement(btnAddnew).click();
	}

	public void setMail(String email) {
		ldriver.findElement(txt_Email).sendKeys(email);
	}

	public void setpassword(String password) {
		ldriver.findElement(txt_password).sendKeys(password);
	}

	public void setFname(String fname) {
		ldriver.findElement(txt_fname).sendKeys(fname);
	}

	public void setLname(String lname) {
		ldriver.findElement(txt_lname).sendKeys(lname);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			ldriver.findElement(rd_male).click();
		} else if (gender.equals("Female")) {
			ldriver.findElement(rd_female).click();
		} else {
			ldriver.findElement(rd_male).click(); // default
		}
	}

	public void setDOB(String dob) {
		ldriver.findElement(Dateof_birth).sendKeys(dob);
	}

	public void setCompanyName(String companyname) {
		ldriver.findElement(txt_companyname).sendKeys(companyname);
	}

	public void adminContent(String admincontent) {
		
		ldriver.findElement(txt_admincmnt).sendKeys(admincontent);
	}

	public void clickChkBox() {
		ldriver.findElement(chk_taxexempt).click();
	}
	public void clickonSaveButton() {
		ldriver.findElement(save_btn).click();
	}

	public void customerRole(String customerrole) throws Throwable {
		
		if (!customerrole.equals("Registered")) {
			ldriver.findElement(deleterole).click();
		}
		Thread.sleep(5000);
		WebElement listofrole = null;
		if (customerrole.equals("Administrators")) {
			listofrole = ldriver.findElement(Administrators_role);
		} else if (customerrole.equals("Registered")) {
			listofrole = ldriver.findElement(Registered_role);
		} else if (customerrole.equals("Forum Moderators")) {
			listofrole = ldriver.findElement(ForumModerators_role);
		} else if (customerrole.equals("Vendors")) {
			listofrole = ldriver.findElement(Vendors_role);
		} else if (customerrole.equals("Guests")) {
			listofrole = ldriver.findElement(Guests_role);
		}
		
		//listofrole.click();
		//OR
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listofrole);
	
	}

	public void setManagerOfVendor(String vendorvalue) {
		Select drp = new Select(ldriver.findElement(Manager_vendor));
		drp.selectByVisibleText(vendorvalue);
	}

}
