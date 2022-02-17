package com.seasy.ui.tests.table.tests;

import com.seasy.ui.pages.table.TablePaginationPage;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.pages.TablePageName;
import org.testng.annotations.Test;

public class TablePaginationTests extends BaseTest {

    @Test
    public void checkActiveButtons(){
        openBrowser(TablePageName.TABLE_PAGINATION, TablePaginationPage.class)
                .clickNextPage()
                .checkPreviousAndNextButtons();
    }

    @Test
    public void checkQuantityOfRowsPerPage(){
        openBrowser(TablePageName.TABLE_PAGINATION, TablePaginationPage.class)
                .checkQuantityOfRows();
    }
}
