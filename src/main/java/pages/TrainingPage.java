package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrainingPage extends AbsBasePage {

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
    }

    public void inputEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void clickSendBtn() {
        sendBtnForm.click();
    }

//    public void inputNameEmail(String name, String email) {
//        inputName.sendKeys(name);
//        inputEmail.sendKeys(email);
//        sendBtnForm.click();
//    }

    public void inputText(String text) {
        textInput.sendKeys(text);
    }

    public TrainingPage checkTextInput(String expectedText) {
        Assertions.assertEquals(expectedText, textInput.getAttribute("value"),"Error");
        return this;
    }

    public TrainingPage checkForm(String expectedText) {
        Assertions.assertEquals(expectedText, checkForm.getText(),"Error");
        return this;
    }

    public void isOpenModalWindow() {;
        if(isElementReady(openModalBtn) == true) {
            modalWindow.getText();
        } else {
            openModalBtn.click();
        }
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
