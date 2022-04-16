package com.seasy.ui.tests.table;

import com.seasy.ui.pages.User;
import com.seasy.ui.pages.table.TableDataSearchPage;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.pages.TablePageName;
import org.testng.annotations.Test;

import static com.seasy.ui.pages.table.FilterName.*;

public class TableDataSearchTests extends BaseTest {
	
	User userForTasksTable = new User.Builder()
			.withFirstName("Jane")
			.build();
	
	User userForListedUsersTable = new User.Builder()
			.withFirstName("Byron")
			.withLastName("Katha")
			.withId("4")
			.withUserName("mikesali")
			.build();
	
	@Test
	public void checkFilterInSimpleTable() {
		openBrowser(TablePageName.TABLE_DATA_SEARCH, TableDataSearchPage.class)
				.searchDataInSimpleTable(userForTasksTable.getFirstName())
				.checkSimpleTableIsNotEmpty();
	}
	
	@Test
	public void removingDataAfterSearchingInSimpleTable() {
		openBrowser(TablePageName.TABLE_DATA_SEARCH, TableDataSearchPage.class)
				.searchDataInSimpleTable(userForTasksTable.getFirstName())
				.removeDataFromFilterInSimpleTable()
				.checkEmptyFilterInSimpleTable();
	}
	
	@Test
	public void checkFiltersInTableWithFilters() {
		openBrowser(TablePageName.TABLE_DATA_SEARCH, TableDataSearchPage.class)
				.activateFiltersInTableWithFilters()
				.filterRowsTableWithFilters(NUMBER, userForListedUsersTable.getId())
				.filterRowsTableWithFilters(USERNAME, userForListedUsersTable.getUserName())
				.filterRowsTableWithFilters(FIRSTNAME, userForListedUsersTable.getFirstName())
				.filterRowsTableWithFilters(LASTNAME, userForListedUsersTable.getLastName())
				.checkAvailableResultInTableWithFilters();
		
	}
	
}
