package com.seasy.ui.pages.ListBox;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class JQueryDualListBoxPage {

    private final SelenideElement pickDataList = $(".form-control.pickListSelect.pickData"),
    resultList = $(".form-control.pickListSelect.pickListResult"),
    addButton = $(".pAdd"),
    addAllButton = $(".pAddAll"),
    removeButton = $(".pRemove"),
    removeAllButton = $(".pRemoveAll");

    private final ElementsCollection itemsDataPickList = $$(".form-control.pickListSelect.pickData > option"),
    itemsResultList = $$(".form-control.pickListSelect.pickListResult > option");

    public JQueryDualListBoxPage addAllItemsToResultList(){
        addAllButton.click();
        return new JQueryDualListBoxPage();
    }

    public JQueryDualListBoxPage checkPickDataListIsEmpty(){
        pickDataList.shouldBe(Condition.empty);
        return new JQueryDualListBoxPage();
    }

    public JQueryDualListBoxPage addItemsToResultList(){
        addButton.click();
        return new JQueryDualListBoxPage();
    }

    public JQueryDualListBoxPage removeItemsFromResultList(){
        removeButton.click();
        return new JQueryDualListBoxPage();
    }

    public JQueryDualListBoxPage removeAllItemsFromResultList(){
        removeAllButton.click();
        return new JQueryDualListBoxPage();
    }

    public JQueryDualListBoxPage checkResultListIsEmpty(){
        resultList.shouldBe(Condition.empty);
        return new JQueryDualListBoxPage();
    }

    public JQueryDualListBoxPage checkResultListIsNotEmpty(){
        resultList.shouldNotBe(Condition.empty);
        return new JQueryDualListBoxPage();
    }

    public JQueryDualListBoxPage checkPickDataListIsNotEmpty(){
        pickDataList.shouldNotBe(Condition.empty);
        return new JQueryDualListBoxPage();
    }

    //how to create two diff lists
    public JQueryDualListBoxPage selectFewItemsFromPickList(int quantityOfItems){
        Random random = new Random();
        for (int i = 0; i < quantityOfItems; i++){
            int randomItem = random.nextInt(itemsDataPickList.size());
            itemsDataPickList.get(randomItem).click();
        }
        return new JQueryDualListBoxPage();
    }

    public JQueryDualListBoxPage selectOneItemFromResultList(){
        Random random = new Random();
        for (int i = 0; i < itemsResultList.size(); i++){
            int randomItem = random.nextInt(itemsResultList.size());
            itemsResultList.get(randomItem).click();
        }
        return new JQueryDualListBoxPage();
    }

}
