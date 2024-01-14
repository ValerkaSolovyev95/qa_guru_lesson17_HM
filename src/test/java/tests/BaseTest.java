package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import configs.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.BusinessAccountPage;
import pages.CareerPage;
import pages.CinemaPage;
import pages.DebitCardPage;
import pages.DepositPage;
import pages.TownPage;
import pages.MainPage;
import pages.SendMessagePage;

import java.util.Map;

public class BaseTest {
    public static String env = System.getProperty("env", "local");
    public MainPage mainPage = new MainPage();
    public DebitCardPage debitCardPage = new DebitCardPage();
    public CareerPage careerPage = new CareerPage();
    public DepositPage depositPage = new DepositPage();
    public BusinessAccountPage businessAccountPage = new BusinessAccountPage();
    public SendMessagePage sendMessagePage = new SendMessagePage();
    public TownPage townPage = new TownPage();
    public CinemaPage cinemaPage = new CinemaPage();
    public TestData testData = new TestData();

    @BeforeAll
    static void setup() {
        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
        Configuration.baseUrl = "https://www.tinkoff.ru";
        Configuration.pageLoadStrategy = "eager";
        Configuration.pageLoadTimeout = 8000;
        Configuration.browser = webConfig.getBrowserName();
        Configuration.browserSize = webConfig.getBrowserSize();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        if (env.equals("remote")) {
            Configuration.remote = webConfig.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void addListener () {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void closeWebDriver() {
        Selenide.closeWebDriver();
    }

    @AfterEach
    void addAttachment() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if (!Configuration.browser.equalsIgnoreCase("firefox")){
            Attach.browserConsoleLogs();
        }
        Attach.addVideo();
    }
}
