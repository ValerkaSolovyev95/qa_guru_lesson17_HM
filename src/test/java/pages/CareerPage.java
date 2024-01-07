package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CareerPage {
    private static final String CAREER_URI = "/career/";
    private static final String CAREER_ARTICLES = "Работа в ИТ Бизнес и процессы Работа с клиентами";
    private static final SelenideElement CAREER_ARTICLE = $("[data-qa-type=\"uikit/navigation.menu\"]");

    public CareerPage openCareerPage() {
        open(CAREER_URI);
        return this;
    }

    public CareerPage checkCareerArticlePage() {
        CAREER_ARTICLE.shouldHave(Condition.text(CAREER_ARTICLES));
        return this;
    }
}
