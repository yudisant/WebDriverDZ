package factory.browserOptions;

import org.openqa.selenium.remote.AbstractDriverOptions;

public interface IBrowserSettings {

    AbstractDriverOptions setting(String argument);
}
