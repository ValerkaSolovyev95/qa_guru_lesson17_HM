import org.junit.jupiter.api.Test;
import pages.BusinessAccountPage;
import pages.CareerPage;
import pages.DebitCardPage;
import pages.DepositPage;
import pages.MainPage;
import pages.SendMessagePage;

import static io.qameta.allure.Allure.step;

public class TinkoffTests extends BaseTest {
    private final MainPage MAIN_PAGE = new MainPage();
    private final DebitCardPage DEBIT_CARD_PAGE = new DebitCardPage();
    private final CareerPage CAREER_PAGE = new CareerPage();
    private final DepositPage DEPOSIT_PAGE = new DepositPage();
    private final BusinessAccountPage BUSINESS_ACCOUNT_PAGE = new BusinessAccountPage();
    private final SendMessagePage SEND_MESSAGE_PAGE = new SendMessagePage();

    @Test
    void shouldBeSendMessageWhenOrderedDebitCardTest() {
        step("Open card page", () -> DEBIT_CARD_PAGE.openDebitCardPage());
        step("Click order card button", () -> DEBIT_CARD_PAGE.clickOrderCardButton());
        step("Choice card design", () -> DEBIT_CARD_PAGE.choiceCardDesign());
        step("Choice cashback category", () -> DEBIT_CARD_PAGE.choiceCashBackCategory());
        step("Filling field fio", () -> DEBIT_CARD_PAGE.fillingFieldFio(TestData.fio));
        step("Filling field phone", () -> DEBIT_CARD_PAGE.fillingFieldPhone(TestData.phoneNumber));
        step("Filling field email", () -> DEBIT_CARD_PAGE.fillingFieldEmail(TestData.email));
        step("Filling field birthday", () -> DEBIT_CARD_PAGE.fillingFieldBirthday(TestData.birthdate));
        step("Click submit button", () -> DEBIT_CARD_PAGE.clickSubmitButton());
        step("Check phone number", () -> SEND_MESSAGE_PAGE.checkPhoneNumberForMessage(TestData.phoneNumber));
    }

    @Test
    void checkMainMenuTitlesTest() {
        step("Open main page", () -> MAIN_PAGE.openMainPage());
        step("Check main page article", () -> MAIN_PAGE.checkMainPageArticle());
    }

    @Test
    void shouldBeSendMessageWhenOpenDepositTest() {
        step("Open deposit page", () -> DEPOSIT_PAGE.openDepositPage());
        step("Click open deposit button", () -> DEPOSIT_PAGE.clickOpenDepositButton());
        step("Set minimum deposit sum", () -> DEPOSIT_PAGE.setMinimumAmount());
        step("Filling field fio", () -> DEPOSIT_PAGE.fillingFieldFio(TestData.fio));
        step("Field field phone", () -> DEPOSIT_PAGE.fillingFieldPhone(TestData.phoneNumber));
        step("Filling field birthday", () -> DEPOSIT_PAGE.fillingFieldBirthday(TestData.birthdate));
        step("Click submit button", () -> DEPOSIT_PAGE.clickSubmitButton());
        step("Check phone number", () -> SEND_MESSAGE_PAGE.checkPhoneNumberForMessage(TestData.phoneNumber));
    }

    @Test
    void shouldBeSendMessageWhenOpenBusinessAccountTest() {
        step("Open business account page", () -> BUSINESS_ACCOUNT_PAGE.openBusinessAccountPage());
        step("Click button open business account", () -> BUSINESS_ACCOUNT_PAGE.clickOpenBusinessAccountButton());
        step("Filling field phone", () ->
                BUSINESS_ACCOUNT_PAGE.fillingFieldPhone(TestData.phoneNumber)
        );
        step("Filling field company name", () ->
                BUSINESS_ACCOUNT_PAGE.fillingFieldCompanyName(TestData.companyName)
        );
        step("Filling field inn", () -> BUSINESS_ACCOUNT_PAGE.fillingFieldInn(TestData.DEFAULT_INN));
        step("Filling field fio", () -> BUSINESS_ACCOUNT_PAGE.fillingFieldFio(TestData.fio));
        step("Click submit button", () -> BUSINESS_ACCOUNT_PAGE.clickSubmitButton());
        step("Check phone number", () -> SEND_MESSAGE_PAGE.checkPhoneNumberForMessage(TestData.phoneNumber));
    }

    @Test
    void checkCareerTitlesTest() {
        step("Open career page", () -> CAREER_PAGE.openCareerPage());
        step("Check career article", () -> CAREER_PAGE.checkCareerArticlePage());
    }
}
