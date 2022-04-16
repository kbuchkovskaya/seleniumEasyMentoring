package com.seasy.ui.pages.services;

import java.util.ArrayList;
import java.util.List;

public class Storage {
	
	List<String> list = new ArrayList<>();
	
	public void addItemInDataList(String string) {
		list.add(string);
	}

	public List<String> getList() {
		return list;
	}
}
