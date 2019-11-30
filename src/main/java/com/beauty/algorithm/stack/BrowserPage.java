package com.beauty.algorithm.stack;

public class BrowserPage {

    private Stack<String> backPages;
    private Stack<String> forwardPages;

    public BrowserPage(String startPage) {
        backPages = new ArrayStack<>(10);
        forwardPages = new ArrayStack<>(10);
        backPages.push(startPage);
    }

    public void next(String newPage) {
        backPages.push(newPage);
        // 清空前进页面数据
        if (!forwardPages.isEmpty()) {
            forwardPages = new ArrayStack<>(10);
        }
    }

    public String forward() {
        String page = forwardPages.pop();
        if (page != null) {
            backPages.push(page);
        }
        return page;
    }

    public String back() {
        String page = backPages.pop();
        if (page != null) {
            forwardPages.push(page);
        }
        return page;
    }

    public String currentPage() {
        return backPages.peak();
    }

}
