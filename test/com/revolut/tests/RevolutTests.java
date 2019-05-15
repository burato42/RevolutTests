package com.revolut.tests;

import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class RevolutTests {

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();

    @Before
    public void setUp() {
        baseUrl = "https://revolut.com/";
        open(baseUrl);
    }

    @BeforeClass
    public static void setUpClass() {
        timeout = 10000;
        startMaximized = true;
    }

    @After
    public void tearDown() {
        WebDriver driver = getWebDriver();
        driver.close();
    }


    @AfterClass
    public static void tearDownClass() {
        closeWebDriver();
    }
}