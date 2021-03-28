package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.*;

public class BaseTest {

    protected static final String BASE_URL = "http://automationpractice.com/index.php";

    protected WebDriver driver; // komunikacja z przeglądarką
    protected WebElement element; // interakcja z elementem na stronie

    // Przed wszystkimi testami
    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    // Po każdym teście
    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
