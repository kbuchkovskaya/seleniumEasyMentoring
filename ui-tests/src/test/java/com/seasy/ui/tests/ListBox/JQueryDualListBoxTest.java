package com.seasy.ui.tests.ListBox;

import com.seasy.ui.tests.BaseTest;
import org.testng.annotations.Test;

public class JQueryDualListBoxTest extends BaseTest {

    @Test
    public void checkEmptyPickDataList(){
        openJQueryDualListBoxPage()
                .addAllItemsToResultList()
                .checkPickDataListIsEmpty();
    }

    @Test
    public void checkItemsFromPickListAddedToResultList(){
        openJQueryDualListBoxPage()
                .selectFewItemsFromPickList(3)
                .addItemsToResultList()
                .checkResultListIsNotEmpty();
    }

    @Test
    public void checkRemovingAllItemsFromResultList(){
        openJQueryDualListBoxPage()
                .addAllItemsToResultList()
                .checkPickDataListIsEmpty()
                .checkResultListIsNotEmpty()
                .removeAllItemsFromResultList()
                .checkResultListIsEmpty()
                .checkPickDataListIsNotEmpty();
    }

    @Test
    public void checkRemovingFewItemsFromResultList(){
        openJQueryDualListBoxPage()
                .addItemsToResultList()
                .selectFewItemsFromPickList(1)
                .addItemsToResultList()
                .checkResultListIsNotEmpty()
                .selectOneItemFromResultList()
                .removeItemsFromResultList()
                .checkResultListIsEmpty();
    }

}
