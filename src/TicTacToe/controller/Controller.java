package TicTacToe.controller;

import TicTacToe.App;
import TicTacToe.entity.Matrix;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private StackPane root;

    @FXML
    private TextField statusEndGame;

    @FXML
    private Text center;

    @FXML
    private Text leftUp;

    @FXML
    private Text upCenter;

    @FXML
    private Text leftCenter;

    @FXML
    private Text upRight;

    @FXML
    private Text rightCenter;

    @FXML
    private Text buttomLeft;

    @FXML
    private Text buttomRight;

    @FXML
    private Text buttomCenter;

    @FXML
    private Button restart;

    @FXML
    private Button close;

    private int[][] board_game =new int[3][3];
    private Matrix matrix=new Matrix(board_game);
    private  Boolean x;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

            statusEndGame.setVisible(false);
            matrix.initMatrix();
            restart.setVisible(false);
            close.setVisible(false);
            x=true;
    }

    @FXML
    void ButtonClick(MouseEvent event) {
        pressed(event);
    }

    private void pressed(MouseEvent event){
        String press=((Text) event.getSource()).getId();
        boolean check=false;
        switch(press)
        {
            case "center":
                whoPressed(event,1, 1,center);
                break;
            case "leftCenter":
                whoPressed(event,1, 0,leftCenter);
                break;
            case "rightCenter":
                whoPressed(event,1, 2,rightCenter);
                break;
            case "upRight":
                whoPressed(event,0, 2,upRight);
                break;
            case "upCenter":
                whoPressed(event,0, 1,upCenter);
                break;
            case "leftUp":
                whoPressed(event,0, 0,leftUp);
                break;
            case "buttomLeft":
                whoPressed(event,2, 0,buttomLeft);
                break;
            case "buttomCenter":
                whoPressed(event,2, 1,buttomCenter);
                break;
            case "buttomRight":
                whoPressed(event,2, 2,buttomRight);
                break;
            default:
                break;
        }

        if(isWin()) {
            statusEndGame.setVisible(true);
            restart.setVisible(true);
            close.setVisible(true);
            statusEndGame.setStyle("-fx-text-fill: green;");
            check=true;
        }

        if(isfull() && !check) {
            statusEndGame.setVisible(true);
            statusEndGame.setText("Tie");
            restart.setVisible(true);
            close.setVisible(true);
            statusEndGame.setStyle("-fx-text-fill: red;");
        }
    }

    public void whoPressed(MouseEvent event,int i, int j,Text text){

        while(x) {
            if(event.getButton() == MouseButton.PRIMARY) {
                matrix.setValuedMatrix_X(i, j);
                drawX(text);
                x=false;
                statusEndGame.setText("X win");
            }
        }
        if(event.getButton() == MouseButton.SECONDARY) {
            matrix.setValuesMatrix_O(i, j);
            drawO(text);
            x=true;
            statusEndGame.setText("O win");
        }

    }

    private void drawX(Text text){
        text.setText(" X");
    }

    private void drawO(Text text){
        text.setText(" O");
    }

    public boolean isWin() {
        //Horizontal
        if((board_game[0][0]==1 && board_game[0][1]==1 && board_game[0][2]==1)||(board_game[0][0]==2 && board_game[0][1]==2 && board_game[0][2]==2))
            return true;
        if((board_game[1][0]==1 && board_game[1][1]==1 && board_game[1][2]==1)||(board_game[1][0]==2 && board_game[1][1]==2 && board_game[1][2]==2))
            return true;
        if((board_game[2][0]==1 && board_game[2][1]==1 && board_game[2][2]==1)||(board_game[2][0]==2 && board_game[2][1]==2 && board_game[2][2]==2))
            return true;

        //Vertical
        if((board_game[0][0]==1 && board_game[1][0]==1 && board_game[2][0]==1)||(board_game[0][0]==2 && board_game[1][0]==2 &&board_game[2][0]==2))
            return true;
        if((board_game[0][1]==1 && board_game[1][1]==1 && board_game[2][1]==1)||(board_game[0][1]==2 && board_game[1][1]==2 && board_game[2][1]==2))
            return true;
        if((board_game[0][2]==1 && board_game[1][2]==1 && board_game[2][2]==1)||(board_game[0][2]==2 && board_game[1][2]==2 && board_game[2][2]==2))
            return true;

        //diagonals
        //primary
        if((board_game[0][0]==1 && board_game[1][1]==1 && board_game[2][2]==1)||(board_game[0][0]==2 && board_game[1][1]==2 && board_game[2][2]==2))
            return true;
        //secondly
        if((board_game[0][2]==1 && board_game[1][1]==1 && board_game[2][0]==1)||(board_game[0][2]==2 && board_game[1][1]==2 && board_game[2][0]==2))
            return true;

        return false;
    }

    public void resetButtonFunc(Stage primaryStage){

        close.setOnAction( __ ->
        {
            System.out.println( "closing" );
            primaryStage.close();
        } );
    }
    public void closeButtonFunc(Stage primaryStage){

        restart.setOnAction( __ ->
        {
            System.out.println( "Restarting app!" );
            primaryStage.close();
            Platform.runLater( () -> {
                try {
                    new App().start( new Stage() );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } );
    }
    public boolean isfull(){
        int count=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board_game[i][j]==1 || board_game[i][j]==2)
                {
                    count++;
                }
            }
        }
       return count!=9?false:true;
    }

//    void printCheck(int[][] matrixtictactoe){
//
//        for (int i = 0; i <3 ; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(matrixtictactoe[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//    }

}
