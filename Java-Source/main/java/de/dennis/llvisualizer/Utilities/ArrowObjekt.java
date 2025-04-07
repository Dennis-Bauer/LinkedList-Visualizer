package de.dennis.llvisualizer.Utilities;


import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import static de.dennis.llvisualizer.Utilities.JavaFXConstructorUtilities.buildRectangle;
import static de.dennis.llvisualizer.Utilities.JavaFXConstructorUtilities.buildTriangle;

/**
 * This class creates an arrow. It simplifies the creation of arrows using the constructor,
 * where you can define the arrow length, size, and other important properties.
 *
 * @author Dennis Bauer
 * @version 1.0
 */
public class ArrowObjekt extends VBox {

    private final Polygon head;
    private final Rectangle bottom;

    /**
     * The constructor serves as the foundation of this class. It initializes and assembles
     * the different graphical components that together form a complete arrow.
     * @param id A unique identifier assigned to every graphical component within the arrow.
     * @param toPoint The coordinate or reference point to which the arrow is directed.
     * @param lengthLine Defines the length of the main arrow shaft (bottom part of the arrow).
     * @param widthLine Specifies the width of the shaft, determining its thickness.
     * @param lengthTop Represents the length of the arrowhead, which is the triangular tip of the arrow.
     * @param widthTop Determines the width of the arrowhead’s base, affecting its overall shape.
     * @param fill Defines the color of the entire arrow. All graphical components making up the arrow
     *             will share this color to maintain visual consistency.
     */
    public ArrowObjekt(String id, Point2D toPoint, double lengthLine, double widthLine, double lengthTop, double widthTop, Color fill) {
        // Stores the x and y coordinates of the toPoint variable in separate variables
        // to facilitate easier access and usage in calculations
        double pointX = toPoint.getX();
        double pointY = toPoint.getY();

        // The top of the arrow
        head = buildTriangle(
                id,
                toPoint,
                new Point2D(pointX + widthTop / 2, pointY + lengthTop),
                new Point2D(pointX - widthTop / 2, pointY + lengthTop),
                fill,
                null
        );

        // The bottom part (shaft) of the arrow
        bottom = buildRectangle(
                id,
                widthLine,
                lengthLine,
                fill,
                true,
                null,
                0
        );


        getChildren().addAll(head, bottom);
        setSpacing(-0.5);
        setAlignment(Pos.CENTER);
    }
}

