package com.example.mail.model;

public class Mail {
    private int id;

    private String language;
    private int pageSize;
    private String signature;
    private boolean spamFilter;

    public Mail() {
    }

    public Mail(int id, String language, int pageSize, String signature, boolean spamFilter) {
        this.id = id;
        this.language = language;
        this.pageSize = pageSize;
        this.signature = signature;
        this.spamFilter = spamFilter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }
}