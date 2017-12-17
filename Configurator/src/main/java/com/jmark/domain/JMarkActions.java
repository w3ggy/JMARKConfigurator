package com.jmark.domain;

public enum JMarkActions {
    CLICK("Click"),
    ENABLE("Enable"),
    VISIBLE("Visible"),
    BACKGROUND("Background"),
    FOREGROUND("Foreground"),
    TEXT("Text"),
    FONT("Font"),
    ACTION("Action");

    private String name;

    JMarkActions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static JMarkActions findComponentByName(String name) {
        for (JMarkActions action : values()) {
            if (name.equals(action.getName())) {
                return action;
            }
        }

        return null;
    }
}
