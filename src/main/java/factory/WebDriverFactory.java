package factory;

import data.BrowserName;
import data.TypeWindow;
import factory.browserOptions.ChromeSettings;
import factory.browserOptions.EdgeSettings;
import factory.browserOptions.FirefoxSettings;
import exeptions.BrowserNotFoundExceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class WebDriverFactory {

    private final String browser = System.getProperty("browser");

    public WebDriver getDriver(String argument) {

        WebDriver driver;

        BrowserName typeBrowser = BrowserName.valueOf(browser.toUpperCase());

        if (typeBrowser == BrowserName.CHROME) {
            driver = new ChromeDriver((ChromeOptions) new ChromeSettings().setting(argument));
        } else if (typeBrowser == BrowserName.EDGE) {
            driver = new EdgeDriver((EdgeOptions) new EdgeSettings().setting(argument));
        } else if (typeBrowser == BrowserName.FIREFOX) {
            driver = new FirefoxDriver((FirefoxOptions) new FirefoxSettings().setting(argument));
        } else {
            throw new BrowserNotFoundExceptions(browser);
        }
        return driver;
    }
}