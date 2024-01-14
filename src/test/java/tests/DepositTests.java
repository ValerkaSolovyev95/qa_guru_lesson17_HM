package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Tag("deposit_tests")
@Owner("va.solovev")
@Feature("Deposit")
public class DepositTests extends BaseTest{

    @Test
    @Severity(CRITICAL)
    @DisplayName("Проверка отправки сообщения, при открытии депозита")
    void shouldBeSendMessageWhenOpenDepositTest() {
        depositPage.openDepositPage();
        depositPage.clickOpenDepositButton();
        depositPage.setMinimumAmount();
        depositPage.fillingFieldFio(testData.fio);
        depositPage.fillingFieldPhone(testData.phoneNumber);
        depositPage.fillingFieldBirthday(testData.birthdate);
        depositPage.clickSubmitButton();
        sendMessagePage.checkPhoneNumberForMessage(testData.phoneNumber);
    }
}
