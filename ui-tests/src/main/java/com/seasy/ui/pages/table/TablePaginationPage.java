package com.seasy.ui.pages.table;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

public class TablePaginationPage {
	
	private final SelenideElement nextPageButton = $(".next_link");
	private final SelenideElement previousPageButton = $(".prev_link");
	private final SelenideElement activePageButton = $(".page_link.active");
	
	private final ElementsCollection visibleRowsInTable = $$("#myTable > tr[style='display: table-row;']");
	private final ElementsCollection tableColumns = $$(".btn-primary th");
	
	public TablePaginationPage clickNextPage() {
		if (nextPageButton.exists()) {
			nextPageButton.click();
		}
		return new TablePaginationPage();
	}
	
	public TablePaginationPage checkPreviousAndNextButtons() {
		activePageButton.should(Condition.exist);
		nextPageButton.should(Condition.visible);
		previousPageButton.should(Condition.visible);
		return new TablePaginationPage();
	}
	
	public TablePaginationPage checkVisibilityOfRows() {
		for (int i = 0; i < visibleRowsInTable.size(); i++) {
			visibleRowsInTable.findBy(Condition.attribute("style", "display: table-row;"))
					.shouldBe(Condition.visible);
		}
		return new TablePaginationPage();
	}
	
	public TablePaginationPage checkQuantityOfRows() {
		while (nextPageButton.isDisplayed()) {
			assertThat(visibleRowsInTable).hasSizeBetween(1, 5);
			nextPageButton.click();
		}
		return new TablePaginationPage();
	}
	
	public TablePaginationPage checkQuantityOfColumns() {
		while (nextPageButton.isDisplayed()) {
			assertThat(tableColumns).asList().hasSize(7);
			nextPageButton.click();
		}
		return new TablePaginationPage();
	}
	
	
}
