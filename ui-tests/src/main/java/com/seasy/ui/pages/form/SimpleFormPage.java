package com.seasy.ui.pages.form;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SimpleFormPage {
	
	private final SelenideElement aInput = $("#sum1");
	private final SelenideElement showMessageButton = $("#get-input button");
	private final SelenideElement yourMessage = $("#display");
	private final SelenideElement bInput = $("#sum2");
	private final SelenideElement aSingleInput = $("#user-message");
	private final SelenideElement totalValue = $("#displayvalue");
	private final SelenideElement getTotalButton = $("#gettotal button");
	
	public SimpleFormPage enterSingleInput(String a) {
		aSingleInput.setValue(a);
		return new SimpleFormPage();
	}
	
	public SimpleFormPage clickShowMessageButton() {
		showMessageButton.click();
		return new SimpleFormPage();
	}
	
	public SimpleFormPage verifyYourMessage(String a) {
		yourMessage.should(Condition.text(a));
		return new SimpleFormPage();
	}
	
	public SimpleFormPage verifyEmptyMessage() {
		yourMessage.should(Condition.empty);
		return new SimpleFormPage();
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
	
	public SimpleFormPage clickGetTotalButton() {
		getTotalButton.click();
		return new SimpleFormPage();
	}
	
	public SimpleFormPage verifySumOfTwoIntegerValues(int a) {
		totalValue.should(Condition.text(String.valueOf(a)));
		return new SimpleFormPage();
	}
	
	public SimpleFormPage verifySumOfNonValidData(String result) {
		totalValue.should(Condition.text(result));
		return new SimpleFormPage();
	}
	
	public SimpleFormPage clearDataFields() {
		aInput.clear();
		bInput.clear();
		return new SimpleFormPage();
	}
	
}
