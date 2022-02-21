package com.seasy.ui.pages.form;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JQuerySelectDropDownPage {
	
	private final SelenideElement dropdownInput = $("span.select2-container.select2-container--default.select2-container--open input");
	private final SelenideElement dropdownWithCategories = $("#files");
	
	private final ElementsCollection selectedItems = $$("ul.select2-selection__rendered > li.select2-selection__choice");
	private final ElementsCollection dropdownResults = $$(".select2-results__options > li");
	private final ElementsCollection dropdowns = $$(".panel-body");
	private final ElementsCollection options = $$("optgroup > option");
	
	Random random = new Random();
	
	public JQuerySelectDropDownPage selectItemFromDropDown(String dropDownName, String dropDownItem) {
		SelenideElement dropdown = dropdowns.findBy(text(dropDownName)).$(".select2-selection.select2-selection");
		dropdown.click();
		dropdownInput.setValue(dropDownItem).sendKeys(Keys.ENTER);
		return new JQuerySelectDropDownPage();
	}
	
	public JQuerySelectDropDownPage checkSingleDropdownIsSelected(String dropDownName) {
		SelenideElement selectedItem = dropdowns.findBy(text(dropDownName)).$(".select2-selection__rendered");
		selectedItem.shouldHave(attribute("title"));
		return new JQuerySelectDropDownPage();
	}
	
	public JQuerySelectDropDownPage removeSelectedItems(String dropDownName) {
		SelenideElement input = dropdowns.findBy(text(dropDownName)).$(".select2-selection.select2-selection");
		for (int i = 0; i < selectedItems.size(); i++) {
			input.click();
			dropdownResults.findBy(attribute("aria-selected", "true")).click();
		}
		return new JQuerySelectDropDownPage();
	}
	
	public JQuerySelectDropDownPage randomItemFromDropdown(String dropdownName, int itemsQuantity) {
		SelenideElement input = dropdowns.findBy(text(dropdownName)).$(".select2-selection.select2-selection");
		SelenideElement disabledItem = dropdownResults.findBy(attribute("aria-disabled"));
		if (!dropdownResults.isEmpty()) {
			for (int i = 0; i < itemsQuantity; i++) {
				input.click();
				int randomItem = random.nextInt(dropdownResults.size());
				if (dropdownResults.get(randomItem) != disabledItem) {
					dropdownResults.get(randomItem).click();
				}
			}
		}
		return new JQuerySelectDropDownPage();
	}
	
	public JQuerySelectDropDownPage checkEmptyMultipleDropDown() {
		selectedItems.forEach(item -> item.shouldNotHave(attribute("class", "select2-selection__choice")));
		return new JQuerySelectDropDownPage();
	}
	
	public JQuerySelectDropDownPage checkDisabledItemInDropdown(String dropDownItem) {
		selectedItems.findBy(text(dropDownItem)).shouldHave(attribute("aria-disabled", "true"));
		selectedItems.findBy(text(dropDownItem)).click();
		//selectedItems.shouldBe(CollectionCondition);
		return new JQuerySelectDropDownPage();
	}
	
	public JQuerySelectDropDownPage checkNoResultsFound() {
		dropdownResults.first().shouldHave(text("No results found"));
		return new JQuerySelectDropDownPage();
	}
	
	public JQuerySelectDropDownPage checkCategoryOptionsIsNotEmpty() {
		dropdownWithCategories.click();
		SelenideElement category = dropdownWithCategories.$("optgroup");
		category.shouldNotBe(Condition.empty);
		return new JQuerySelectDropDownPage();
	}
	
	public JQuerySelectDropDownPage verifyLanguageIsInRightCategory(Language language) {
		options.findBy(text(language.value)).parent().shouldBe(attribute("label", language.category));
		return new JQuerySelectDropDownPage();
	}
}
