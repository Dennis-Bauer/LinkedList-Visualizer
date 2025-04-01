package de.dennis.llvisualizer.Panes;

import de.dennis.llvisualizer.ListElement;
import de.dennis.llvisualizer.Main;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ListView extends HBox {

    private final ArrayList<ElementObjekt> nodeList = new ArrayList<>();

    public ListView() {
        setBackground(new Background(new BackgroundFill(Main.SECONDARY_FIRST, null, null)));

        setSpacing(Main.WINDOW_WIDTH * 0.01);

        // space between scrollPane and node rectangle
        setPadding(new Insets(Main.WINDOW_HEIGHT * 0.025));
    }

    public void addNode(ListElement e, int pos) {
        nodeList.add(pos - 1,  e.getGraphicObject());

        if (pos >= getChildren().size()) getChildren().addLast(nodeList.get(pos - 1));
        else getChildren().add(pos, nodeList.get(pos - 1));
    }

    public void removeNode(int pos) {
        nodeList.remove(pos - 1);
        getChildren().remove(pos - 1);
    }

}
