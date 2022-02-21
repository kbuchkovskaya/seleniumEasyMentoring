package com.seasy.ui.pages.table;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TableDataSearchPage {
	
	private final SelenideElement simpleTable = $("#task-table");
	private final SelenideElement tableWithFilters = $(".panel.panel-primary.filterable > table");
	private final SelenideElement taskTableFilter = $("#task-table-filter");
	private final SelenideElement filterButtonInTableWithFilters = $(".pull-right > button");
	private final SelenideElement noResultsLabelInSimpleTable = $("tr.filterTable_no_results");
	
	private final ElementsCollection simpleTableRows = $$("#task-table > tbody > tr");
	private final ElementsCollection tableWithFiltersRows = $$(".panel.panel-primary.filterable > table > tbody > tr");
	private final ElementsCollection filtersTableWithFilters = $$(".filters input");
	private final ElementsCollection columnsFromTaskTable = $$("#task-table th");
	
	public TableDataSearchPage checkSimpleTableIsNotEmpty() {
		simpleTable.shouldNotBe(Condition.empty);
		return new TableDataSearchPage();
	}
	
	public TableDataSearchPage searchDataInSimpleTable(String data) {
		taskTableFilter.setValue(data);
		simpleTableRows.findBy(Condition.text(data)).shouldBe(Condition.visible);
		return new TableDataSearchPage();
	}
	
	public TableDataSearchPage removeDataFromFilterInSimpleTable() {
		taskTableFilter.clear();
		return new TableDataSearchPage();
	}
	
	public TableDataSearchPage checkEmptyFilterInSimpleTable() {
		taskTableFilter.shouldBe(Condition.empty);
		return new TableDataSearchPage();
	}
	
	public TableDataSearchPage filterRowsTableWithFilters(FilterName filter, String data) {
		filtersTableWithFilters.findBy(Condition.attribute("placeholder", filter.value)).setValue(data);
		tableWithFiltersRows.findBy(Condition.text(data)).shouldBe(Condition.visible);
		return new TableDataSearchPage();
	}
	
	public TableDataSearchPage removeDataFromNumberFilterTableWithFilters(String filter) {
		filtersTableWithFilters.findBy(Condition.attribute("placeholder", filter)).clear();
		return new TableDataSearchPage();
	}
	
	//????
	public TableDataSearchPage checkEmptyFilterInTableWithFilters(String filter) {
		filtersTableWithFilters.findBy(Condition.attribute("placeholder", filter)).shouldBe(Condition.empty);
		return new TableDataSearchPage();
	}
	
	public TableDataSearchPage checkAvailableResultInTableWithFilters() {
		tableWithFilters.shouldNotBe(Condition.empty);
		return new TableDataSearchPage();
	}
	
	public TableDataSearchPage activateFiltersInTableWithFilters() {
		filterButtonInTableWithFilters.click();
		return new TableDataSearchPage();
	}
	
	public TableDataSearchPage checkNoResultFoundLabelInSimpleTable() {
		noResultsLabelInSimpleTable.shouldBe(Condition.visible);
		return new TableDataSearchPage();
	}
}
