package com.seasy.ui.pages.Table;

public enum FilterName {

    NUMBER("#"),
    USERNAME("Username"),
    LASTNAME("Last Name"),
    FIRSTNAME("First Name");

    String value;

    FilterName (String fieldName){
        this.value = fieldName;
    }

}
