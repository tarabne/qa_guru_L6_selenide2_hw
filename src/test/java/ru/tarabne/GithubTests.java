package ru.tarabne;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class GithubTests {
    @BeforeAll
    static void testConfiguration() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void hoverAndClick() {
        open("");
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $$(".HeaderMenu-dropdown").get(1)
                .$$("a").filterBy(Condition.text("Enterprise")).first().click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" +
                "developer platform"));
    }

}
