package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    private RadioButton smallRb, largeRb, hugeRb;
    private TextField textField;
    private VBox root;
    private HBox radioHbox, textHBox;
    private ToggleGroup toggleGroup;

    @Override
    public void start(Stage primaryStage) throws Exception{
        toggleGroup = new ToggleGroup();
        RadioButtonHandler bh = new RadioButtonHandler();
        smallRb = new RadioButton("Small");
        smallRb.setOnAction(bh);
        smallRb.setToggleGroup(toggleGroup);
        largeRb = new RadioButton("Large");
        largeRb.setToggleGroup(toggleGroup);
        largeRb.setOnAction(bh);
        hugeRb = new RadioButton("Huge");
        hugeRb.setToggleGroup(toggleGroup);
        hugeRb.setOnAction(bh);
        textField = new TextField();
        textHBox = new HBox(textField);
        radioHbox = new HBox(20, smallRb,largeRb,hugeRb);
        root = new VBox(40,radioHbox,textHBox);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Demo");
        primaryStage.show();

    }

    private class RadioButtonHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            if(smallRb.isSelected()){
                textField.setFont(new Font(10));
            }
            else if(largeRb.isSelected()){
                textField.setFont(new Font(14));
            }
            else if(hugeRb.isSelected()){
                textField.setFont(new Font(16));
            }
            else{
                textField.setFont(new Font(12));
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
