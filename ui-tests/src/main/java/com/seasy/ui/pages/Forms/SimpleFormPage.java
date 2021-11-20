package com.seasy.ui.pages.Forms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SimpleFormPage {

    private final SelenideElement aInput = $("#sum1"),
            showMessageButton = $("#get-input button"),
            yourMessage = $("#display"),
            bInput = $("#sum2"),
            aSingleInput = $("#user-message"),
            totalValue = $("#displayvalue"),
            getTotalButton = $("#gettotal button");

    public SimpleFormPage enterSingleInput(String a) {
        aSingleInput.setValue(a);
        return new SimpleFormPage();
    }

    public SimpleFormPage clickShowMessageButton(){
        showMessageButton.click();
        return new SimpleFormPage();
    }

    public void verifyYourMessage(String a){
        yourMessage.should(Condition.text(a));
        new SimpleFormPage();
    }

    public void verifyEmptyMessage(){
        yourMessage.should(Condition.empty);
        new SimpleFormPage();
    }

    public SimpleFormPage enterTwoInput(int a, int b) {
        aInput.setValue(String.valueOf(a));
        bInput.setValue(String.valueOf(b));
        return new SimpleFormPage();
    }

    public SimpleFormPage enterNegativeValue(String a, String b) {
        aInput.setValue(a);
        bInput.setValue(b);
        return new SimpleFormPage();
    }

    public SimpleFormPage clickGetTotalButton(){
        getTotalButton.click();
        return new SimpleFormPage();
    }

    public void verifySumOfTwoIntegerValues(int a){
        totalValue.should(Condition.text(String.valueOf(a)));
        new SimpleFormPage();
    }

    public void verifySumOfNonValidData(String result) {
        totalValue.should(Condition.text(result));
        new SimpleFormPage();
    }

    public SimpleFormPage clearDataFields() {
        aInput.clear();
        bInput.clear();
        return new SimpleFormPage();
    }

}
