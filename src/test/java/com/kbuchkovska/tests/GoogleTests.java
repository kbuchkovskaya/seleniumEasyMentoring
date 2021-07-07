package com.kbuchkovska.tests;

import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTests {
    @Test
    public void searchKeyword(){
        open("https://www.google.com.ua/");
        $("input[title=\"Пошук\"]").setValue("Soft serve").pressEnter();
    }
}
