import data.Mode;
import factory.WebDriverFactory;
import factory.WebDriverManagerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.TrainingPage;

public class OpenFullScreen {
    private static WebDriverManager webDriverManager;
    private WebDriver driver;
    private TrainingPage trainingPage = new TrainingPage(driver);

    @BeforeAll
    public static void init() {
        webDriverManager = new WebDriverManagerFactory().setDriverManager();

    }

    @BeforeEach
    public void setDriver() {
        driver = new WebDriverFactory().getDriver(Mode.FULLSCREEN);
    }

    @BeforeEach
    public void close() {
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void authorization() {
        trainingPage.open("/training.html");
        trainingPage.inputName("фыв");
        trainingPage.inputEmail("asdf@sdfg.rt");
        trainingPage.clickSendBtn();
        trainingPage.checkForm("Форма отправлена с именем: фыв и email: asdf@sdfg.rt");
    }

}
