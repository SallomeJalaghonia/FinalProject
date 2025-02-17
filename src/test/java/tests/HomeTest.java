package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.HomePage;

public class HomeTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        // ვწვდებით loginPage-ს და ავტორიზაციას ვაკეთებთ
        loginPage.login("tom smith", "SuperSecretPassword!");
        Assert.assertTrue(driver.getCurrentUrl().contains("secure"), "Login failed!");
    }

    @Test
    public void testHomePageElements() {
        // შევამოწმოთ, რომ ჰოუმგვერდზე კონკრეტული ელემენტები არსებობს
        Assert.assertTrue(homePage.isLogoutButtonDisplayed(), "Logout button not displayed!");
        Assert.assertTrue(homePage.isSuccessMessageDisplayed(), "Success message not displayed!");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
