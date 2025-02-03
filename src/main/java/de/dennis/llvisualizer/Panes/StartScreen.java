package de.dennis.llvisualizer.Panes;

import de.dennis.llvisualizer.Main;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import static de.dennis.llvisualizer.Utilities.JavaFXConstructorUtilities.buildButton;
import static de.dennis.llvisualizer.Utilities.JavaFXConstructorUtilities.buildTextField;
import static de.dennis.llvisualizer.Utilities.JavaUtilities.buildLongText;
import static de.dennis.llvisualizer.Utilities.JavaUtilities.isStringInt;

public class StartScreen extends Pane {

    private final double BUTTON_WIDTH = Main.WINDOW_WIDTH / 2;
    private final double BUTTON_X = Main.WINDOW_WIDTH / 2 - BUTTON_WIDTH / 2;

    public StartScreen() {
        Button creatListButton = buildButton("createListButton", "Erstelle List", BUTTON_WIDTH, Main.WINDOW_HEIGHT / 4, Font.font(Main.TEXT_FONT, FontWeight.BOLD, Main.FONT_SIZE * 2), BUTTON_X, Main.WINDOW_HEIGHT * 0.2);
        Button loadPreList = buildButton("loadPreListButton", "Lade Test List", BUTTON_WIDTH, Main.WINDOW_HEIGHT / 4, Font.font(Main.TEXT_FONT, FontWeight.BOLD, Main.FONT_SIZE * 2), BUTTON_X, Main.WINDOW_HEIGHT * 0.5);

        getChildren().addAll(creatListButton, loadPreList);

        creatListButton.setOnMouseClicked(_ -> showCreateMenu());

        loadPreList.setOnMouseClicked(_ -> Main.createPreList());
    }

    private void showCreateMenu() {
        getChildren().clear();

        Button createListWithElement = buildButton("createListButton_WithElement", buildLongText("Erstelle List mit Element", "public List(ListElement firstElement)"), BUTTON_WIDTH * 1.25, Main.WINDOW_HEIGHT * 0.25, Font.font(Main.TEXT_FONT, FontWeight.BOLD, Main.FONT_SIZE) , BUTTON_X - (BUTTON_WIDTH * 0.25) / 2, Main.WINDOW_HEIGHT * 0.2);
        createListWithElement.setTextAlignment(TextAlignment.CENTER);
        createListWithElement.setOnMouseClicked(_ -> createListWithElement());

        Button createListWithOutElement = buildButton("createListButton_WithOutElement", buildLongText("Erstelle List ohne Element", "public List()"), BUTTON_WIDTH, Main.WINDOW_HEIGHT * 0.25, Font.font(Main.TEXT_FONT, FontWeight.BOLD, Main.FONT_SIZE) , BUTTON_X, Main.WINDOW_HEIGHT * 0.5);
        createListWithOutElement.setTextAlignment(TextAlignment.CENTER);
        createListWithOutElement.setOnMouseClicked(_ -> createList());

        getChildren().addAll(createListWithElement, createListWithOutElement);
    }

    private void createListWithElement() {
        getChildren().clear();

        TextField inputBox = buildTextField("inputListWithElement", "int", BUTTON_WIDTH * 0.5, Main.WINDOW_HEIGHT * 0.3, BUTTON_X + (BUTTON_WIDTH * 0.5) / 2, Main.WINDOW_HEIGHT * 0.1);
        inputBox.setAlignment(Pos.CENTER);

        Button createList = buildButton("createListButton", "Erstelle List", BUTTON_WIDTH, Main.WINDOW_HEIGHT * 0.2, Font.font(Main.TEXT_FONT, FontWeight.BOLD, Main.FONT_SIZE * 2) , BUTTON_X, Main.WINDOW_HEIGHT * 0.55);
        createList.setOnMouseClicked(_ -> {
            if (!inputBox.getText().isEmpty() && isStringInt(inputBox.getText()) && inputBox.getText().length() <= Main.MAX_INPUT_LENGTH)
                Main.createListView(Integer.parseInt(inputBox.getText()), true);
        });

        getChildren().addAll(inputBox, createList);
    }

    private void createList() {
        Main.createListView(0, false);
    }

}
