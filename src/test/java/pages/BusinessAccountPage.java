package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BusinessAccountPage {
    private static final String URI_BUSINESS = "/business/";
    private SelenideElement
            openBusinessAccountButton = $(
            byXpath(
                    "//h4[@data-test=\"htmlTag button\"]//button[@data-qa-type=\"uikit/button\"]"
                    )
            ),
            inputPhoneContainer = $(byXpath("//div[@data-qa-type=\"uikit/inputPhone.inputBox.inputContainer\"]")),
            inputPhoneField = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputPhone.inputBox.inputContainer\"]" +
                                    "//input[@data-qa-type=\"uikit/inputPhone.value.input\"]"
                    )
            ),
            submitButton = $(byXpath("//div[@data-field-name=\"goForward\"]//button[@data-qa-type=\"uikit/button\"]")),
            companyNameField = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputAutocomplete.inputBox.inputContainer\"]" +
                                    "//input[@name=\"companyName\"]"
                    )
            ),
            inputInnContainer = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputAutocomplete.inputBox.inputContainer\"]"
                    )
            ),
            inputInnField = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputAutocomplete.inputBox.inputContainer\"]" +
                                    "//input[@inputmode=\"numeric\"]"
                    )
            ),
            inputFioContainer = $(byXpath("//div[@data-qa-type=\"uikit/inputFio\"]")),
            inputFioField = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputFio\"]//input[@data-qa-type=\"uikit/inputFio.value.input\"]"
                    )
            );

    public BusinessAccountPage openBusinessAccountPage() {
        open(URI_BUSINESS);
        return this;
    }

    public BusinessAccountPage clickOpenBusinessAccountButton() {
        openBusinessAccountButton.click();
        return this;
    }

    public BusinessAccountPage fillingFieldPhone(String phoneNumber) {
        inputPhoneContainer.click();
        inputPhoneField.setValue(phoneNumber);
        return this;
    }

    public BusinessAccountPage fillingFieldCompanyName(String companyName) {
        companyNameField.setValue(companyName).pressEnter();
        return this;
    }

    public BusinessAccountPage fillingFieldInn(String inn) {
        inputInnContainer.click();
        inputInnField.setValue(inn);
        return this;
    }

    public BusinessAccountPage fillingFieldFio(String fio) {
        inputFioContainer.click();
        inputFioField.setValue(fio);
        return this;
    }

    public BusinessAccountPage clickSubmitButton() {
        submitButton.click();
        return this;
    }
}
