package pages;

import model.Message;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsFormPage extends BasePage{

    public ContactUsFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submitMessage")
    WebElement semdButton;

    @FindBy(id = "email")
    WebElement emialInput;

    @FindBy(id = "id_contact")
    WebElement subjectElement;

    @FindBy(id = "id_order")
    WebElement orderInput;

    @FindBy(id = "message")
    WebElement messageTextArea;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    WebElement redAlertBox;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    WebElement greenAlertBox;

    public void clickSendButton() {
        semdButton.click();
    }

    public boolean isRedAlertBoxDisplayed() {
        return isAlertBoxDisplayed(redAlertBox);
    }

    public boolean isGreenAlertBoxDisplayed() {
        return isAlertBoxDisplayed(greenAlertBox);
    }

    private boolean isAlertBoxDisplayed(WebElement box) {
        wait.until(ExpectedConditions.visibilityOf(box));

        boolean isDisplayed = false;
        try {
            isDisplayed = box.isDisplayed();
        } catch (NoSuchElementException e) {}
        return isDisplayed;
    }

    public void enterEmial(String email) {

        emialInput.sendKeys(email);
    }

    public void sendContactUsForm(Message message) {
        Select subject = new Select(subjectElement);
        subject.selectByVisibleText(message.getSubject().getValue());
        emialInput.sendKeys(message.getEmail());
        orderInput.sendKeys(message.getOrderReference());
        messageTextArea.sendKeys(message.getMessage());
        this.clickSendButton();
    }
}
