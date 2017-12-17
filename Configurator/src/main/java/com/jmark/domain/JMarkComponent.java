package com.jmark.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum JMarkComponent {
    J_BUTTON("JButton",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.BACKGROUND, JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION)),
    J_RADIO_BUTTON("JRadioButton",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.BACKGROUND, JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION,
                    JMarkActions.FOREGROUND)),
    J_CHECK_BOX("JCheckBox",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.BACKGROUND, JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION,
                    JMarkActions.FOREGROUND)),
    J_LABEL("JLabel",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.BACKGROUND, JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION,
                    JMarkActions.FOREGROUND)),
    J_TEXT_FIELD("JTextField",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.BACKGROUND, JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION,
                    JMarkActions.FOREGROUND)),
    J_PASSWORD_FIELD("JPasswordField",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.BACKGROUND, JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION,
                    JMarkActions.FOREGROUND)),
    J_FORMATTED_TEXT_FIELD("JFormattedTextField",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.BACKGROUND, JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION,
                    JMarkActions.FOREGROUND)),
    J_TEXT_AREA("JTextArea",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.BACKGROUND, JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION,
                    JMarkActions.FOREGROUND)),
    J_TEXT_PANE("JTextPane",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.BACKGROUND, JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION,
                    JMarkActions.FOREGROUND)),
    J_EDITOR_PANE("JEditorPane",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.BACKGROUND, JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION,
                    JMarkActions.FOREGROUND)),
    J_COMBO_BOX("JComboBox",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.BACKGROUND, JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION,
                    JMarkActions.FOREGROUND)),
    J_TABLE("JTable",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.BACKGROUND, JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION,
                    JMarkActions.FOREGROUND)),
    J_LIST("JList",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.BACKGROUND, JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION,
                    JMarkActions.FOREGROUND)),
    J_TREE("JTree",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.BACKGROUND, JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION,
                    JMarkActions.FOREGROUND)),
    J_TABBED_PANE("JTabbedPane",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION)),
    J_SPLIT_PANE("JSplitPane",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE)),
    J_SPINNER("JSpinner",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.FONT, JMarkActions.ACTION)),
    J_SLIDER("JSlider",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.FONT, JMarkActions.ACTION)),
    J_SEPARATOR("JSeparator",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE)),
    J_PROGRESS_BAR("JProgressBar",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION, JMarkActions.FOREGROUND)),
    J_TOOL_BAR("JToolBar",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.BACKGROUND)),
    J_SCROLL_BAR("JScrollBar",
            Arrays.asList(JMarkActions.CLICK, JMarkActions.ENABLE, JMarkActions.VISIBLE,
                    JMarkActions.BACKGROUND, JMarkActions.TEXT, JMarkActions.FONT, JMarkActions.ACTION)),
    J_SCROLL_PANE("JScrollPane",
            Arrays.asList(JMarkActions.CLICK));

    private String name;
    private List<JMarkActions> actions;

    JMarkComponent(String name, List<JMarkActions> actions) {
        this.name = name;
        this.actions = actions;
    }

    public String getName() {
        return name;
    }

    public List<JMarkActions> getActions() {
        return Collections.unmodifiableList(actions);
    }

    public static JMarkComponent findComponentByName(String name) {
        for (JMarkComponent component : values()) {
            if (name.equals(component.getName())) {
                return component;
            }
        }

        return null;
    }
}
