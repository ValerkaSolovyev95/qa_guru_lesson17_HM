package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.NORMAL;

@Tag("career_page_tests")
@Owner("va.solovev")
@Feature("Page Career")
public class CareerPageTests extends BaseTest{

    @Test
    @Severity(NORMAL)
    @DisplayName("Проверка заголовка страницы карьера")
    void checkCareerTitlesTest() {
        careerPage.openCareerPage();
        careerPage.checkCareerArticlePage();
    }
}
