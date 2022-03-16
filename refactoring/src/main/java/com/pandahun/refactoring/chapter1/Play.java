package com.pandahun.refactoring.chapter1;

public class Play {

    private final String playId;
    private final String name;
    private final PlayType type;

    public Play(String playId, String name, PlayType type) {
        this.playId = playId;
        this.name = name;
        this.type = type;
    }

    public String getPlayId() {
        return playId;
    }

    public String getName() {
        return name;
    }

    public PlayType getType() {
        return type;
    }
}
