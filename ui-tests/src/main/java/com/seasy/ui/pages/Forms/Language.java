package com.seasy.ui.pages.Forms;

public enum Language {
    PHYTON("Phyton", "Scripting languages"),
    PHP("PHP", "Scripting languages"),
    RUBY("Ruby", "Scripting languages");

    String category;
    String value;

    Language(String language, String languageType){
        this.value = language;
        this.category = languageType;
    }
}
