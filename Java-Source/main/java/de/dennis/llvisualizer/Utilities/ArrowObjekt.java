package de.dennis.llvisualizer.Utilities;


import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import static de.dennis.llvisualizer.Utilities.JavaFXConstructorUtilities.buildRectangle;
import static de.dennis.llvisualizer.Utilities.JavaFXConstructorUtilities.buildTriangle;

public class ArrowObjekt extends VBox {

    private final Polygon head;
    private final Rectangle bottom;

    public ArrowObjekt(String id, Point2D toPoint, double lengthLine, double widthLine, double lengthTop, double widthTop, Color fill) {
        double pointX = toPoint.getX();
        double pointY = toPoint.getY();

        head = buildTriangle(
                id,
                toPoint,
                new Point2D(pointX + widthTop / 2, pointY + lengthTop),
                new Point2D(pointX - widthTop / 2, pointY + lengthTop),
                fill,
                null
        );

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

