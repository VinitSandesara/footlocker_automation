package com.footlocker.core;

// A "World" instance for sharing context between steps
public class PageContainer {

    private BasePage currentPage;

    public void updatePage(BasePage newPage) {
        currentPage = newPage;
    }

    public BasePage getPage() {
        return currentPage;
    }
}
