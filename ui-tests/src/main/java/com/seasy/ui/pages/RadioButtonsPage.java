package com.seasy.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RadioButtonsPage {

    private final SelenideElement femaleRadioButton = $("input[value='Female'][name='optradio']"),
    maleRadioButton = $("input[value='Male'][name='optradio']"),
    getCheckedValueButton = $("#buttoncheck"),
    selectedSingleRadioButtonCheck = $(".radiobutton"),
    maleGroupRadioButton = $("[value='Male'][name='gender']"),
    femaleGroupRadioButton = $("[value='Female'][name='gender']"),
    ageGroupFromZeroToFive = $("[value='0 - 5'][name='ageGroup']"),
    ageGroupFromFiveToFifteen = $("[value='5 - 15'][name='ageGroup']"),
    ageGroupFromFifteenToFifty = $("[value='15 - 50'][name='ageGroup']"),
    getVeluesButton = $("[class='btn btn-default'][onclick='getValues();']"),
    selectedGroupRadioButtonCheck = $(".groupradiobutton");

    public RadioButtonsPage selectFemaleRadioButton(){
        femaleRadioButton.click();
        femaleRadioButton.shouldBe(Condition.selected);
        return new RadioButtonsPage();
    }

    public RadioButtonsPage selectMaleRadioButton(){
        maleRadioButton.click();
        maleRadioButton.shouldBe(Condition.selected);
        return new RadioButtonsPage();
    }

    public RadioButtonsPage clickGetCheckedValueButton(){
        getCheckedValueButton.click();
        return new RadioButtonsPage();
    }

    public void verifySelectedMaleRadioButton(){
        selectedSingleRadioButtonCheck.shouldHave(Condition.text("Male"));
        new RadioButtonsPage();
    }

    public void verifySelectedFemaleRadioButton(){
        selectedSingleRadioButtonCheck.shouldHave(Condition.text("Female"));
        new RadioButtonsPage();
    }

    public void verifySingleRadioButtonIsNotSelected(){
        selectedGroupRadioButtonCheck.shouldHave(Condition.text("Radio button is Not checked"));
        new RadioButtonsPage();
    }

    public RadioButtonsPage selectMaleGroupRadioButton(){
        maleGroupRadioButton.click();
        maleGroupRadioButton.shouldBe(Condition.selected);
        return new RadioButtonsPage();
    }

    public RadioButtonsPage selectFemaleGroupRadioButton(){
        femaleGroupRadioButton.click();
        femaleGroupRadioButton.shouldBe(Condition.selected);
        return new RadioButtonsPage();
    }

    public RadioButtonsPage selectAgeGroupFromZeroToFive(){
        ageGroupFromZeroToFive.click();
        ageGroupFromZeroToFive.shouldBe(Condition.selected);
        return new RadioButtonsPage();
    }

    public RadioButtonsPage selectAgeGroupFromFiveToFifteen(){
        ageGroupFromFiveToFifteen.click();
        ageGroupFromFiveToFifteen.shouldBe(Condition.selected);
        return new RadioButtonsPage();
    }

    public RadioButtonsPage selectAgeGroupFromFifteenToFifty(){
        ageGroupFromFifteenToFifty.click();
        ageGroupFromFifteenToFifty.shouldBe(Condition.selected);
        return new RadioButtonsPage();
    }

    public RadioButtonsPage clickGetValuesButton(){
        getVeluesButton.click();
        return new RadioButtonsPage();
    }

    public RadioButtonsPage verifyGenderIsFemale(){
        selectedGroupRadioButtonCheck.shouldHave(Condition.text("Sex : Female"));
        return new RadioButtonsPage();
    }

    public RadioButtonsPage verifyGenderIsMale(){
        selectedGroupRadioButtonCheck.shouldHave(Condition.text("Sex : Male"));
        return new RadioButtonsPage();
    }

    public void verifyAgeGroupIsFromZeroToFive(){
        selectedGroupRadioButtonCheck.shouldHave(Condition.text("Age group: 0 - 5"));
        new RadioButtonsPage();
    }

    public void verifyAgeGroupIsFromFiveToFifteen(){
        selectedGroupRadioButtonCheck.shouldHave(Condition.text("Age group: 5 - 15"));
        new RadioButtonsPage();
    }

    public void verifyAgeGroupIsFromFifteenToFifty(){
        selectedGroupRadioButtonCheck.shouldHave(Condition.text("Age group: 15 - 50"));
        new RadioButtonsPage();
    }

    public void verifyGenderIsNotSelected(){
        selectedGroupRadioButtonCheck.shouldNotHave(Condition.text("Female"));
        new RadioButtonsPage();
    }

    public void verifyAgeGroupIsNotSelected(){
        selectedGroupRadioButtonCheck.shouldHave(Condition.text(" Age group: "));
        new RadioButtonsPage();
    }

}
