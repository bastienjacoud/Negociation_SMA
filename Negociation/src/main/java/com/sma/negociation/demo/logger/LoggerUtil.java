package com.sma.negociation.demo.logger;

public class LoggerUtil {

    /**
     *
     * @param stringToColor
     * @param color
     * @return chaine colorée
     */
    public static String coloredString(CharSequence stringToColor, LoggerUtil.Color color) {
        return String.format("%s%s%s", color.getValue(), stringToColor, Color.ANSI_RESET.getValue());
    }

    public static String infoString(CharSequence stringToColor){
        return coloredString(stringToColor, Color.ANSI_BLUE);
    }

    public static String warningString(CharSequence stringToColor){
        return coloredString(stringToColor, Color.ANSI_YELLOW);
    }

    public static String errorString(CharSequence stringToColor){
        return coloredString(stringToColor, Color.ANSI_RED);
    }

    /**
     * Couleurs utilisées
     */
    public enum Color {
        ANSI_RED("\u001B[31m"),
        ANSI_BLUE("\u001B[34m"),
        ANSI_RESET("\u001B[0m"),
        ANSI_YELLOW("\u001B[33m");

        private String value;

        Color(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
