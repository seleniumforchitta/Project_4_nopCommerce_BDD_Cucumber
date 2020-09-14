/*
 * This class is created to save commons things like 
 * creating automatic emails.
 * 
 * Driver declaraions. 
 * 
 * 
 * 
 */
package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addcust;

	// create for generating random String for unique email
	public static String randomString() {
		String generatedstring1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedstring1);

	}

}
