package com.seasy.ui.tests.ListBox.tests;

import com.seasy.ui.pages.listbox.JQueryDualListBoxPage;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.pages.ListBoxPageName;
import org.testng.annotations.Test;

public class JQueryDualListBoxTest extends BaseTest {
	
	@Test
	public void checkEmptyPickDataList() {
		openBrowser(ListBoxPageName.JQUERY_LISTBOX, JQueryDualListBoxPage.class)
				.addAllItemsToResultList()
				.checkPickDataListIsEmpty();
	}
	
	@Test
	public void checkItemsFromPickListAddedToResultList() {
		openBrowser(ListBoxPageName.JQUERY_LISTBOX, JQueryDualListBoxPage.class)
				.selectFewItemsFromPickList(3)
				.addItemsToResultList()
				.checkResultListIsNotEmpty();
	}
	
	@Test
	public void checkRemovingAllItemsFromResultList() {
		openBrowser(ListBoxPageName.JQUERY_LISTBOX, JQueryDualListBoxPage.class)
				.addAllItemsToResultList()
				.checkPickDataListIsEmpty()
				.checkResultListIsNotEmpty()
				.removeAllItemsFromResultList()
				.checkResultListIsEmpty()
				.checkPickDataListIsNotEmpty();
	}
	
	@Test
	public void checkRemovingFewItemsFromResultList() {
		openBrowser(ListBoxPageName.JQUERY_LISTBOX, JQueryDualListBoxPage.class)
				.addItemsToResultList()
				.selectFewItemsFromPickList(1)
				.addItemsToResultList()
				.checkResultListIsNotEmpty()
				.selectOneItemFromResultList()
				.removeItemsFromResultList()
				.checkResultListIsEmpty();
	}
	
}
