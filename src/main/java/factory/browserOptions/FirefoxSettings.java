package factory.browserOptions;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class FirefoxSettings implements IBrowserSettings {

    @Override
    public AbstractDriverOptions setting(String argument) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(argument);

        return firefoxOptions;
    }
}
