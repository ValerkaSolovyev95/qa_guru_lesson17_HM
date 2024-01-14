package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Tag("card_tests")
@Owner("va.solovev")
@Feature("Cards")
public class CardTests extends BaseTest {

    @Test
    @Severity(CRITICAL)
    @DisplayName("Проверка отправки сообщения, при открытии карты")
    void shouldBeSendMessageWhenOrderedDebitCardTest() {
        debitCardPage.openDebitCardPage();
        debitCardPage.clickOrderCardButton();
        debitCardPage.choiceCardDesign();
        debitCardPage.choiceCashBackCategory();
        debitCardPage.fillingFieldFio(testData.fio);
        debitCardPage.fillingFieldPhone(testData.phoneNumber);
        debitCardPage.fillingFieldEmail(testData.email);
        debitCardPage.fillingFieldBirthday(testData.birthdate);
        debitCardPage.clickSubmitButton();
        sendMessagePage.checkPhoneNumberForMessage(testData.phoneNumber);
    }
}
