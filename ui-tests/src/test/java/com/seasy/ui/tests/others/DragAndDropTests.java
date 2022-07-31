package com.seasy.ui.tests.others;

import com.seasy.ui.pages.others.DragAndDropPage;
import com.seasy.ui.tests.BaseTest;
import com.seasy.ui.tests.utils.pages.OthersPageName;
import org.testng.annotations.Test;

public class DragAndDropTests extends BaseTest {
	
	@Test
	public void checkPossibleDragAndDropFunctionality(){
		openBrowser(OthersPageName.DRAG_AND_DROP, DragAndDropPage.class)
				.dragItemToList(3)
				.checkDroppedListOfItemsNotEmpty();
	}
	
}
