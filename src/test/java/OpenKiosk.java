import data.Mode;
import factory.WebDriverFactory;
import factory.WebDriverManagerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.TrainingPage;

public class OpenKiosk {
    private static WebDriverManager webDriverManager;
    private WebDriver driver;

    @BeforeAll
    public static void init() {
        webDriverManager = new WebDriverManagerFactory().setDriverManager();
    }

    @BeforeEach
    public void setDriver() {
        driver = new WebDriverFactory().getDriver(Mode.KIOSK);
    }

    @AfterEach
    public void close() {
        driver.close();
        driver.quit();
    }

    @Test
    void openModalWindow() {

        TrainingPage trainingPage = new TrainingPage(driver);

        trainingPage.open("/training.html");
        trainingPage.isOpenModalWindow();
        trainingPage.closeModal();
    }
}
