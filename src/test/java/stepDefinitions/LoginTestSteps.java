package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import java.sql.DriverManager;

public class LoginTestSteps {
    private final WebDriver driver = DriverManager.getDriver();
    private final LoginPage loginPage = new LoginPage(driver);

    public LoginTestSteps(DriverManager hooks) {
    }

    @Given("User is on the login page")
    public void user_is_on_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When ("User enters valid username and password")
    public void user_enters_valid_credentials() {
        loginPage.login("tom smith", "SuperSecretPassword!");
    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_credentials() {
        loginPage.login("wrongUser", "wrongPass");
    }

    @And("User clicks on the login button")
    public void user_clicks_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User should be redirected to the secure area")
    public void user_redirected_to_secure_area() {
        Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
    }

    @Then("User should see a logout button")
    public void user_sees_logout_button() {
        Assert.assertTrue(loginPage.isLogoutButtonDisplayed());
    }

    @Then("User should see an error message")
    public void user_sees_error_message() {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }
}
