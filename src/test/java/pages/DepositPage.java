package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DepositPage {
    private static final String DEPOSIT_URI = "/savings/deposit/";
    private static final SelenideElement
            OPEN_DEPOSIT_BUTTON = $(
            byXpath(
                    "//h3[@data-test=\"htmlTag button\"]//button[@data-qa-type=\"uikit/button\"]"
                    )
            ),
            SUBMIT_BUTTON = $(byXpath("//div[@data-field-name=\"submit\"]")),
            INPUT_BIRTHDAY_CONTAINER = $(byXpath("//div[@data-qa-type=\"uikit/input.inputBox.inputContainer\"]")),
            INPUT_BIRTHDAY_FIELD = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/input.inputBox.inputContainer\"]" +
                                    "//input[@data-qa-type=\"uikit/input.value.input\"]"
                    )
            ),
            INPUT_PHONE_CONTAINER = $(byXpath("//div[@data-qa-type=\"uikit/inputPhone.inputBox.main\"]")),
            INPUT_PHONE_FIELD = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputPhone.inputBox.main\"]//" +
                                    "input[@data-qa-type=\"uikit/inputPhone.value.input\"]"
                    )
            ),
            INPUT_FIO_CONTAINER = $(byXpath("//div[@data-qa-type=\"uikit/inputFio\"]")),
            INPUT_FIO_FIELD = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputFio\"]//input[@data-qa-type=\"uikit/inputFio.value.input\"]"
                    )
            ),
            INPUT_AMOUNT_CONTAINER = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/formGroup.element\"][1]//div[@data-qa-type=\"uikit/inputBox\"]" +
                                    "//div[@data-qa-type=\"uikit/inputBox.main\"]"
                    )
            ),
            INPUT_AMOUNT_FIELD = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/formGroup.element\"][1]//div[@data-qa-type=\"uikit/inputBox\"]" +
                                    "//div[@data-qa-type=\"uikit/inputBox.main\"]" +
                                    "//div[@data-qa-type=\"uikit/inputBox.inputContainer\"]" +
                                    "//input[@name=\"deposit_amount\"]"
                    )
            );

    public DepositPage openDepositPage() {
        open(DEPOSIT_URI);
        return this;
    }

    public DepositPage clickOpenDepositButton() {
        OPEN_DEPOSIT_BUTTON.click();
        return this;
    }

    public DepositPage setMinimumAmount() {
        INPUT_AMOUNT_CONTAINER.click();
        INPUT_AMOUNT_FIELD.sendKeys(Keys.CONTROL, "a");
        INPUT_AMOUNT_FIELD.sendKeys(Keys.DELETE);
        return this;
    }

    public DepositPage fillingFieldFio(String fio) {
        INPUT_FIO_CONTAINER.click();
        INPUT_FIO_FIELD.setValue(fio);
        return this;
    }

    public DepositPage fillingFieldPhone(String phone) {
        INPUT_PHONE_CONTAINER.click();
        INPUT_PHONE_FIELD.setValue(phone);
        return this;
    }

    public DepositPage fillingFieldBirthday(String birthday) {
        INPUT_BIRTHDAY_CONTAINER.click();
        INPUT_BIRTHDAY_FIELD.setValue(birthday);
        return this;
    }

    public DepositPage clickSubmitButton() {
        SUBMIT_BUTTON.click();
        return this;
    }
}
