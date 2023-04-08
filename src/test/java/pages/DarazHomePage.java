package pages;

import org.openqa.selenium.By;

public class DarazHomePage extends BasePage{
	public String HOMEPAGE_URL = "https://www.daraz.com.bd";
	public By SIGNUP_LOGIN_BUTTON = By.xpath("//a[contains(text(),'Signup / Login')]");
	public By CUSTOMER_CARE_BUTTON = By.xpath("//span[text()='CUSTOMER CARE']");
	public By HELP_CENTER_BUTTON = By.xpath("//a[text()='Help Center']");
	public By payment = By.xpath("//h3[normalize-space()='Payment Methods']");
	public By customerCare = By.xpath("//h3[normalize-space()='Customer Care']");
}
