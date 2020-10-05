package TicTacToe.controller;

import TicTacToe.App;
import TicTacToe.entity.Matrix;
import TicTacToe.entity.ArrayPlaces;
import javafx.animation.PauseTransition;
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
import javafx.util.Duration;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private StackPane root;

    @FXML
    private StackPane seconfFrame;

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

    private final int[][] board_game =new int[3][3];
    private final Matrix matrix=new Matrix(board_game);
    private final Random rand=new Random();
    private final ArrayPlaces[] place=ArrayPlaces.values();
    private boolean x=true;
    private int sum_x=0;
    private int sum_y=0;
    private  App app=new App();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            statusEndGame.setVisible(false);
            matrix.initMatrix();
            restart.setVisible(false);
            close.setVisible(false);
    }
    @FXML
    void ButtonClick(MouseEvent event)  {
        String press=((Text) event.getSource()).getId();
        switch(press)
        {
            case "center":
                PlaceXandO(event,1, 1,center);
                break;
            case "leftCenter":
                PlaceXandO(event,1, 0,leftCenter);
                break;
            case "rightCenter":
                PlaceXandO(event,1, 2,rightCenter);
                break;
            case "upRight":
                PlaceXandO(event,0, 2,upRight);
                break;
            case "upCenter":
                PlaceXandO(event,0, 1,upCenter);
                break;
            case "leftUp":
                PlaceXandO(event,0, 0,leftUp);
                break;
            case "buttomLeft":
                PlaceXandO(event,2, 0,buttomLeft);
                break;
            case "buttomCenter":
                PlaceXandO(event,2, 1,buttomCenter);
                break;
            case "buttomRight":
                PlaceXandO(event,2, 2,buttomRight);
                break;
            default:
                break;
        }
    }

    public void PlaceXandO(MouseEvent event, int i, int j, Text text) {
        if(isFull())  return;

        if (event.getButton() == MouseButton.PRIMARY) {
            while (board_game[i][j] != 2 && board_game[i][j] != 1 && x) {
                x = false;
                matrix.setValuedMatrix_X(i, j);
                drawX(text);
                if (isWin()) enables("green", "player  win");

                randomWaitFunc();
            }
        }

    }
    public void randomlyPressed()  {
        int[] indexes;
        int i, j;

        while(!x) {
            if(isFull()) return;
            indexes = ArrayPlaces.indexesInBoard(random_choose().toString());
            i = indexes[0];
            j = indexes[1];
            while (board_game[i][j] !=0 ) {
                indexes = ArrayPlaces.indexesInBoard(random_choose().toString());
                i = indexes[0];
                j = indexes[1];
            }
            matrix.setValuesMatrix_O(i, j);
            drawO(getTextPress(ArrayPlaces.values()[indexes[2]].toString()));
            x=true;
            if(isWin())
                enables("green", "computer win");
        }
    }
    public Text getTextPress(String place){
        switch(place)
        {
            case "center":
                return center;
            case "leftCenter":
                return leftCenter;
            case "rightCenter":
                return rightCenter;
            case "upRight":
                return upRight;
            case "upCenter":
                return  upCenter;
            case "leftUp":
                return leftUp;
            case "buttomLeft":
                return buttomLeft;
            case "buttomCenter":
                return buttomCenter;
            case "buttomRight":
                return buttomRight;
            default:
                break;
        }
        return null;
    }
    public ArrayPlaces random_choose(){
        //computer choose randomally the place of O.
        return place[rand.nextInt(place.length)];
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

        restart.setOnAction( __ ->
        {
            System.out.println( "Restarting app!" );
            primaryStage.close();
            try {
                app.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } );
    }
    public void closeButtonFunc(Stage primaryStage){
        close.setOnAction( __ ->
        {
            System.out.println( "closing" );
            //primaryStage.close();
            Platform.exit();
        } );

    }
    public boolean isFull(){
        //parameters
        int n = 3;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if(board_game[i][j]==0)
                    return false;

       enables("red", "tie");
       return true;
    }
    private void enables(String color,String winOrTie) {
        seconfFrame.setDisable(true);
        statusEndGame.setText(winOrTie);
        close.setVisible(true);
        restart.setVisible(true);
        statusEndGame.setStyle("-fx-text-fill: "+color+";");
        statusEndGame.setVisible(true);
        return;
    }
    public void randomWaitFunc() {
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e -> randomlyPressed());
        pause.play();
    }
//    void printCheck(int[][] matrix){
//        for (int i = 0; i <3 ; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }

//TODO:if i want in the feutere to do a button with choosen  this is the algorithem.
    //              while(x) {
    //                if(event.getButton() == MouseButton.PRIMARY) {
    //                     matrix.setValuedMatrix_X(i, j);
    //                      drawX(text);
    //                      x=false;
    //                     statusEndGame.setText("X win");
    //            }
    //
    //        }
    //
    //        if(event.getButton() == MouseButton.SECONDARY) {
    //            matrix.setValuesMatrix_O(i, j);
    //            drawO(text);
    //            x=true;
    //            statusEndGame.setText("O win");
    //        }
}
