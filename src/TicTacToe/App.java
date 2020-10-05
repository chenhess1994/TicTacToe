/*
* @another Chen Hess
* @Date October 2020
*
* */
package TicTacToe;

import TicTacToe.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    private Stage primaryStage;

    public void play(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view(boundry)/tictactoe.fxml"));
            Parent root = (Parent) loader.load();
            Controller controller = loader.getController();

            //Functionality of reset nd close
            controller.resetButtonFunc(primaryStage);
            controller.closeButtonFunc(primaryStage);
            //
            primaryStage.setTitle("Tic Tac Toe");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch(IOException e) { e.printStackTrace(); }
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage=primaryStage;
        play();
    }
}
