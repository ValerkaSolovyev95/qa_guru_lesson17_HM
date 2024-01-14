package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.NORMAL;

@Tag("main_page_tests")
@Owner("va.solovev")
@Feature("Main Page")
public class MainPageTests extends BaseTest{

    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка заголовка главной страницы")
    void checkMainMenuTitlesTest() {
        mainPage.openMainPage();
        mainPage.checkMainPageArticle();
    }
}
