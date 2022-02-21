package com.seasy.ui.pages.listbox;

import com.codeborne.selenide.ElementsCollection;
import com.seasy.ui.pages.services.JsonParser;

import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

public class DataListFilterPage {
	
	private final ElementsCollection name = $$(".info-block.block-info h4");
	
	public DataListFilterPage checkNamesFromList(String path) {
		JsonParser parser = new JsonParser();
		assertThat(name.texts())
				.asList()
				.containsAll(parser.getListNamesFromJson(path));
		return new DataListFilterPage();
	}
	
}
