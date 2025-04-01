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

public class Main extends Application {

    public static final double WINDOW_WIDTH = 800;
    public static final double WINDOW_HEIGHT = 600;
    public static final String TEXT_FONT = "Arial";
    public static final double FONT_SIZE = (WINDOW_HEIGHT + WINDOW_WIDTH) * 0.015;

    // Color Palette
    public static final Color PRIMARY_FIRST = Color.web("#001f3f"); // Default: #001f3f
    public static final Color PRIMARY_SECOND = Color.web("#3a6d8c");;
    public static final Color SECONDARY_FIRST = Color.web("#6a9ab0");;
    public static final Color SECONDARY_SECOND = Color.web("#ead8b1");;


    // Debug/Variables
    public static final int MAX_INPUT_LENGTH = 3;
    public static final Color CURRENT_ARROW_COLOR = PRIMARY_FIRST; // Default: PRIMARY_SECOND
    public static final Color FIRST_LAST_ARROW_COLOR = PRIMARY_FIRST; // Default: PRIMARY_SECOND
    public static final Color CONTENT_COLOR_CURRENT = Color.GRAY; // Default: GRAY
    public static final Color CONTENT_COLOR_GOT = SECONDARY_SECOND; // Default: SECONDARY_SECOND
    public static final Color CONTENT_COLOR_NOTHING = SECONDARY_SECOND; // Default: SECONDARY_SECOND

    private static Scene primaryScene;

    @Override
    public void start(Stage stage) {

        primaryScene = new Scene(new StartScreen(), WINDOW_WIDTH, WINDOW_HEIGHT);

        stage.setTitle("List-Visualizer");
        stage.setScene(primaryScene);
        stage.show();
    }

    private static LinkedList primaryList;

    public static void createPreList() {
        createListView(2, true);

        for (int i = 0; i < 8; i++)
            primaryList.append(new ListElement((i * 2) + 3));
    }

    public static void createListView(int i, boolean createWithElement) {

        if (createWithElement) primaryList = new LinkedList(new ListElement(i));
        else primaryList = new LinkedList();

        // Input Box
        VBox inputBoxPane = new VBox();
        inputBoxPane.setAlignment(Pos.CENTER);

        Label inputBoxHeader = buildLabel("inputBox_Header", "Input", Font.font(TEXT_FONT, FontWeight.EXTRA_BOLD, FONT_SIZE * 1.5), TextAlignment.CENTER, SECONDARY_SECOND);
        TextField inputBox = buildTextField("inputListWithElement", "int", WINDOW_WIDTH * 0.31, WINDOW_HEIGHT * 0.125);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.setMaxWidth(WINDOW_WIDTH * 0.31);
        inputBox.setText("1");
        inputBox.setStyle("-fx-text-fill: " + colorToRGB(SECONDARY_SECOND) + ";");
        inputBox.setBackground(new Background(new BackgroundFill(PRIMARY_SECOND, null, null)));

        inputBoxPane.getChildren().addAll(inputBoxHeader, inputBox);

        // Output Label
        Rectangle outPutBackground = buildRectangle("outputLabel_Background", WINDOW_WIDTH * 0.32, WINDOW_HEIGHT * 0.08, SECONDARY_FIRST, true, null, 0);
        Label outputLabel = buildLabel("outputLabel", "Output: ___", Font.font(TEXT_FONT, FontWeight.EXTRA_BOLD, FONT_SIZE * 1.5), TextAlignment.CENTER, SECONDARY_SECOND);

        outPutBackground.setArcHeight(WINDOW_WIDTH * 0.07);
        outPutBackground.setArcWidth(WINDOW_WIDTH * 0.07);

        StackPane outputPane = new StackPane(outPutBackground, outputLabel);

        // Buttons
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

        // Actions
        getContentButton.setOnMouseClicked(_ -> {
                ListElement current = primaryList.getContentNode();
                if (current != null) outputLabel.setText("Output: " + current.getContent());

        });
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
        isEmptyButton.setOnMouseClicked(_ -> {
            if (primaryList.isEmpty()) outputLabel.setText("Output: true");
            else outputLabel.setText("Output: false");
        });
        hasCurrentAccess.setOnMouseClicked(_ -> {
            if (primaryList.hasCurrentAccess()) outputLabel.setText("Output: true");
            else outputLabel.setText("Output: false");
        });

        // With input
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

        root.setBackground(new Background(new BackgroundFill(PRIMARY_FIRST, null, null)));

        primaryScene.setRoot(root);
    }

    private static Button createStandardButton(String text) {
        return buildButton("listControlButton", text, WINDOW_WIDTH * 0.32, WINDOW_HEIGHT * 0.08, Font.font(TEXT_FONT, FontWeight.BOLD, FONT_SIZE));
    }


    public static void main(String[] args) {
        launch();
    }
}