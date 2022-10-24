package com.example.learnhibernate.controller;

import com.example.learnhibernate.model.PageType;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "mainController")
@SessionScoped
public class MainController implements Serializable {
    @Inject
    private Conversation conversation;

    private PageType pageType;

    public MainController() {
        pageType = PageType.Main;
    }

    public PageType getPageType() {
        return pageType;
    }

    public void setPageType(PageType pageType) {
        this.pageType = pageType;
    }

    public boolean isOnPage(PageType pageType) {
        return this.pageType == pageType;
    }

    public void changePage(PageType pageType) {
        if (this.pageType == PageType.Main && pageType != PageType.Main) {
            conversation.begin();
        }
        this.pageType = pageType;
        if (this.pageType == PageType.Main) {
            conversation.end();
        }
    }

    public String getConversationId() {
        if (!conversation.isTransient()) {
            return conversation.getId();
        } else {
            return "";
        }
    }
}

