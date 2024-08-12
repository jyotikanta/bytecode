package neetcode;

public class RangeSumQuery2D {

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2,1,4,3));
        System.out.println(numMatrix.sumRegion(1,1,2,2));
        System.out.println(numMatrix.sumRegion(1,2,2,4));
        System.out.println(numMatrix.sumRegion(0,0,4,4));
    }
}

class NumMatrix {
    int[][] prefixMatrix;
    int sum = 0;
    int rows,cols;
    public NumMatrix(int[][] matrix) {
        rows = matrix.length;
        cols = rows>0 ? matrix[0].length : 0;
        prefixMatrix = new int[rows][cols];
        for(int i=0;i<rows;i++){
            prefixMatrix[i][0] = matrix[i][0];
            for(int j=1;j<cols;j++){
                prefixMatrix[i][j] = prefixMatrix[i][j-1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int row=row1;row<=row2;row++){
            if(col1==0){
                sum+=prefixMatrix[row][col2];
            }else{
                sum += (prefixMatrix[row][col2]-prefixMatrix[row][col1-1]);
            }
        }
        return sum;
    }
}
