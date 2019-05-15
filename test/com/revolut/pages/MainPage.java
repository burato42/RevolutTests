package com.revolut.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class MainPage extends BasePage {
    private String nextWindowHandle(WebDriver driver) {
        String windowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.remove(windowHandle);

        return windowHandles.iterator().next();
    }

    public void goToCommunity() {
        actions()
                .moveToElement($$("div[tabindex] span").findBy(text("Help")))
                .click()
                .moveToElement($$("a[target]").findBy(text("Community")))
                .click()
                .perform();

        WebDriver driver = getWebDriver();
        driver.switchTo().window(nextWindowHandle(driver));
    }

    public void scrollToBottom() {
        $(byText("United Kingdom")).scrollTo();
    }

    public void changeCountry(String country) {
        $(byText("United Kingdom")).click();
        SelenideElement countryInput = $("label input[placeholder]");
        countryInput.clear();
        countryInput.sendKeys(country);
        $$("a").findBy(text(country)).click();
    }
}