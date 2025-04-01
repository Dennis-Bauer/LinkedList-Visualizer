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
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import static de.dennis.llvisualizer.Utilities.JavaFXConstructorUtilities.buildLabel;
import static de.dennis.llvisualizer.Utilities.JavaFXConstructorUtilities.buildRectangle;

public class ElementObjekt extends HBox {

    private final String CONTENT_ADDON = "";
    private final String CONTENT_NOTHING = "X";

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

    public ElementObjekt(int content) {

        this.content = content;

        // Content
        Rectangle backgroundRectangle = buildRectangle("graphicObject_Background", Main.WINDOW_WIDTH * 0.08, Main.WINDOW_WIDTH * 0.08, Color.BLACK, false, Color.WHITE, 0);
        contentLabel = buildLabel("graphicObject_Text", (CONTENT_ADDON + CONTENT_NOTHING + CONTENT_ADDON), Font.font(Main.TEXT_FONT, FontWeight.BOLD, Main.FONT_SIZE), TextAlignment.CENTER, Main.SECONDARY_SECOND);

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

    public void setCurrentArrowVisible(boolean isVisible) {
        currentArrow.setVisible(isVisible);

        if (isVisible) {
            contentLabel.setTextFill(Main.CONTENT_COLOR_CURRENT);
            contentLabel.setText(content + "");
        }
        else {
            contentLabel.setTextFill(Main.CONTENT_COLOR_NOTHING);
            contentLabel.setText(CONTENT_NOTHING);
        }
    }

    public void getContent() {
        contentLabel.setTextFill(Main.CONTENT_COLOR_GOT);
        contentLabel.setText(content + "");
    }

    public void setContent(int i) {
        contentLabel.setText(CONTENT_ADDON + i + CONTENT_ADDON);
        contentLabel.setTextFill(Main.CONTENT_COLOR_CURRENT);

        this.content = i;
    }

    public void setPosArrowVisible(boolean isVisible) {
        posArrow.setVisible(isVisible);
        if (!isVisible) contentArrowObj.setVisible(true);
    }

    public void setPosArrowToFirst() {
        posArrowLabel.setText("First");
        contentArrowObj.setVisible(true);
    }

    public void setPosArrowToLast() {
        posArrowLabel.setText("Last");
        contentArrowObj.setVisible(false);
    }

    public void setPosArrowToBoth() {
        posArrowLabel.setText("First & Last");
        contentArrowObj.setVisible(false);
    }

}
