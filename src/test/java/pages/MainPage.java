package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private static final String MAIN_ARTICLES = "Частным лицам Бизнесу Премиум Еще";
    private SelenideElement menuArticle = $("[data-schema-path=\"config.menu.response\"]");

    @Step("Open main page")
    public MainPage openMainPage() {
        open("/");
        return this;
    }

    @Step("Check main page article")
    public MainPage checkMainPageArticle() {
        menuArticle.shouldHave(Condition.text(MAIN_ARTICLES));
        return this;
    }
}
