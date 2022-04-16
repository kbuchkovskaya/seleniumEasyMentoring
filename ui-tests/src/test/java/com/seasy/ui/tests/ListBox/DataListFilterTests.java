package com.seasy.ui.tests.ListBox;

import com.seasy.ui.pages.listbox.DataListFilterPage;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.files.Path;
import com.seasy.ui.tests.utils.pages.ListBoxPageName;
import org.testng.annotations.Test;

public class DataListFilterTests extends BaseTest {
	
	@Test
	public void checkNamesFromFile() {
		openBrowser(ListBoxPageName.DATALIST_FILTER, DataListFilterPage.class)
				.checkNamesFromList(Path.PATH_TO_DATALIST);
	}
	
}
