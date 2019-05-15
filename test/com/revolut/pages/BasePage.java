package com.revolut.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.Wait;

public abstract class BasePage {
    public void waitForUrl(String url) {
        Wait().until(ExpectedConditions.urlToBe(url));
    }
}
