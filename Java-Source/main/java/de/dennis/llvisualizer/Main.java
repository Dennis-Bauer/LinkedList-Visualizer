package de.dennis.llvisualizer;

import de.dennis.llvisualizer.Panes.StartScreen;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import static de.dennis.llvisualizer.Utilities.JavaFXConstructorUtilities.*;
import static de.dennis.llvisualizer.Utilities.JavaUtilities.colorToRGB;
import static de.dennis.llvisualizer.Utilities.JavaUtilities.isStringInt;

/**
 * This class is the core of the project. It contains all application variables that control the size and design of the application.
 * It is also where the buttons are created and where their action listeners are added.
 *
 * @author Dennis Bauer
 * @version 2.0
 */

public class Main extends Application {

    // Application settings
    public static final double WINDOW_WIDTH = 800;
    public static final double WINDOW_HEIGHT = 600;
    public static final String TEXT_FONT = "Arial";
    public static final double FONT_SIZE = (WINDOW_HEIGHT + WINDOW_WIDTH) * 0.015;

    // Color Palette
    public static final Color FIRST_COLOR = Color.web("#27374D"); // Default: #27374D
    public static final Color SECOND_COLOR = Color.web("#526D82"); // Default: #526D82
    public static final Color THIRD_COLOR = Color.web("#9DB2BF"); // Default: #9DB2BF
    public static final Color FOUR_COLOR = Color.web("#DDE6ED"); // Default: #DDE6ED

    // Debug/Variables
    public static final int MAX_INPUT_LENGTH = 3;
    public static final Color CURRENT_ARROW_COLOR = THIRD_COLOR; // Default: THIRD_COLOR
    public static final Color FIRST_LAST_ARROW_COLOR = THIRD_COLOR; // Default: THIRD_COLOR
    public static final Color CONTENT_COLOR_CURRENT = Color.GRAY; // Default: GRAY
    public static final Color CONTENT_COLOR_GOT = FOUR_COLOR; // Default: FOUR_COLOR
    public static final Color CONTENT_COLOR_NOTHING = FOUR_COLOR; // Default: FOUR_SECOND

    private static Scene primaryScene;

    // Start function
    @Override
    public void start(Stage stage) {

        primaryScene = new Scene(new StartScreen(), WINDOW_WIDTH, WINDOW_HEIGHT);

        stage.setTitle("List-Visualizer");
        stage.setScene(primaryScene);
        stage.show();
    }

    // Main list object
    private static LinkedList primaryList;

    // Generates the pre-set list
    public static void createPreList() {
        createListView(2, true);

        for (int i = 0; i < 8; i++)
            primaryList.append(new ListElement((i * 2) + 3));
    }

    /**
     * This method initializes the entire program, including the buttons and the list view.
     * @param val The value of the first element, used if the list is created with an initial element.
     * @param createWithElement Determines which constructor of LinkedList is called.
     */
    public static void createListView(int val, boolean createWithElement) {

        // Create the linked list using the constructor determined by the createWithElement variable
        if (createWithElement) primaryList = new LinkedList(new ListElement(val));
        else primaryList = new LinkedList();

        // Create Input-Box
        VBox inputBoxPane = new VBox();
        inputBoxPane.setAlignment(Pos.CENTER);

        Label inputBoxHeader = buildLabel("inputBox_Header", "Input", Font.font(TEXT_FONT, FontWeight.EXTRA_BOLD, FONT_SIZE * 1.5), TextAlignment.CENTER, FOUR_COLOR);
        TextField inputBox = buildTextField("inputListWithElement", "int", WINDOW_WIDTH * 0.31, WINDOW_HEIGHT * 0.125);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.setMaxWidth(WINDOW_WIDTH * 0.31);
        inputBox.setText("1");
        inputBox.setStyle("-fx-text-fill: " + colorToRGB(FOUR_COLOR) + ";");
        inputBox.setBackground(new Background(new BackgroundFill(SECOND_COLOR, null, null)));

        inputBoxPane.getChildren().addAll(inputBoxHeader, inputBox);

        // Create Output-Label
        Rectangle outPutBackground = buildRectangle("outputLabel_Background", WINDOW_WIDTH * 0.32, WINDOW_HEIGHT * 0.08, SECOND_COLOR, true, null, 0);
        Label outputLabel = buildLabel("outputLabel", "Output: ___", Font.font(TEXT_FONT, FontWeight.EXTRA_BOLD, FONT_SIZE * 1.5), TextAlignment.CENTER, FOUR_COLOR);

        outPutBackground.setArcHeight(WINDOW_WIDTH * 0.07);
        outPutBackground.setArcWidth(WINDOW_WIDTH * 0.07);

        StackPane outputPane = new StackPane(outPutBackground, outputLabel);

        // Create Buttons
        Button appendButton = createStandardButton("append(Content)");
        Button setContentButton = createStandardButton("setContent(Content)");
        Button insertButton = createStandardButton("insert(Content)");
        Button removeButton = createStandardButton("remove()");
        Button getContentButton = createStandardButton("getContent()");
        Button toFirstButton = createStandardButton("toFirst()");
        Button toLastButton = createStandardButton("toLast()");
        Button nextButton = createStandardButton("next()");
        Button isEmptyButton = createStandardButton("isEmpty()");
        Button hasCurrentAccess = createStandardButton("hasCurrentAccess()");

        // Button actions
        removeButton.setOnMouseClicked(_ -> {
            primaryList.remove();
        });
        nextButton.setOnMouseClicked(_ -> {
            primaryList.next();
        });
        toLastButton.setOnMouseClicked(_ -> {
            primaryList.toLast();
        });
        toFirstButton.setOnMouseClicked(_ -> {
            primaryList.toFirst();
        });

        // Button actions with output
        getContentButton.setOnMouseClicked(_ -> {
            ListElement current = primaryList.getContentNode();
            if (current != null) outputLabel.setText("Output: " + current.getContent());
        });
        isEmptyButton.setOnMouseClicked(_ -> {
            if (primaryList.isEmpty()) outputLabel.setText("Output: true");
            else outputLabel.setText("Output: false");
        });
        hasCurrentAccess.setOnMouseClicked(_ -> {
            if (primaryList.hasCurrentAccess()) outputLabel.setText("Output: true");
            else outputLabel.setText("Output: false");
        });

        // Button actions with input
        appendButton.setOnMouseClicked(_ -> {
            if (!inputBox.getText().isEmpty() && isStringInt(inputBox.getText()) && inputBox.getText().length() <= Main.MAX_INPUT_LENGTH)
                primaryList.append(new ListElement(Integer.parseInt(inputBox.getText())));
        });
        insertButton.setOnMouseClicked(_ -> {
            if (!inputBox.getText().isEmpty() && isStringInt(inputBox.getText()) && inputBox.getText().length() <= Main.MAX_INPUT_LENGTH)
                primaryList.insert(new ListElement(Integer.parseInt(inputBox.getText())));
        });
        setContentButton.setOnMouseClicked(_ -> {
            if (!inputBox.getText().isEmpty() && isStringInt(inputBox.getText()) && inputBox.getText().length() <= Main.MAX_INPUT_LENGTH)
                primaryList.setContentFromNode(Integer.parseInt(inputBox.getText()));
        });

        // Placing the elements
        double buttonSpacing = WINDOW_HEIGHT * 0.01;
        HBox buttonPane = new HBox(buttonSpacing,
                new VBox(buttonSpacing,
                        nextButton,
                        toFirstButton,
                        toLastButton
                ),
                new VBox(buttonSpacing,
                        appendButton,
                        insertButton,
                        removeButton,
                        hasCurrentAccess
                ),
                new VBox(buttonSpacing,
                        setContentButton,
                        getContentButton,
                        isEmptyButton,
                        outputPane
                )
        );

        buttonPane.setAlignment(Pos.CENTER);

        VBox root = new VBox(WINDOW_HEIGHT * 0.02,
                primaryList,
                buttonPane,
                inputBoxPane
        );

        root.setBackground(new Background(new BackgroundFill(FIRST_COLOR, null, null)));

        primaryScene.setRoot(root);
    }

    /**
     * This method creates the method buttons with the same size. The style is defined in the utility class.
     * @param text The name of the button.
     * @return Returns the fully created button object.
     */
    private static Button createStandardButton(String text) {
        return buildButton("listControlButton", text, WINDOW_WIDTH * 0.32, WINDOW_HEIGHT * 0.08, Font.font(TEXT_FONT, FontWeight.BOLD, FONT_SIZE));
    }

    // Main method
    public static void main(String[] args) {
        launch();
    }
}