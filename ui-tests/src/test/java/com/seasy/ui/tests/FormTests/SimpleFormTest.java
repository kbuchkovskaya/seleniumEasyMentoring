package com.seasy.ui.tests.FormTests;

import com.seasy.ui.tests.BaseTest;
import org.testng.annotations.Test;

public class SimpleFormTest  extends BaseTest {

    @Test
    public void checkEmptyMessageTest() {
        openSimpleFormPage()
                .clickShowMessageButton()
                .verifyEmptyMessage();
    }

    @Test
    public void checkYourMessageTest() {
        openSimpleFormPage()
                .enterSingleInput("22")
                .clickShowMessageButton()
                .verifyYourMessage("22");
    }

    @Test
    public void checkTotalResultWithIntegerValuesTest() {
        openSimpleFormPage()
                .enterTwoInput(5, 6)
                .clickGetTotalButton()
                .verifySumOfTwoIntegerValues(11);
    }

    @Test
    public void checkTotalResultWithStringValuesTest() {
        openSimpleFormPage()
                .enterNegativeValue("test1", "test2")
                .clickGetTotalButton()
                .verifySumOfNonValidData("Nan");
    }

    @Test
    public void checkTotalResultWithEmptyFieldsTest() {
        openSimpleFormPage()
                .clearDataFields()
                .clickGetTotalButton()
                .verifySumOfNonValidData("Nan");
    }

}
