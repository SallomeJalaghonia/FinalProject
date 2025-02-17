package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
