package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public abstract class AbsCommon {
    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(AbsCommon.class.getName());

    public AbsCommon(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
}
