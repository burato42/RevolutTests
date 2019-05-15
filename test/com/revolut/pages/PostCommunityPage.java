package com.revolut.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PostCommunityPage extends CommunityPage {
    public SelenideElement getFirstPost() {
        return $("#post_1 .cooked");
    }
}
