package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DepositPage {
    private static final String DEPOSIT_URI = "/savings/deposit/";
    private SelenideElement
            openDepositButton = $(
            byXpath(
                    "//h3[@data-test=\"htmlTag button\"]//button[@data-qa-type=\"uikit/button\"]"
                    )
            ),
            submitButton = $(byXpath("//div[@data-field-name=\"submit\"]")),
            inputBirthdayContainer = $(byXpath("//div[@data-qa-type=\"uikit/input.inputBox.inputContainer\"]")),
            inputBirthdayField = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/input.inputBox.inputContainer\"]" +
                                    "//input[@data-qa-type=\"uikit/input.value.input\"]"
                    )
            ),
            inputPhoneContainer = $(byXpath("//div[@data-qa-type=\"uikit/inputPhone.inputBox.main\"]")),
            inputPhoneField = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputPhone.inputBox.main\"]//" +
                                    "input[@data-qa-type=\"uikit/inputPhone.value.input\"]"
                    )
            ),
            inputFioContainer = $(byXpath("//div[@data-qa-type=\"uikit/inputFio\"]")),
            inputFioField = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputFio\"]//input[@data-qa-type=\"uikit/inputFio.value.input\"]"
                    )
            ),
            inputAmountContainer = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/formGroup.element\"][1]//div[@data-qa-type=\"uikit/inputBox\"]" +
                                    "//div[@data-qa-type=\"uikit/inputBox.main\"]"
                    )
            ),
            inputAmountField = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/formGroup.element\"][1]//div[@data-qa-type=\"uikit/inputBox\"]" +
                                    "//div[@data-qa-type=\"uikit/inputBox.main\"]" +
                                    "//div[@data-qa-type=\"uikit/inputBox.inputContainer\"]" +
                                    "//input[@name=\"deposit_amount\"]"
                    )
            );

    @Step("Open deposit page")
    public DepositPage openDepositPage() {
        open(DEPOSIT_URI);
        return this;
    }

    @Step("Click open deposit button")
    public DepositPage clickOpenDepositButton() {
        openDepositButton.click();
        return this;
    }

    @Step("Set minimum deposit sum")
    public DepositPage setMinimumAmount() {
        inputAmountContainer.click();
        inputAmountField.sendKeys(Keys.CONTROL, "a");
        inputAmountField.sendKeys(Keys.DELETE);
        return this;
    }

    @Step("Filling field fio")
    public DepositPage fillingFieldFio(String fio) {
        inputFioContainer.click();
        inputFioField.setValue(fio);
        return this;
    }

    @Step("Field field phone")
    public DepositPage fillingFieldPhone(String phone) {
        inputPhoneContainer.click();
        inputPhoneField.setValue(phone);
        return this;
    }

    @Step("Filling field birthday")
    public DepositPage fillingFieldBirthday(String birthday) {
        inputBirthdayContainer.click();
        inputBirthdayField.setValue(birthday);
        return this;
    }

    @Step("Click submit button")
    public DepositPage clickSubmitButton() {
        submitButton.click();
        return this;
    }
}
