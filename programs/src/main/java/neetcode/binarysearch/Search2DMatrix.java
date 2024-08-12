package neetcode.binarysearch;

public class Search2DMatrix {
    public static void main(String[] args) {
        Search2DMatrix s2m = new Search2DMatrix();
        int[][] twoDMatrix = new int[][]{{-8,-8},{-5,-3},{0,2},{4,4},{6,8}};
        System.out.println(s2m.searchMatrix(twoDMatrix, 5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(target<matrix[0][0]||target>matrix[matrix.length-1][matrix[0].length-1])
            return false;

        int ls = matrix[0][0];
        int le = matrix[0][matrix[0].length-1];
        int rs = matrix[matrix.length-1][0];
        int re = matrix[matrix.length-1][matrix[matrix.length-1].length-1];

        int left = 0;
        int right = matrix.length;
        int midRow = right/2;
        while(ls<re)
        {

            int midStart = matrix[midRow][0];
            int midEnd = matrix[midRow][matrix[midRow].length-1];

            if(target==midEnd||target==midStart){
                return true;
            }

            if(target>midEnd)
            {
                left = midRow+1;
                ls = matrix[midRow+1][0];
            }
            else if(target<midStart)
            {
                right = midRow-1;
                re = matrix[midRow-1][matrix[midRow].length-1];
            }
            else{
                for(int i=0;i<matrix[0].length;i++){
                    if(target==matrix[midRow][i]){
                        return true;
                    }
                }
                return false;
            }
            midRow = (left + right) / 2;

        }
        for(int i=0;i<matrix[0].length;i++){
            if(target==matrix[midRow][i]){
                return true;
            }
        }
        return false;
    }
}
