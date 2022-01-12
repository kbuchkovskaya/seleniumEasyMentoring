package com.seasy.ui.tests.TableTests;

import com.seasy.ui.tests.BaseTest;
import org.testng.annotations.Test;

public class TablePaginationTests extends BaseTest {

    @Test
    public void checkActiveButtons(){
        openTablePaginationPage()
                .clickNextPage()
                .checkPreviousAndNextButtons();
    }

    @Test
    public void checkQuantityOfRowsPerPage(){
        openTablePaginationPage()
                .checkQuantityOfRows();
    }
}
