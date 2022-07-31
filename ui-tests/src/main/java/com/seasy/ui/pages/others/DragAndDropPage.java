package com.seasy.ui.pages.others;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DragAndDropPage {
	
	private final SelenideElement dropElement = $("#mydropzone");
	
	private final ElementsCollection itemsToDrag = $$("#todrag span");
	private final ElementsCollection droppedItemsList = $$("#droppedlist span");
	
	Random random = new Random();
	
	public DragAndDropPage dragItemToList(int quantityOfDroppedItems) {
		for (int i = 0; i < quantityOfDroppedItems; i++) {
			int randomItem = random.nextInt(itemsToDrag.size());
			itemsToDrag.get(randomItem).dragAndDropTo(dropElement);
		}
		return new DragAndDropPage();
	}
	
	public DragAndDropPage checkDroppedListOfItemsNotEmpty() {
		droppedItemsList.shouldHave(CollectionCondition.sizeGreaterThan(0));
		return new DragAndDropPage();
	}
	
}
