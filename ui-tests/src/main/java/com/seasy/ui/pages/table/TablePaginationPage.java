package com.seasy.ui.pages.table;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

public class TablePaginationPage {

    private final SelenideElement nextPageButton = $(".next_link"),
    previousPageButton = $(".prev_link"),
    activePageButton = $(".page_link.active"),
    table = $("#myTable");

    private final ElementsCollection pages = $$(".page_link"),
    visibleRowsInTable = $$("#myTable > tr[style='display: table-row;']");

    public TablePaginationPage clickNextPage(){
        if(nextPageButton.exists()){
            nextPageButton.click();
        }
        return new TablePaginationPage();
    }

    public TablePaginationPage checkPreviousAndNextButtons(){
        activePageButton.should(Condition.exist);
        nextPageButton.should(Condition.visible);
        previousPageButton.should(Condition.visible);
        return new TablePaginationPage();
    }

    public TablePaginationPage checkVisibilityOfRows(){
        for(int i = 0; i < visibleRowsInTable.size(); i++){
            visibleRowsInTable.findBy(Condition.attribute("style", "display: table-row;")).shouldBe(Condition.visible);
        }
        return new TablePaginationPage();
    }

    public TablePaginationPage checkQuantityOfRows(){
        while (nextPageButton.isDisplayed()){
            assertThat(visibleRowsInTable).hasSizeBetween(1,5);
            nextPageButton.click();
        }
        return new TablePaginationPage();
    }


}
