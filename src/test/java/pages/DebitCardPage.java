package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class DebitCardPage {
    private static final Faker FAKER = new Faker();

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
    private final SelenideElement
            ORDER_CARD_BUTTON = $("[data-qa-type=\"uikit/button.content\"]"),
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
            INPUT_EMAIL_CONTAINER = $(byXpath("//div[@data-qa-type=\"uikit/inputAutocomplete.inputBox.main\"]")),
            INPUT_EMAIL_FIELD = $(
                    byXpath(
                            "//div[@data-qa-type=\"uikit/inputAutocomplete.inputBox.main\"]" +
                                    "//input[@data-qa-type=\"uikit/inputAutocomplete.value.input\"]"
                    )
            ),
            SUBMIT_BUTTON = $(byXpath("//div[@data-field-name=\"submit\"]")),
            MULTI_SELECT_WRAPPER = $("[data-qa-type=\"uikit/multiSelect.wrapper.rightContainer\"]");

    public DebitCardPage openDebitCardPage() {
        open(DEBIT_CARD_URI);
        return this;
    }

    public DebitCardPage clickOrderCardButton() {
        ORDER_CARD_BUTTON.click();
        return this;
    }

    public DebitCardPage choiceCardDesign() {
        String choiceCardLoc = String.format(
                CARD_DESIGN_PANEL,
                DESIGN_CARDS_LIST.get(FAKER.number().numberBetween(0, 3)
                )
        );
        $x(choiceCardLoc).click();
        return this;
    }

    public DebitCardPage fillingFieldFio(String fio) {
        INPUT_FIO_CONTAINER.click();
        INPUT_FIO_FIELD.setValue(fio);
        return this;
    }

    public DebitCardPage fillingFieldPhone(String phone) {
        INPUT_PHONE_CONTAINER.click();
        INPUT_PHONE_FIELD.setValue(phone);
        return this;
    }

    public DebitCardPage fillingFieldEmail(String email) {
        INPUT_EMAIL_CONTAINER.click();
        INPUT_EMAIL_FIELD.setValue(email);
        return this;
    }

    public DebitCardPage fillingFieldBirthday(String birthday) {
        INPUT_BIRTHDAY_CONTAINER.click();
        INPUT_BIRTHDAY_FIELD.setValue(birthday);
        return this;
    }

    public DebitCardPage clickSubmitButton() {
        SUBMIT_BUTTON.click();
        return this;
    }

    private DebitCardPage clickMultiSelectWrapper() {
        MULTI_SELECT_WRAPPER.click();
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

    public DebitCardPage choiceCashBackCategory() {
        clickMultiSelectWrapper();
        clickCashbackCategory();
        clickMultiSelectWrapper();
        return this;
    }
}
