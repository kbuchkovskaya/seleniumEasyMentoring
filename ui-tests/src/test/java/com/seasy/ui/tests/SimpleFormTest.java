package com.seasy.ui.tests;

import com.codeborne.selenide.Selenide;
import com.seasy.ui.pages.SimpleFormPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SimpleFormTest {

    @BeforeSuite
    public void openInputForms() {
        open("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Selenide.switchTo().activeElement().sendKeys(Keys.ESCAPE);
    }

    @Test
    public void checkEmptyMessageTest() {
        new SimpleFormPage()
                .clickShowMessageButton()
                .verifyEmptyMessage();
    }

    @Test
    public void checkYourMessageTest() {
        new SimpleFormPage()
                .enterSingleInput("22")
                .clickShowMessageButton()
                .verifyYourMessage("22");
    }

    @Test
    public void checkTotalResultWithIntegerVeluesTest(){
        new SimpleFormPage()
                .enterTwoInput(5, 6)
                .clickGetTotalButton()
                .verifySumOfTwoIntegerValues(11);
    }

    @Test
    public void checkTotalResultWithSrtingValuesTest() {
        new SimpleFormPage()
                .enterNegativeValue("test1", "test2")
                .clickGetTotalButton()
                .verifySumOfNonValidData("Nan");
    }

    @Test
    public void checkTotalResultWithEmptyFieldsTest() {
        new SimpleFormPage()
                .clearDataFields()
                .clickGetTotalButton()
                .verifySumOfNonValidData("Nan");
    }

}
