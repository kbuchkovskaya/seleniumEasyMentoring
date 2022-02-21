package com.seasy.ui.tests.table.tests;

import com.seasy.ui.pages.table.TableDataSearchPage;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.pages.TablePageName;
import org.testng.annotations.Test;

import static com.seasy.ui.pages.table.FilterName.*;

public class TableDataSearchTests extends BaseTest {
	
	@Test
	public void checkFilterInSimpleTable() {
		openBrowser(TablePageName.TABLE_DATA_SEARCH, TableDataSearchPage.class)
				.searchDataInSimpleTable("Jane");
	}
	
	@Test
	public void removingDataAfterSearchingInSimpleTable() {
		openBrowser(TablePageName.TABLE_DATA_SEARCH, TableDataSearchPage.class)
				.searchDataInSimpleTable("Jane")
				.removeDataFromFilterInSimpleTable()
				.checkEmptyFilterInSimpleTable();
	}
	
	@Test
	public void checkFiltersInTableWithFilters() {
		openBrowser(TablePageName.TABLE_DATA_SEARCH, TableDataSearchPage.class)
				.activateFiltersInTableWithFilters()
				.filterRowsTableWithFilters(NUMBER, "4")
				.filterRowsTableWithFilters(USERNAME, "mikesali")
				.filterRowsTableWithFilters(FIRSTNAME, "Byron")
				.filterRowsTableWithFilters(LASTNAME, "Katha")
				.checkAvailableResultInTableWithFilters();
		
	}
	
}
