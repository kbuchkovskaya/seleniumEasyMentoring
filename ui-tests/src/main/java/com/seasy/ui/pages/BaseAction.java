package com.seasy.ui.pages;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.actions;

public class BaseAction {

    public void keyDownControlButton(){
        actions().keyDown(Keys.CONTROL).perform();
    }

    public void keyUpControlButton(){
        actions().keyUp(Keys.CONTROL).perform();
    }

    public void pressBackSpace(){
        actions().keyDown(Keys.BACK_SPACE);
    }
}
