package com.pandahun.refactoring.chapter1;

public enum PlayType {

    TRAGEDY("tragedy"),
    COMEDY("comedy");

    private final String playType;

    PlayType(String playType) {
        this.playType = playType;
    }

    public String getPlayType() {
        return playType;
    }
}
