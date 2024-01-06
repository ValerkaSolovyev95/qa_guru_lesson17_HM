package pages;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BasePage {
    public void closeChat() {
        executeJavaScript("$('jcont').remove()");
    }
}
