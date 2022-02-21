package com.seasy.ui.tests.ListBox.tests;

import com.seasy.ui.pages.listbox.DataListFilterPage;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.pages.ListBoxPageName;
import org.testng.annotations.Test;

public class DataListFilterTests extends BaseTest {
	
	String PATH_TO_DATALIST = "src/main/java/com/seasy/ui/pages/utils/dataList.json";
	
	@Test
	public void checkNamesFromFile() {
		openBrowser(ListBoxPageName.DATALIST_FILTER, DataListFilterPage.class)
				.checkNamesFromList(PATH_TO_DATALIST);
	}
	
}
