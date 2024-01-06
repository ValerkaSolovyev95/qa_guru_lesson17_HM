package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPage extends BasePage{
    SelenideElement orderTable = $(".cart-table"),
    deleteButton = $(".cart-table-good__tools");
    String emptyCart = "//div[@class=\"cart-empty__inner\"]/p";


    public CartPage checkAddedRate() {
        orderTable.shouldBe(Condition.exist);
        return this;
    }

    public CartPage clickDeleteButton() {
        deleteButton.click();
        return this;
    }

    public CartPage checkCartIsEmpty(String text) {
        assertEquals(text, $x(emptyCart).getOwnText());
        return this;
    }
}
