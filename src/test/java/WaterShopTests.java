import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.MainPage;
import pages.SearchResultPage;

import static io.qameta.allure.Allure.step;

@Tag("regression")
public class WaterShopTests extends BaseTest {
    private final MainPage MAIN_PAGE = new MainPage();
    private final SearchResultPage SEARCH_PAGE = new SearchResultPage();
    private final CartPage CART_PAGE = new CartPage();

    @Test
    void checkPhoneNumberTest() {
        step("Open main page and close chat", () -> {
            MAIN_PAGE.openPage();
            MAIN_PAGE.closeChat();
        });
        step("Check phone number", () -> MAIN_PAGE.checkPhoneNumber(TestData.phoneNumber));
    }

    @Test
    void checkHeaderPageTest() {
        step("Open main page and close chat", () -> {
            MAIN_PAGE.openPage();
            MAIN_PAGE.closeChat();
        });
        step("Check main header", () -> MAIN_PAGE.checkMainHeader(TestData.headerMenu));
    }

    @Test
    void addToCartTest() {
        step("Open main page and close chat", () -> {
            MAIN_PAGE.openPage();
            MAIN_PAGE.closeChat();
        });
        step("Choice water rate", MAIN_PAGE::choiceRate);
        step("Go to cart", MAIN_PAGE::cartButtonClick);
        step("Check rate in cart", CART_PAGE::checkAddedRate);
    }

    @Test
    void removeToCartTest() {
        step("Open main page and close chat", () -> {
            MAIN_PAGE.openPage();
            MAIN_PAGE.closeChat();
        });
        step("Choice water rate", MAIN_PAGE::choiceRate);
        step("Go to cart", MAIN_PAGE::cartButtonClick);
        step("Delete water rate", CART_PAGE::clickDeleteButton);
        step("Check what cart is empty", () -> CART_PAGE.checkCartIsEmpty(TestData.emptyCart));
    }

    @Test
    void searchArticleTest() {
        step("Open main page and close chat", () -> {
            MAIN_PAGE.openPage();
            MAIN_PAGE.closeChat();
        });
        step("Input text in search field", () -> MAIN_PAGE.inputTextSearch(TestData.textSearch));
        step("Check seach result", () -> SEARCH_PAGE.checkSearchResult(TestData.textSearchResult));
    }
}
