import data.Mode;
import factory.WebDriverFactory;
import factory.WebDriverManagerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.TrainingPage;

public class OpenHeadless {
    private static WebDriverManager webDriverManager;
    private WebDriver driver;
    private TrainingPage trainingPage = new TrainingPage(driver);

    @BeforeAll
    public static void init() {
        webDriverManager = new WebDriverManagerFactory().setDriverManager();
    }

    @BeforeEach
    public void setDriver() {
        driver = new WebDriverFactory().getDriver(Mode.HEADLESS);
    }

    @AfterEach
    public void close() {
        if(driver != null) {
            driver.quit();
        }
    }

    @Test
    public void checkInputLine() {
        trainingPage.open("/training.html");
        trainingPage.inputText("ОТУС");
        trainingPage.checkTextInput("ОТУС");
    }
}
