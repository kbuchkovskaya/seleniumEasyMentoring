package com.seasy.ui.pages.Forms;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JQuerySelectDropDownPage {

    private final SelenideElement dropdownInput = $("span.select2-container.select2-container--default.select2-container--open input"),
    dropdownWithCategories = $("#files");

    private final ElementsCollection selectedItems = $$("ul.select2-selection__rendered > li.select2-selection__choice"),
    dropdownResults = $$(".select2-results__options > li"),
    dropdowns = $$(".panel-body"),
    options = $$("optgroup > option");

    public JQuerySelectDropDownPage selectItemFromDropDown(String dropDownName, String dropDownItem){
        SelenideElement dropdown = dropdowns.findBy(text(dropDownName)).$(".select2-selection.select2-selection");
        dropdown.click();
        dropdownInput.setValue(dropDownItem).sendKeys(Keys.ENTER);
        return new JQuerySelectDropDownPage();
    }

    public JQuerySelectDropDownPage checkSingleDropdownIsSelected(String dropDownName){
        SelenideElement selectedItem = dropdowns.findBy(text(dropDownName)).$(".select2-selection__rendered");
        selectedItem.shouldHave(attribute("title"));
        return new JQuerySelectDropDownPage();
    }

    public JQuerySelectDropDownPage removeSelectedItems(String dropDownName) {
        SelenideElement input = dropdowns.findBy(text(dropDownName)).$(".select2-selection.select2-selection");
        for(int i = 0; i < selectedItems.size(); i++){
            input.click();
            dropdownResults.findBy(attribute("aria-selected", "true")).click();
        }
        return new JQuerySelectDropDownPage();
    }

    public JQuerySelectDropDownPage randomItemFromDropdown(String dropdownName, int itemsQuantity){
        SelenideElement input = dropdowns.findBy(text(dropdownName)).$(".select2-selection.select2-selection");
        SelenideElement disabledItem = dropdownResults.findBy(attribute("aria-disabled"));
        Random random = new Random();
        if(!dropdownResults.isEmpty()){
            for(int i = 0; i < itemsQuantity; i++){
                input.click();
                int randomItem = random.nextInt(dropdownResults.size());
                if(dropdownResults.get(randomItem) != disabledItem){
                    dropdownResults.get(randomItem).click();
                }
            }
        }
        return new JQuerySelectDropDownPage();
    }

    public void checkEmptyMultipleDropDown(){
        selectedItems.forEach(item -> item.shouldNotHave(attribute("class", "select2-selection__choice")));
        new JQuerySelectDropDownPage();
    }

    public JQuerySelectDropDownPage checkDisabledItemInDropdown(String dropDownItem){
        selectedItems.findBy(text(dropDownItem)).shouldHave(attribute("aria-disabled", "true"));
        selectedItems.findBy(text(dropDownItem)).click();
        //selectedItems.shouldBe(CollectionCondition);
        return new JQuerySelectDropDownPage();
    }

    public void checkNoResultsFound(){
        dropdownResults.first().shouldHave(text("No results found"));
        new JQuerySelectDropDownPage();
    }

    public void checkCategoryOptionsIsNotEmpty(){
        dropdownWithCategories.click();
        SelenideElement category = dropdownWithCategories.$("optgroup");
        category.shouldNotBe(Condition.empty);
        new JQuerySelectDropDownPage();
    }

    /*public void checkSubCategories() {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/java/com/seasy/ui/pages/categories_info.json");
            Object obj = jsonParser.parse(fileReader);
            JSONArray categoriesList = (JSONArray) obj;
            for (int i = 0; i < categoriesList.size(); i++){
                JSONObject categories = (JSONObject) categoriesList.get(i);
                JSONObject category = (JSONObject) categories.get("category");
                String categoryName = (String) category.get("name");
                //dropdownWithCategories.$("optgroup").shouldHave(Condition.attribute("label", categoryName));
                categoryOptionName.findBy(attribute("label", categoryName)).should(Condition.exist);
                //categoryOptionName.findBy(Condition.text(categoryName)).should(Condition.exist);
                JSONArray itemsList = (JSONArray) categories.get("items");
                for (int j = 0; j < itemsList.size(); j++){
                    JSONObject items = (JSONObject) itemsList.get(i);
                    String subCategoryName = (String) items.get("subCategoryName");
                    options.findBy(text(subCategoryName)).shouldBe(Condition.exist);
                    String subCategoryValue = (String) items.get("value");
                    options.findBy(text(subCategoryValue)).shouldBe(Condition.visible);
                }

            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        new JQuerySelectDropDownPage();
    }
*/


    public JQuerySelectDropDownPage verifyLanguageIsInRightCategory(Language language){
        options.findBy(text(language.value)).parent().shouldBe(attribute("label", language.category));
        return new JQuerySelectDropDownPage();
    }
}
