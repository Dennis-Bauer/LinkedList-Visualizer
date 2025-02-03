package de.dennis.llvisualizer;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public static final double WINDOW_WIDTH = 800;
    public static final double WINDOW_HEIGHT = 600;
    public static final String TEXT_FONT = "Arial";
    public static final double FONT_SIZE = (WINDOW_HEIGHT + WINDOW_WIDTH) * 0.015;

    // Debug/Variables
    public static final int MAX_INPUT_LENGTH = 3;
    public static final Color CURRENT_ARROW_COLOR = Color.INDIANRED; // Default: INDIANRED
    public static final Color FIRST_LAST_ARROW_COLOR = Color.BLUE; // Default: BLUE
    public static final Color CONTENT_COLOR_CURRENT = Color.GRAY; // Default: GRAY
    public static final Color CONTENT_COLOR_GOT = Color.WHITE; // Default: WHITE
    public static final Color CONTENT_COLOR_NOTHING = Color.BLACK; // Default: BLACK

    @Override
    public void start(Stage stage) throws IOException {

    }

    public static void main(String[] args) {
        launch();
    }

}