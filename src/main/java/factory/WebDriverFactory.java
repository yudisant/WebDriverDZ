package factory;

import data.BrowserName;
import data.Mode;
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

public class WebDriverFactory {

    private final String browser = System.getProperty("browser");

    public WebDriver getDriver(Mode mode) {

        WebDriver driver;

        BrowserName typeBrowser = BrowserName.valueOf(browser.toUpperCase());

        if (typeBrowser == BrowserName.CHROME) {
            driver = new ChromeDriver((ChromeOptions) new ChromeSettings().setting(mode.getArgument()));
        } else if (typeBrowser == BrowserName.EDGE) {
            driver = new EdgeDriver((EdgeOptions) new EdgeSettings().setting(mode.getArgument()));
        } else if (typeBrowser == BrowserName.FIREFOX) {
            driver = new FirefoxDriver((FirefoxOptions) new FirefoxSettings().setting(mode.getArgument()));
        } else {
            throw new BrowserNotFoundExceptions(browser);
        }
        return driver;
    }

    public WebDriver getDriver() {

        WebDriver driver;

        BrowserName typeBrowser = BrowserName.valueOf(browser.toUpperCase());

        if (typeBrowser == BrowserName.CHROME) {
            driver = new ChromeDriver();
        } else if (typeBrowser == BrowserName.EDGE) {
            driver = new EdgeDriver();
        } else if (typeBrowser == BrowserName.FIREFOX) {
            driver = new FirefoxDriver();
        } else {
            throw new BrowserNotFoundExceptions(browser);
        }
        return driver;
    }
}