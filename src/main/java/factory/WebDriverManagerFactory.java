package factory;

import data.BrowserName;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerFactory {

    private final String browser = System.getProperty("browser");

    WebDriverManager driverManager;

    public WebDriverManager setDriverManager() {

        BrowserName browserName = BrowserName.valueOf(browser.toUpperCase());

        if(browserName == BrowserName.CHROME) {
            WebDriverManager.chromedriver().setup();
        } else if(browserName == BrowserName.EDGE) {
            WebDriverManager.edgedriver().setup();
        } else if(browserName == BrowserName.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
        } else {
            driverManager = null;
        }
        return driverManager;
    }
}
