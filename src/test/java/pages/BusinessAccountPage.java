package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BusinessAccountPage {
    private static final String URI_BUSINESS = "/business/";
    private static final SelenideElement
            OPEN_BUSINESS_ACCOUNT_BUTTON = $(
            byXpath(
                    "//h4[@data-test=\"htmlTag button\"]//button[@data-qa-type=\"uikit/button\"]"
                    )
            ),
            INPUT_PHONE_CONTAINER = $(byXpath("//div[@data-qa-type=\"uikit/inputPhone.inputBox.inputContainer\"]")),
            INPUT_PHONE_FIELD = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputPhone.inputBox.inputContainer\"]" +
                                    "//input[@data-qa-type=\"uikit/inputPhone.value.input\"]"
                    )
            ),
            SUBMIT_BUTTON = $(byXpath("//div[@data-field-name=\"goForward\"]//button[@data-qa-type=\"uikit/button\"]")),
            COMPANY_NAME_FIELD = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputAutocomplete.inputBox.inputContainer\"]" +
                                    "//input[@name=\"companyName\"]"
                    )
            ),
            INPUT_INN_CONTAINER = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputAutocomplete.inputBox.inputContainer\"]"
                    )
            ),
            INPUT_INN_FIELD = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputAutocomplete.inputBox.inputContainer\"]" +
                                    "//input[@inputmode=\"numeric\"]"
                    )
            ),
            INPUT_FIO_CONTAINER = $(byXpath("//div[@data-qa-type=\"uikit/inputFio\"]")),
            INPUT_FIO_FIELD = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputFio\"]//input[@data-qa-type=\"uikit/inputFio.value.input\"]"
                    )
            );

    public BusinessAccountPage openBusinessAccountPage() {
        open(URI_BUSINESS);
        return this;
    }

    public BusinessAccountPage clickOpenBusinessAccountButton() {
        OPEN_BUSINESS_ACCOUNT_BUTTON.click();
        return this;
    }

    public BusinessAccountPage fillingFieldPhone(String phoneNumber) {
        INPUT_PHONE_CONTAINER.click();
        INPUT_PHONE_FIELD.setValue(phoneNumber);
        return this;
    }

    public BusinessAccountPage fillingFieldCompanyName(String companyName) {
        COMPANY_NAME_FIELD.setValue(companyName).pressEnter();
        return this;
    }

    public BusinessAccountPage fillingFieldInn(String inn) {
        INPUT_INN_CONTAINER.click();
        INPUT_INN_FIELD.setValue(inn);
        return this;
    }

    public BusinessAccountPage fillingFieldFio(String fio) {
        INPUT_FIO_CONTAINER.click();
        INPUT_FIO_FIELD.setValue(fio);
        return this;
    }

    public BusinessAccountPage clickSubmitButton() {
        SUBMIT_BUTTON.click();
        return this;
    }
}
