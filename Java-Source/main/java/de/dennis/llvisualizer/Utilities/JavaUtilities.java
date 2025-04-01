package de.dennis.llvisualizer.Utilities;


import javafx.scene.paint.Color;

/**
 *  <h2>Utilities for Java and JavaFx to create graphical programs</h2>
 *  <p>
 *  These utilities are intended to simplify programming with Java/JavaFX
 *  and keep the code clean.
 *  <p>
 *  <h3>Infos for this specific version:</h3>
 *  <p>
 *  Nop, you don't have to know anything to use this.
 *  <p>
 * @author bauer
 * @version 1.0
 * @since 16.03.2024
 */

public class JavaUtilities {

    /**
     * IMPOERTANT:
     * To build a long string with fixed values, use the """ """ tactic.
     * You can create a string that spans multiple lines by simply using line breaks within the string.
     *
     * This method builds a long string using a string code that means a line break.
     * @param text Every string that is given here as input is called a line, so every new string is called a line break.
     * @return Returns the new String with the line breaks (String codes).
     */
    public static String buildLongText(String... text) {
        StringBuilder s = new StringBuilder();
        String[] strings = text;
        for (String string : strings) {
            s.append(string);
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * This method checks whether a string contains a number, or not.
     * @param s The string.
     * @return Returns true when the string is a number, false when not.
     */
    public static boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * This method turns a color value into a rgb string value (Import JavaFX Utillitie)
     * @param color The value to be changed.
     * @return Returns the new String with the rgb value.
     */
    public static String colorToRGB(Color color) {
        return String.format("rgb(%d, %d, %d)",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255)
        );
    }

}