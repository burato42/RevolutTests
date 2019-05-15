package com.revolut.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsCommunityPage extends CommunityPage {
    public void openPostByTitle(String txt) {
        $$(".topic-title").findBy(text(txt)).click();
    }
}
