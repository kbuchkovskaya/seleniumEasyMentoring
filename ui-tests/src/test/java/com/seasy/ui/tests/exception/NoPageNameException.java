package com.seasy.ui.tests.exception;

public class NoPageNameException extends Exception{

    private static final String ABSENT_PAGE_LINK = "Link to page is absent in path.txt";

    public NoPageNameException(){
        super(ABSENT_PAGE_LINK);
    }

}
