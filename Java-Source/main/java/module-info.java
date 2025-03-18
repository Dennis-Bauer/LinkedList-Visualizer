module de.dennis.llvisualizer {
    requires javafx.controls;
    requires javafx.fxml;

    opens de.dennis.llvisualizer to javafx.fxml;
    exports de.dennis.llvisualizer;
}