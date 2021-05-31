/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foldercreator;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Invasor_zim
 */
public class FolderCreator extends Application {
    private static Scene mainScene;

    public static Scene getMainScene() {
        return mainScene;
    }
    
    @Override
    public void start(Stage primaryStage) {
   try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/foldercreator/gui/FolderView.fxml"));
            AnchorPane anchorPane = loader.load();
            mainScene = new Scene(anchorPane);
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Folder Creator 1.0 - Desenvolvido por Jeffeson Reis");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
