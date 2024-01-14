package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TownPage {
    private static final String SERVICE_TOWN_URI = "/gorod";
    private SelenideElement toLearnButton = $(byXpath("//h3[@data-test=\"htmlTag button\"]")),
    afishaTitle = $(byXpath("//div[@id=\"afisha\"]//h2[@data-test=\"htmlTag title\"]")),
    cinemaButton = $(byXpath("//div[@data-test=\"panel \"]//a[@href=\"/gorod/cinema/\"]//" +
            "div[@data-test=\"clickableArea slideLink\"]"));

    @Step("Open gorod page")
    public TownPage openPage() {
        open(SERVICE_TOWN_URI);
        return this;
    }

    @Step("Click to learn more button")
    public TownPage clickToLearnMoreButton() {
        toLearnButton.click();
        return this;
    }

    @Step("Check Afisha text")
    public TownPage checkTextAfisha(String text) {
        afishaTitle.shouldHave(Condition.text(text));
        return this;
    }

    @Step("Click cinema button")
    public TownPage clickCinemaButton() {
        cinemaButton.click();
        return this;
    }
}
