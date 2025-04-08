package de.dennis.llvisualizer.Panes;

import de.dennis.llvisualizer.Main;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import static de.dennis.llvisualizer.Utilities.JavaFXConstructorUtilities.buildButton;
import static de.dennis.llvisualizer.Utilities.JavaFXConstructorUtilities.buildTextField;
import static de.dennis.llvisualizer.Utilities.JavaUtilities.buildLongText;
import static de.dennis.llvisualizer.Utilities.JavaUtilities.isStringInt;

/**
 * This class represents the start screens.
 * The start screens are the screens, which does not contain a list.
 *
 * @author Dennis Bauer
 * @version 1.0
 */

public class StartScreen extends Pane {

    // These constants define the size of the buttons
    private final double BUTTON_WIDTH = Main.WINDOW_WIDTH / 2;
    private final double BUTTON_X = Main.WINDOW_WIDTH / 2 - BUTTON_WIDTH / 2;

    /**
     * This constructor sets the necessary styles for the start screen, creates the buttons,
     * and handles their event interactions.
     */
    public StartScreen() {
        setBackground(new Background(new BackgroundFill(Main.FIRST_COLOR, null, null)));
        Button creatListButton = buildButton("createListButton", "Erstelle List", BUTTON_WIDTH, Main.WINDOW_HEIGHT / 4, Font.font(Main.TEXT_FONT, FontWeight.BOLD, Main.FONT_SIZE * 2), BUTTON_X, Main.WINDOW_HEIGHT * 0.2);
        Button loadPreList = buildButton("loadPreListButton", "Lade Test List", BUTTON_WIDTH, Main.WINDOW_HEIGHT / 4, Font.font(Main.TEXT_FONT, FontWeight.BOLD, Main.FONT_SIZE * 2), BUTTON_X, Main.WINDOW_HEIGHT * 0.5);

        getChildren().addAll(creatListButton, loadPreList);

        creatListButton.setOnMouseClicked(_ -> showCreateMenu());

        loadPreList.setOnMouseClicked(_ -> Main.createPreList());
    }

    /**
     * This function sets up the create menu by adding the two buttons for the
     * different list constructors. It also handles the event listeners for these buttons.
     */
    private void showCreateMenu() {
        getChildren().clear();

        Button createListWithElement = buildButton("createListButton_WithElement", buildLongText("Erstelle Linked-List mit Element", "public LinkedList(ListElement firstElement)"), BUTTON_WIDTH * 1.25, Main.WINDOW_HEIGHT * 0.25, Font.font(Main.TEXT_FONT, FontWeight.BOLD, Main.FONT_SIZE) , BUTTON_X - (BUTTON_WIDTH * 0.25) / 2, Main.WINDOW_HEIGHT * 0.2);
        createListWithElement.setTextAlignment(TextAlignment.CENTER);
        createListWithElement.setOnMouseClicked(_ -> createListWithElement());

        Button createListWithOutElement = buildButton("createListButton_WithOutElement", buildLongText("Erstelle Linked-List ohne Element", "public LinkedList()"), BUTTON_WIDTH, Main.WINDOW_HEIGHT * 0.25, Font.font(Main.TEXT_FONT, FontWeight.BOLD, Main.FONT_SIZE) , BUTTON_X, Main.WINDOW_HEIGHT * 0.5);
        createListWithOutElement.setTextAlignment(TextAlignment.CENTER);
        createListWithOutElement.setOnMouseClicked(_ -> createList());

        getChildren().addAll(createListWithElement, createListWithOutElement);
    }

    /**
     * This function creates the input screen for when the user wants to create a list
     * with a first element.
     */
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

    /**
     * This function simply calls the method in the main class that creates the list itself.
     */
    private void createList() {
        Main.createListView(0, false);
    }

}
