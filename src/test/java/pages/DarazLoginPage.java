package pages;

import org.openqa.selenium.By;

public class DarazLoginPage extends BasePage{
	public String LOGINPAGE_URL = "https://member.daraz.com.bd/user/login";
	public By PHONE_EMAIL_INPUT_FIELD = By.xpath("//input[@placeholder='Please enter your Phone Number or Email']");
	public By PASSWORD_INPUT_FIELD = By.xpath("//input[@placeholder='Please enter your password']");
	public By LOGIN_BUTTON = By.xpath("//button[normalize-space()='LOGIN']");
	public By ERROR_MESSAGE = By.xpath("//div[@class='next-feedback-content']");

	
	public void doLogin(String username, String password) {
		writeText(PHONE_EMAIL_INPUT_FIELD, username);
		writeText(PASSWORD_INPUT_FIELD, password);
		clickOnElement(LOGIN_BUTTON);
	}
}
