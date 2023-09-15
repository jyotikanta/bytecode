/*
package neetcode.binarysearch;

public class Search2DMatrix {
    public static void main(String[] args) {
        Search2DMatrix s2m = new Search2DMatrix();
        int[][] twoDMatrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        s2m.searchMatrix(twoDMatrix, 3);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(target<matrix[0][0]||target>matrix[matrix.length-1][matrix.length-1])
            return false;

        int left = matrix[0][matrix.length-1];
        int right = matrix[matrix.length-1][matrix.length-1];
        while(left<right)
        {
            int midRow = (matrix.length-1)/2;
            int mid = matrix[midRow][matrix.length-1];
            if(target>mid)
            {
                left = matrix[midRow+1][matrix.length-1];
            }
            else
            {
                right = matrix[midRow-1][matrix.length-1];
            }
        }
        for(int row=0;row<matrix.length;row++){
            int left =
            while(matrix[row][])
            for(int col=0;col<matrix[row].length;col++){
                if
            }
        }
        return false;
    }
}
*/
