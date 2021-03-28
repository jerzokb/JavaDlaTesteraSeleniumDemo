package tests;

import Enums.MessageSubject;
import model.Message;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactUsFormPage;
import pages.TopMenuPage;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactUsTest extends BaseTest{

    private TopMenuPage topMenuPage;
    private ContactUsFormPage contactUsFormPage;

    @BeforeEach
    public void setupTest() {

        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topMenuPage = new TopMenuPage(driver);
        contactUsFormPage = new ContactUsFormPage(driver);
    }

    @Test
    public void shouldNotAllowToSendEmptyContactUsForm() {

        // GLOBALNY DLA WSZYSTKICH ELEMENTÓW
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        topMenuPage.clickOnContactUsLink();
        contactUsFormPage.clickSendButton();

        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // WebElement redAlertBox = driver.findElement(By.className("alert-danger"));

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.visibilityOf(redAlertBox));

        Assertions.assertThat(contactUsFormPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    public void shouldNotAllowToSendContactUsFormWithEmailOnly() {
        topMenuPage.clickOnContactUsLink();

        contactUsFormPage.enterEmial("JerzyNowak@dayrep.com");

        contactUsFormPage.clickSendButton();

        // WebElement redAlertBox = driver.findElement(By.className("alert-danger"));

        Assertions.assertThat(contactUsFormPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    public void shouldSendContactUsFormWithValidData() {
        topMenuPage.clickOnContactUsLink();
        Message message = new Message();
        message.setSubject(MessageSubject.WEBMASTER);
        message.setEmail("JerzyNowak@dayrep.com");
        message.setOrderReference("ORDER123");
        message.setMessage("A message for you");
        contactUsFormPage.sendContactUsForm(message);

        Assertions.assertThat(contactUsFormPage.isGreenAlertBoxDisplayed()).isTrue();
    }
}
