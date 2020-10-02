package TicTacToe.entity;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Matrix {

   private final int[][] matrix;
   /*
   * X-is 1 IN MATRIX
   * O-IS 2 IN MATRIX
   */
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void initMatrix(){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                matrix[i][j]=0;
    }

    public int getValuenMatrix(int i,int j) {
        return matrix[i][j];
    }

    public void setValuedMatrix_X(int i, int j) {
        matrix[i][j]=1;
    }

    public void setValuesMatrix_O(int i, int j) {
        matrix[i][j]=2;
    }
}
