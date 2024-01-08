package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SendMessagePage {
    private SelenideElement phoneNumberTitle = $(byXpath("//div[@data-qa-type=\"uikit/sectionTitle\"]"));

    public SendMessagePage checkPhoneNumberForMessage(String phoneNumber) {
        String phoneNumberProcessed = String.format(
                "+7 (910) %s-%s-%s",
                phoneNumber.substring(3, 6),
                phoneNumber.substring(6, 8),
                phoneNumber.substring(8)
        );
        phoneNumberTitle.shouldHave(Condition.text(phoneNumberProcessed));
        return this;
    }
}
