package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CinemaPage {
    private SelenideElement cinemaTitle = $(byXpath("//h1[@data-test=\"htmlTag title\"]/p"));

    @Step("Check title cinema tickets")
    public CinemaPage checkCinemaPageTitle(String checkText) {
        cinemaTitle.shouldHave(text(checkText));
        return this;
    }
}
