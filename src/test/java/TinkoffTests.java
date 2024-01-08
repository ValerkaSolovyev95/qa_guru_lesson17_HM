import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BusinessAccountPage;
import pages.CareerPage;
import pages.DebitCardPage;
import pages.DepositPage;
import pages.MainPage;
import pages.SendMessagePage;

import static io.qameta.allure.Allure.step;

@Tag("tinkoff_test")
public class TinkoffTests extends BaseTest {
    private MainPage mainPage = new MainPage();
    private DebitCardPage debitCardPage = new DebitCardPage();
    private CareerPage careerPage = new CareerPage();
    private DepositPage depositPage = new DepositPage();
    private BusinessAccountPage businessAccountPage = new BusinessAccountPage();
    private SendMessagePage sendMessagePage = new SendMessagePage();

    @Test
    void shouldBeSendMessageWhenOrderedDebitCardTest() {
        step("Open card page", () -> debitCardPage.openDebitCardPage());
        step("Click order card button", () -> debitCardPage.clickOrderCardButton());
        step("Choice card design", () -> debitCardPage.choiceCardDesign());
        step("Choice cashback category", () -> debitCardPage.choiceCashBackCategory());
        step("Filling field fio", () -> debitCardPage.fillingFieldFio(TestData.fio));
        step("Filling field phone", () -> debitCardPage.fillingFieldPhone(TestData.phoneNumber));
        step("Filling field email", () -> debitCardPage.fillingFieldEmail(TestData.email));
        step("Filling field birthday", () -> debitCardPage.fillingFieldBirthday(TestData.birthdate));
        step("Click submit button", () -> debitCardPage.clickSubmitButton());
        step("Check phone number", () -> sendMessagePage.checkPhoneNumberForMessage(TestData.phoneNumber));
    }

    @Test
    void checkMainMenuTitlesTest() {
        step("Open main page", () -> mainPage.openMainPage());
        step("Check main page article", () -> mainPage.checkMainPageArticle());
    }

    @Test
    void shouldBeSendMessageWhenOpenDepositTest() {
        step("Open deposit page", () -> depositPage.openDepositPage());
        step("Click open deposit button", () -> depositPage.clickOpenDepositButton());
        step("Set minimum deposit sum", () -> depositPage.setMinimumAmount());
        step("Filling field fio", () -> depositPage.fillingFieldFio(TestData.fio));
        step("Field field phone", () -> depositPage.fillingFieldPhone(TestData.phoneNumber));
        step("Filling field birthday", () -> depositPage.fillingFieldBirthday(TestData.birthdate));
        step("Click submit button", () -> depositPage.clickSubmitButton());
        step("Check phone number", () -> sendMessagePage.checkPhoneNumberForMessage(TestData.phoneNumber));
    }

    @Test
    void shouldBeSendMessageWhenOpenBusinessAccountTest() {
        step("Open business account page", () -> businessAccountPage.openBusinessAccountPage());
        step("Click button open business account", () -> businessAccountPage.clickOpenBusinessAccountButton());
        step("Filling field phone", () -> businessAccountPage.fillingFieldPhone(TestData.phoneNumber));
        step("Filling field company name", () -> businessAccountPage.fillingFieldCompanyName(TestData.companyName));
        step("Filling field inn", () -> businessAccountPage.fillingFieldInn(TestData.DEFAULT_INN));
        step("Filling field fio", () -> businessAccountPage.fillingFieldFio(TestData.fio));
        step("Click submit button", () -> businessAccountPage.clickSubmitButton());
        step("Check phone number", () -> sendMessagePage.checkPhoneNumberForMessage(TestData.phoneNumber));
    }

    @Test
    void checkCareerTitlesTest() {
        step("Open career page", () -> careerPage.openCareerPage());
        step("Check career article", () -> careerPage.checkCareerArticlePage());
    }
}
