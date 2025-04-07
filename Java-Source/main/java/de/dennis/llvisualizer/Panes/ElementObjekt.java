package de.dennis.llvisualizer.Panes;

import de.dennis.llvisualizer.Main;
import de.dennis.llvisualizer.Utilities.ArrowObjekt;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import static de.dennis.llvisualizer.Utilities.JavaFXConstructorUtilities.buildLabel;
import static de.dennis.llvisualizer.Utilities.JavaFXConstructorUtilities.buildRectangle;

/**
 * This class represents a single element in a list.
 * It controls all graphical aspects of the element.
 * All arrows are also created here, since they don't actually move in the program—
 * they are simply shown or hidden as needed.
 *
 * @author Dennis Bauer
 * @version 1.0
 */

public class ElementObjekt extends HBox {

    // If you want to add something around the content of an element, you can do it here.
    private final String CONTENT_ADDON = "";

    // This is the symbol shown when the content is hidden. You can put an 'N' in it to always display the number.
    private final String CONTENT_NOTHING = "X"; // Default: X

    // Content
    private final StackPane contentRectanglePane;
    private final Label contentLabel;
    private final VBox contentPane;
    private int content;

    // Programm Arrows
    private final ArrowObjekt currentArrow = new ArrowObjekt("currentArrow", new Point2D(0, 0), Main.WINDOW_HEIGHT * 0.045, Main.WINDOW_WIDTH * 0.01, Main.WINDOW_HEIGHT * 0.03, Main.WINDOW_WIDTH * 0.025, Main.CURRENT_ARROW_COLOR);
    private final VBox posArrow;
    private final Label posArrowLabel = buildLabel("posArrow_label", "First", Font.font(Main.TEXT_FONT, FontWeight.BOLD, Main.FONT_SIZE * 0.7), TextAlignment.CENTER, Main.SECONDARY_SECOND);

    // Content Arrow
    private final ArrowObjekt contentArrowObj;

    /**
     * This constructor creates the graphical element. It initializes the different graphical components that together form the visual list element and its arrows.
     * @param content The content value to be displayed. It is only used if the placeholder for hidden content is set to 'N'.
     */
    public ElementObjekt(int content) {

        this.content = content;

        // Content
        Rectangle backgroundRectangle = buildRectangle("graphicObject_Background", Main.WINDOW_WIDTH * 0.08, Main.WINDOW_WIDTH * 0.08, Color.BLACK, false, Color.WHITE, 0);
        contentLabel = buildLabel("graphicObject_Text", (CONTENT_ADDON + CONTENT_NOTHING + CONTENT_ADDON), Font.font(Main.TEXT_FONT, FontWeight.BOLD, Main.FONT_SIZE), TextAlignment.CENTER, Main.SECONDARY_SECOND);

        if (CONTENT_NOTHING.equals("N")) contentLabel.setText(CONTENT_ADDON + content + CONTENT_ADDON);

        contentRectanglePane = new StackPane(backgroundRectangle, contentLabel);

        // Current Arrow
        Label currentArrowLabel = buildLabel("currentArrow_label", "Current", Font.font(Main.TEXT_FONT, FontWeight.BOLD, Main.FONT_SIZE * 0.7), TextAlignment.CENTER, Main.SECONDARY_SECOND);
        currentArrow.getChildren().add(currentArrowLabel);

        //Pos Arrow
        ArrowObjekt posArrowObj = new ArrowObjekt("posArrow", new Point2D(0, 0), Main.WINDOW_HEIGHT * 0.045, Main.WINDOW_WIDTH * 0.008, Main.WINDOW_HEIGHT * 0.03, Main.WINDOW_WIDTH * 0.025, Main.FIRST_LAST_ARROW_COLOR);
        posArrowObj.setRotate(180);

        posArrow = new VBox(-0.5, posArrowLabel, posArrowObj);
        posArrow.setAlignment(Pos.CENTER);

        // Content Pane
        contentPane = new VBox(posArrow, contentRectanglePane, currentArrow);

        // Content Arrow
        contentArrowObj = new ArrowObjekt("contentArrow", new Point2D(0, 0), Main.WINDOW_HEIGHT * 0.025, Main.WINDOW_WIDTH * 0.003, Main.WINDOW_HEIGHT * 0.015, Main.WINDOW_WIDTH * 0.0125, Main.PRIMARY_FIRST);
        contentArrowObj.setRotate(90);

        getChildren().addAll(contentPane, contentArrowObj);
        setSpacing(-0.1);

        setCurrentArrowVisible(false);
        setPosArrowVisible(false);
    }

    /**
     * Shows or hides the current pointer arrow and highlights the content accordingly.
     * @param isVisible Determines whether the current arrow should be visible.
     */
    public void setCurrentArrowVisible(boolean isVisible) {
        currentArrow.setVisible(isVisible);

        if (isVisible) {
            contentLabel.setTextFill(Main.CONTENT_COLOR_CURRENT);
            contentLabel.setText(content + "");
        }
        else {
            contentLabel.setTextFill(Main.CONTENT_COLOR_NOTHING);
            contentLabel.setText(CONTENT_NOTHING);
            if (CONTENT_NOTHING.equals("N")) contentLabel.setText(CONTENT_ADDON + content + CONTENT_ADDON);
        }
    }

    /**
     * Displays the content of the list element visually, allowing the getContent function to be represented without using the console.
     */
    public void getContent() {
        contentLabel.setTextFill(Main.CONTENT_COLOR_GOT);
        contentLabel.setText(content + "");
    }

    /**
     * Updates the content by changing both the displayed text and the internal variable.
     * @param newContent The new content to be saved
     */
    public void setContent(int newContent) {
        contentLabel.setText(CONTENT_ADDON + newContent + CONTENT_ADDON);
        contentLabel.setTextFill(Main.CONTENT_COLOR_CURRENT);

        this.content = newContent;

    }

    /**
     * Sets the visibility of the first and last arrow.
     * If it is not visible, it indicates the element is neither at the beginning nor the end,
     * and the content arrow (the one pointing to the next node) should be visible instead.
     * @param isVisible Determines whether the first and last arrows should be visible.
     */
    public void setPosArrowVisible(boolean isVisible) {
        posArrow.setVisible(isVisible);
        if (!isVisible) contentArrowObj.setVisible(true);
    }

    /**
     * Sets the position arrow text to "First" and makes the content arrow visible (the one pointing to the next node).
     * If the node is only the first element, it indicates there must be a next element.
     */
    public void setPosArrowToFirst() {
        posArrowLabel.setText("First");
        contentArrowObj.setVisible(true);
    }

    /**
     * Sets the position arrow text to "Last" and hides the content arrow (the one pointing to the next node).
     * If the node is the last element, it indicates there is no next element.
     */
    public void setPosArrowToLast() {
        posArrowLabel.setText("Last");
        contentArrowObj.setVisible(false);
    }

    /**
     * Sets the position arrow text to "First & Last" and hides the content arrow (the one pointing to the next node).
     * If the node is both the first and last element, there is no next element.
     */
    public void setPosArrowToBoth() {
        posArrowLabel.setText("First & Last");
        contentArrowObj.setVisible(false);
    }

}

