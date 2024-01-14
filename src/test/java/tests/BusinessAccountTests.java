package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Tag("business_account_tests")
@Owner("va.solovev")
@Feature("Business account")
public class BusinessAccountTests extends BaseTest{

    @Test
    @Severity(CRITICAL)
    @DisplayName("Проверка отправки сообщения, при открытии счета для малого бизнеса")
    void shouldBeSendMessageWhenOpenBusinessAccountTest() {
        businessAccountPage.openBusinessAccountPage();
        businessAccountPage.clickOpenBusinessAccountButton();
        businessAccountPage.fillingFieldPhone(testData.phoneNumber);
        businessAccountPage.fillingFieldCompanyName(testData.companyName);
        businessAccountPage.fillingFieldInn(testData.DEFAULT_INN);
        businessAccountPage.fillingFieldFio(testData.fio);
        businessAccountPage.clickSubmitButton();
        sendMessagePage.checkPhoneNumberForMessage(testData.phoneNumber);
    }
}
