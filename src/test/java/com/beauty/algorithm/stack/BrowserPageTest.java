package com.beauty.algorithm.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BrowserPageTest {

    @Test
    public void test() {
        BrowserPage browserPage = new BrowserPage("A");
        browserPage.next("B");
        browserPage.next("C");

        assertEquals("C", browserPage.currentPage());

        browserPage.forward();
        assertEquals("C", browserPage.currentPage());

        browserPage.back();
        assertEquals("B", browserPage.currentPage());

        browserPage.back();
        browserPage.back();
        assertNull(browserPage.currentPage());

        browserPage.back();
        assertNull(browserPage.currentPage());

        browserPage.forward();
        assertEquals("A", browserPage.currentPage());

        browserPage.next("Z");
        browserPage.forward();
        assertEquals("Z", browserPage.currentPage());
    }

}