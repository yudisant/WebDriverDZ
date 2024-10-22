package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class TrainingPage extends AbsBasePage {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(TrainingPage.class);

    public TrainingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "openModalBtn")
    private WebElement openModalBtn;

    @FindBy(id = "closeModal")
    private WebElement closeModal;

    @FindBy(id = "textInput")
    private WebElement textInput;

    @FindBy(id = "messageBox")
    private WebElement checkForm;

    @FindBy(css = "[type='submit']")
    private WebElement sendBtnForm;

    @FindBy(id = "myModal")
    private WebElement modalWindow;

    public void inputName(String name) {
        inputName.sendKeys(name);
        logger.info("Enter name");
    }

    public void inputEmail(String email) {
        inputEmail.sendKeys(email);
        logger.info("Enter email");
    }

    public void clickSendBtn() {
        sendBtnForm.click();
        logger.info("Pressing the send button");
    }

    public void inputText(String text) {
        textInput.sendKeys(text);
        logger.info("Entering text into a field");
    }

    public void checkTextInput(String expectedText) {
        Assertions.assertEquals(expectedText, textInput.getAttribute("value"),"Error");
        logger.info("Text compliance check");
    }

    public void checkForm(String expectedText) {
        Assertions.assertEquals(expectedText, checkForm.getText(),"Error");
        logger.info("checking the entered name and email");
    }

    public void isOpenModalWindow() {;
        if(isElementReady(openModalBtn) == true) {
            modalWindow.getText();
        } else {
            openModalBtn.click();
        }
        logger.info("Check for opening a modal window");
    }

    public void closeModal() {
        closeModal.click();
    }

    private boolean isElementReady(WebElement element) {
        try {
            return  element.isEnabled() && element.isDisplayed();
        } catch(NoSuchElementException ex) {
            return false;
        }
    }


}
