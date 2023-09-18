package com.example.mail.model;

public class Mail {

    private String language;
    private int pageSize;
    private String signature;
    private boolean spamFilter;

    public Mail(){
    }

    public Mail(String language, int pageSize, String signature, boolean spamFilter) {
        this.language = language;
        this.pageSize = pageSize;
        this.signature = signature;
        this.spamFilter = spamFilter;
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