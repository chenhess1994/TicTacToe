package TicTacToe.entity;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Matrix {
    /*X-is 1 IN MATRIX   O-IS 2 IN MATRIX  */
   private final int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void initMatrix(){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                matrix[i][j]=0;
    }

    public void setValuedMatrix_X(int i, int j) {
        matrix[i][j]=1;
    }

    public void setValuesMatrix_O(int i, int j) {
        matrix[i][j]=2;
    }
}
