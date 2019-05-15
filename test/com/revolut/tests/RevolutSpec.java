package com.revolut.tests;

import com.revolut.pages.CommunityPage;
import com.revolut.pages.MainPage;
import com.revolut.pages.PostCommunityPage;
import com.revolut.pages.SearchResultsCommunityPage;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.url;


public class RevolutSpec extends RevolutTests {

    @Test
    public void changeCountry() {
        MainPage page = new MainPage();
        page.scrollToBottom();
        page.changeCountry("United States");
        page.waitForUrl("https://www.revolut.com/en-US");
        // The assertion could be redundant here but it's better to keep it here
        Assert.assertEquals("https://www.revolut.com/en-US", url());
    }

    @Test
    public void keyboardShortcutsGetBack() {
        new MainPage().goToCommunity();
        new CommunityPage().goToRandomPost();
        PostCommunityPage post = new PostCommunityPage();
        post.getFirstPost().shouldBe(visible);
        Assert.assertNotEquals("https://community.revolut.com/", url());
        post.sendShortcut("gh");
        Assert.assertEquals("https://community.revolut.com/", url());
    }

    @Test
    public void keyboardShortcutsOpenHamburger() {
        new MainPage().goToCommunity();
        CommunityPage community = new CommunityPage();
        community.hamburgerMenu().shouldNotBe(visible);
        community.sendShortcut("=");
        community.hamburgerMenu().shouldBe(visible);
        community.sendShortcut("=");
        community.hamburgerMenu().shouldNotBe(visible);
    }

    @Test
    public void weGotBankingLicense() {
        new MainPage().goToCommunity();
        new CommunityPage().searchForTopic("We got a banking licence\n");
        new SearchResultsCommunityPage().openPostByTitle("We got a banking licence");
        new PostCommunityPage().getFirstPost()
                .shouldHave(text("We’ve had our application for a European banking licence approved."));
    }
}