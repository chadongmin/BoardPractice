package com.myportfolio.board.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PageHandlerTest {
    @Test
    public void test(){
        PageHandler ph = new PageHandler(250, 10);
        ph.print();
        System.out.println("BeginPage = " + ph.getBeginPage());
    }
}