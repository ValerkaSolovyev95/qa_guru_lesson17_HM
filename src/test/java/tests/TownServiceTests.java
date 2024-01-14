package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.NORMAL;

@Tag("town_service_tests")
@Owner("va.solovev")
@Feature("Service town")
public class TownServiceTests extends BaseTest{

    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка заголовка сервиса афиша")
    void checkTitleAfishaTest() {
        townPage.openPage();
        townPage.clickToLearnMoreButton();
        townPage.checkTextAfisha(testData.checkTextAfisha);
    }

    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка перехода на страницу кино, при нажатии кнопки Кино")
    void checkCinemaButtonTest() {
        townPage.openPage();
        townPage.clickToLearnMoreButton();
        townPage.clickCinemaButton();
        cinemaPage.checkCinemaPageTitle(testData.checkTextCinemaTickets);
    }
}
