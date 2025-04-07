package de.dennis.llvisualizer.Panes;

import de.dennis.llvisualizer.ListElement;
import de.dennis.llvisualizer.Main;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

/**
 * This class represents the graphical list.
 * It contains all the elements and manages the functionality for adding and removing elements,
 * ensuring that the correct element is added or removed.
 *
 * @author Dennis Bauer
 * @version 1.0
 */

public class ListView extends HBox {

    // List containing all graphical elements of the list.
    private final ArrayList<ElementObjekt> nodeList = new ArrayList<>();

    /**
     * This constructor applies the necessary styles to the list itself.
     */
    public ListView() {
        setBackground(new Background(new BackgroundFill(Main.SECONDARY_FIRST, null, null)));

        setSpacing(Main.WINDOW_WIDTH * 0.01);

        // space between scrollPane and node rectangle
        setPadding(new Insets(Main.WINDOW_HEIGHT * 0.025));
    }

    /**
     * This method adds an element to the list at the specified position.
     * The position is determined by the provided `pos` parameter.
     * @param e The list element to be added
     * @param pos The position where the element should be inserted
     */
    public void addNode(ListElement e, int pos) {
        nodeList.add(pos - 1,  e.getGraphicObject());

        if (pos >= getChildren().size()) getChildren().addLast(nodeList.get(pos - 1));
        else getChildren().add(pos, nodeList.get(pos - 1));
    }

    /**
     * Removes the list element at the specified position.
     * The position is determined by the provided `pos` parameter.
     * @param pos The position of the element to be removed
     */
    public void removeNode(int pos) {
        nodeList.remove(pos - 1);
        getChildren().remove(pos - 1);
    }

}
