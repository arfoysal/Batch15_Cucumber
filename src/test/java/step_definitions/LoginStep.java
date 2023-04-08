package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DarazLoginPage;

import static utilities.BaseDriverSetup.getDriver;

public class LoginStep {
    DarazLoginPage darazLoginPage = new DarazLoginPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        getDriver().get(darazLoginPage.LOGINPAGE_URL);
    }
    @When("User enter username {string}")
    public void user_enter_username(String username) {
        darazLoginPage.writeText(darazLoginPage.PHONE_EMAIL_INPUT_FIELD,username);
    }
    @When("User enter password {string}")
    public void User_enter_password(String password) {
        darazLoginPage.writeText(darazLoginPage.PASSWORD_INPUT_FIELD,password);
    }
    @When("User click on login button")
    public void user_click_on_login_button() {
        darazLoginPage.clickOnElement(darazLoginPage.LOGIN_BUTTON);
    }
    @Then("User see the message {string}")
    public void user_see_the_message(String error_msg) {
       Assert.assertEquals(darazLoginPage.getElement(darazLoginPage.ERROR_MESSAGE).getText(), error_msg);
    }
}
