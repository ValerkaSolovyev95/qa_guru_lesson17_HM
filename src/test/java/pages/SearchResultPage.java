package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage extends BasePage{
    SelenideElement searchResult = $(".search");

    public void checkSearchResult(String text) {
        searchResult.shouldHave(Condition.text(text));
    }
}
