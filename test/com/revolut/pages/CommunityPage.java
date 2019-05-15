package com.revolut.pages;

import java.util.Random;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CommunityPage {
    public void searchForTopic(String text) {
        $("#search-button").click();
        $("#search-term").clear();
        $("#search-term").sendKeys(text);
    }

    public void sendShortcut(String text) {
        actions().sendKeys(text).perform();
    }

    public void goToRandomPost() {
        ElementsCollection posts = $$("div[data-topic-id] .main-link");
        int size = posts.size();
        Random rand = new Random();
        int index = rand.nextInt(size);
        posts.get(index).click();
    }

    public SelenideElement hamburgerMenu() {
        return $(".menu-panel");
    }
}
