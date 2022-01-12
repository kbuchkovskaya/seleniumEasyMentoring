package com.seasy.ui.tests.TableTests;

import com.seasy.ui.tests.BaseTest;
import org.testng.annotations.Test;
import static com.seasy.ui.pages.Table.FilterName.*;

public class TableDataSearchTests extends BaseTest {

    @Test
    public void checkFilterInSimpleTable(){
        openTableDataSearchPage()
                .searchDataInSimpleTable("Jane");
    }

    @Test
    public void removingDataAfterSearchingInSimpleTable(){
        openTableDataSearchPage()
                .searchDataInSimpleTable("Jane")
                .removeDataFromFilterInSimpleTable()
                .checkEmptyFilterInSimpleTable();
    }

    @Test
    public void checkFiltersInTableWithFilters(){
        openTableDataSearchPage()
                .activateFiltersInTableWithFilters()
                .filterRowsTableWithFilters(NUMBER, "4")
                .filterRowsTableWithFilters(USERNAME, "mikesali")
                .filterRowsTableWithFilters(FIRSTNAME, "Byron")
                .filterRowsTableWithFilters(LASTNAME, "Katha");

    }

}
