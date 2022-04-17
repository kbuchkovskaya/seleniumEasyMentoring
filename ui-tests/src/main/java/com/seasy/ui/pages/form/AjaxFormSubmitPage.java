package com.seasy.ui.pages.form;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AjaxFormSubmitPage {
	
	private final SelenideElement submitButton = $("#btn-submit");
	private final SelenideElement submitResult = $("#submit-control");
	
	private final ElementsCollection formFields = $$(".form-control");
	
	public AjaxFormSubmitPage enterData(String fieldName, String data) {
		formFields.findBy(Condition.attribute("id", fieldName)).setValue(data);
		return new AjaxFormSubmitPage();
	}
	
	public AjaxFormSubmitPage clickSubmitButton() {
		submitButton.click();
		return new AjaxFormSubmitPage();
	}
	
	public AjaxFormSubmitPage checkNameIsRequiredField(String fieldName) {
		formFields.findBy(Condition.attribute("id", fieldName))
				.shouldHave(Condition.attribute("style", "border: 1px solid rgb(255, 0, 0);"));
		return new AjaxFormSubmitPage();
	}
	
	public AjaxFormSubmitPage verifyFormIsProcessing() {
		submitResult.shouldHave(Condition.text("Ajax Request Is Processing"));
		submitButton.shouldBe(Condition.hidden);
		return new AjaxFormSubmitPage();
	}
	
	public AjaxFormSubmitPage verifyFormIsSubmitted() {
		submitResult.shouldHave(Condition.text("Form submitted Successfully!"));
		submitButton.shouldBe(Condition.hidden);
		return new AjaxFormSubmitPage();
	}
}
