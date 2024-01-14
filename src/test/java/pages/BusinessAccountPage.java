package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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

    @Step("Open business account page")
    public BusinessAccountPage openBusinessAccountPage() {
        open(URI_BUSINESS);
        return this;
    }

    @Step("Click button open business account")
    public BusinessAccountPage clickOpenBusinessAccountButton() {
        openBusinessAccountButton.click();
        return this;
    }

    @Step("Filling field phone")
    public BusinessAccountPage fillingFieldPhone(String phoneNumber) {
        inputPhoneContainer.click();
        inputPhoneField.setValue(phoneNumber);
        return this;
    }

    @Step("Filling field company name")
    public BusinessAccountPage fillingFieldCompanyName(String companyName) {
        companyNameField.setValue(companyName).pressEnter();
        return this;
    }

    @Step("Filling field inn")
    public BusinessAccountPage fillingFieldInn(String inn) {
        inputInnContainer.click();
        inputInnField.setValue(inn);
        return this;
    }

    @Step("Filling field fio")
    public BusinessAccountPage fillingFieldFio(String fio) {
        inputFioContainer.click();
        inputFioField.setValue(fio);
        return this;
    }

    @Step("Click submit button")
    public BusinessAccountPage clickSubmitButton() {
        submitButton.click();
        return this;
    }
}
