package com.seasy.ui.pages.form;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RadioButtonsPage {

	private final SelenideElement getCheckedValueButton = $("#buttoncheck");
	private final SelenideElement selectedSingleRadioButtonCheck = $(".radiobutton");
	private final SelenideElement getValuesButton = $("[class='btn btn-default'][onclick='getValues();']");
	private final SelenideElement selectedGroupRadioButtonCheck = $(".groupradiobutton");
	
	private final ElementsCollection ageGroups = $$("[name=\"ageGroup\"]");
	private final ElementsCollection genderGroups = $$("[name='gender']");
	private final ElementsCollection genders = $$("[name='optradio']");
	
	public RadioButtonsPage selectSingleGenderRadioButton(Gender gender) {
		genders.findBy(Condition.attribute("value", gender.value)).click();
		return new RadioButtonsPage();
	}
	
	public RadioButtonsPage clickGetCheckedValueButton() {
		getCheckedValueButton.click();
		return new RadioButtonsPage();
	}
	
	public RadioButtonsPage verifySelectedSingleGender(Gender gender) {
		selectedSingleRadioButtonCheck.shouldHave(Condition.text(gender.value));
		return new RadioButtonsPage();
	}
	
	public RadioButtonsPage verifySingleRadioButtonIsNotSelected() {
		selectedSingleRadioButtonCheck.shouldHave(Condition.text("Radio button is Not checked"));
		return new RadioButtonsPage();
	}
	
	public RadioButtonsPage selectGenderInRadioButtonsGroup(Gender gender) {
		genderGroups.findBy(Condition.attribute("value", gender.value)).click();
		return new RadioButtonsPage();
	}
	
	public RadioButtonsPage selectAgeGroupInRadioButtonsGroup(AgeGroup ageGroup) {
		ageGroups.findBy(Condition.attribute("value", ageGroup.value)).click();
		return new RadioButtonsPage();
	}
	
	public RadioButtonsPage clickGetValuesButton() {
		getValuesButton.click();
		return new RadioButtonsPage();
	}
	
	public RadioButtonsPage verifyGender(Gender gender) {
		selectedGroupRadioButtonCheck.shouldHave(Condition.text(gender.value));
		return new RadioButtonsPage();
	}
	
	public RadioButtonsPage verifyAgeGroupIsSelected(AgeGroup ageGroup) {
		selectedGroupRadioButtonCheck.shouldHave(Condition.text(ageGroup.value));
		return new RadioButtonsPage();
	}
	
	public RadioButtonsPage verifyGenderIsNotSelected(Gender gender) {
		selectedGroupRadioButtonCheck.shouldNotHave(Condition.text(gender.value));
		return new RadioButtonsPage();
	}
	
	public RadioButtonsPage verifyAgeGroupIsNotSelected(AgeGroup ageGroup) {
		selectedGroupRadioButtonCheck.shouldNotHave(Condition.text(ageGroup.value));
		return new RadioButtonsPage();
	}
	
}
