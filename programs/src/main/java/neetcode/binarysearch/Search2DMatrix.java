package neetcode.binarysearch;

public class Search2DMatrix {
    public static void main(String[] args) {
        Search2DMatrix s2m = new Search2DMatrix();
        int[][] twoDMatrix = new int[][]{{1,3,5,7,6},{10,11,16,20},{23,30,34,60}};
        s2m.searchMatrix(twoDMatrix, 3);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(target<matrix[0][0]||target>matrix[matrix.length-1][matrix.length-1])
            return false;

        int ls = matrix[0][0];
        int le = matrix[0][matrix[0].length-1];
        int rs = matrix[matrix.length-1][0];
        int re = matrix[matrix.length-1][matrix[matrix.length-1].length-1];

        int left = matrix[0][matrix[0].length-1];
        int right = matrix[matrix.length-1][matrix[matrix.length-1].length-1];
        while(ls<re)
        {
            int midRow = (matrix.length)/2;

            int midStart = matrix[midRow][0];
            int midEnd = matrix[midRow][matrix[midRow].length-1];
            if(target>midEnd)
            {
                left = matrix[midRow+1][matrix[midRow+1].length-1];
            }
            else if(target<midStart)
            {
                right = matrix[midRow-1][matrix[midRow-1].length-1];
            }
            else {
                //TODO BinarySearch on the middle row.
                return true;
            }
        }
        for(int row=0;row<matrix.length;row++){
//            int left =
//            while(matrix[row][])
//            for(int col=0;col<matrix[row].length;col++){
//                if
//            }
        }
        return false;
    }
}
