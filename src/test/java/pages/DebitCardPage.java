package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class DebitCardPage {
    private Faker faker = new Faker();

    private static final List<String> CASHBACK_CATEGORY_LIST = new ArrayList<>(
            List.of(
                    "1% - Все покупки",
                    "5% - Аптеки",
                    "5% - Ozon.ru",
                    "5% - Спорттовары",
                    "3% - Пятёрочка",
                    "5% - Такси",
                    "5% - Рестораны"
            )
    );
    private static final String DEBIT_CARD_URI = "/cards/debit-cards/";
    private static final String CARD_DESIGN_PANEL = "//div[@data-qa-type=\"uikit/individualDesign.container\"]" +
            "/div[@class=\"cbOv8gnh9\"]/div[2]//div[@data-qa-type=\"uikit/individualDesign.preview\"]//picture/" +
            "img[@src=\"https://imgproxy.cdn-tinkoff.ru/card_design_preview_x1/%s\"]";
    private static final List<String> DESIGN_CARDS_LIST = List.of(
            "aHR0cHM6Ly9hY2RuLnRpbmtvZmYucnUvc3RhdGljL3BhZ2VzL2ZpbGVzL2I5MTYzZGFhLWQzYWMtNGEzMy1iOWI4LTUzMDUyZDlmZmJiYy5wbmc=",
            "aHR0cHM6Ly9hY2RuLnRpbmtvZmYucnUvc3RhdGljL3BhZ2VzL2ZpbGVzL2I5MTYzZGFhLWQzYWMtNGEzMy1iOWI4LTUzMDUyZDlmZmJiYy5wbmc=",
            "aHR0cHM6Ly9hY2RuLnRpbmtvZmYucnUvc3RhdGljL3BhZ2VzL2ZpbGVzL2I1ZGEwNmJjLTEzMGMtNGJlYi04ZDMwLWE4ZGMyMTMwODNlNy5wbmc=",
            "aHR0cHM6Ly9hY2RuLnRpbmtvZmYucnUvc3RhdGljL3BhZ2VzL2ZpbGVzL2VkOGQwNDc2LTI0ZmUtNDk0My04NjFmLTIzYWJmNTgzNDc4MC5wbmc="
    );
    private SelenideElement
            orderCardButton = $("[data-qa-type=\"uikit/button.content\"]"),
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
            inputEmailContainer = $(byXpath("//div[@data-qa-type=\"uikit/inputAutocomplete.inputBox.main\"]")),
            inputEmailField = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputAutocomplete.inputBox.main\"]" +
                                    "//input[@data-qa-type=\"uikit/inputAutocomplete.value.input\"]"
                    )
            ),
            submitButton = $(byXpath("//div[@data-field-name=\"submit\"]")),
            multiSelectWrapper = $("[data-qa-type=\"uikit/multiSelect.wrapper.rightContainer\"]");

    @Step("Open card page")
    public DebitCardPage openDebitCardPage() {
        open(DEBIT_CARD_URI);
        return this;
    }

    @Step("Click order card button")
    public DebitCardPage clickOrderCardButton() {
        orderCardButton.click();
        return this;
    }

    @Step("Choice card design")
    public DebitCardPage choiceCardDesign() {
        String choiceCardLoc = String.format(
                CARD_DESIGN_PANEL,
                DESIGN_CARDS_LIST.get(faker.number().numberBetween(0, 3)
                )
        );
        $x(choiceCardLoc).click();
        return this;
    }

    @Step("Filling field fio")
    public DebitCardPage fillingFieldFio(String fio) {
        inputFioContainer.click();
        inputFioField.setValue(fio);
        return this;
    }

    @Step("Filling field phone")
    public DebitCardPage fillingFieldPhone(String phone) {
        inputPhoneContainer.click();
        inputPhoneField.setValue(phone);
        return this;
    }

    @Step("Filling field email")
    public DebitCardPage fillingFieldEmail(String email) {
        inputEmailContainer.click();
        inputEmailField.setValue(email);
        return this;
    }

    @Step("Filling field birthday")
    public DebitCardPage fillingFieldBirthday(String birthday) {
        inputBirthdayContainer.click();
        inputBirthdayField.setValue(birthday);
        return this;
    }

    @Step("Click submit button")
    public DebitCardPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    private DebitCardPage clickMultiSelectWrapper() {
        multiSelectWrapper.click();
        return this;
    }

    private DebitCardPage clickCashbackCategory() {
        for (int i = 0; i < 4; i++) {
            String value = CASHBACK_CATEGORY_LIST.get(i);
            $(byText(value)).click();
            CASHBACK_CATEGORY_LIST.remove(value);
        }
        return this;
    }

    @Step("Choice cashback category")
    public DebitCardPage choiceCashBackCategory() {
        clickMultiSelectWrapper();
        clickCashbackCategory();
        clickMultiSelectWrapper();
        return this;
    }
}
