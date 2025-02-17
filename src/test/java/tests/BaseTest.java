package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import utils.Logger;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    private static final Logger logger = new Logger();

    @BeforeClass
    public void setup() {
        logger.log("Setting up WebDriver and opening browser...");

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // ბრაუზერის default პარამეტრები
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // გახსნის საწყის URL-ს
        driver.get("https://the-internet.herokuapp.com/login");

        // Page Object-ის ინიციალიზაცია
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void teardown() {
        logger.log("Closing browser...");
        if (driver != null) {
            driver.quit();
        }
    }
}
