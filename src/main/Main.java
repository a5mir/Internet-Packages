package main;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       URL fxmlUrl = getClass().getClassLoader().getResource("fxml/ui.fxml");
       VBox root = FXMLLoader.<VBox>load(fxmlUrl);
       
       Scene scene = new Scene(root);
       scene.getStylesheets().add("css/styles.css");
       primaryStage.setTitle("Internet packages");
       primaryStage.setResizable(false);
       primaryStage.setScene(scene);
       primaryStage.show();
       
        
    }
    
    public static void main(String[] args){
        launch(args);
    }

    
    
}
