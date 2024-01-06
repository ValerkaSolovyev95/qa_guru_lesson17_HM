package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends BasePage {
    SelenideElement phoneNumberField = $(".v-header-main__phone"),
            searchField = $("[name=search_string]"),
            lightRate = $("[data-id=\"1025\"]");
    private String menuHeader = ".v-header-darkline__menu";
    private String cartButton = "//div[@class=\"container\"]/div[@class=\"v-header-darkline__cart " +
            "v-header-darkline__cart--full\"]/a[@href=\"/emarket/cart/\"]";

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage checkPhoneNumber(String number) {
        phoneNumberField.shouldHave(Condition.text(number));
        return this;
    }

    public MainPage inputTextSearch(String text) {
        searchField.click();
        searchField.setValue(text).pressEnter();
        return this;
    }

    public MainPage choiceRate() {
        lightRate.click();
        return this;
    }

    public MainPage checkMainHeader(List<String> headerList) {
        String headerMenu = String.join("\n", headerList);
        $$(menuHeader).shouldHave(
                CollectionCondition.texts(
                        headerMenu
                )
        );
        return this;
    }

    public MainPage cartButtonClick() {
        $x(cartButton).click();
        return this;
    }
}
