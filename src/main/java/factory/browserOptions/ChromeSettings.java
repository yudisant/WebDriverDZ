package factory.browserOptions;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeSettings implements IBrowserSettings {

    @Override
    public AbstractDriverOptions setting(String argument) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(argument);

        return chromeOptions;
    }
}
