package factory.browserOptions;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class EdgeSettings implements IBrowserSettings {
    @Override
    public AbstractDriverOptions setting(String argument) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(argument);

        return edgeOptions;
    }
}
