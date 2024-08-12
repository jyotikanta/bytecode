package neetcode.graphs;

public class MatrixDFS {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}
        };
        System.out.println(new MatrixDFS().countPaths(grid));
    }
    int rows = 0;
    int cols = 0;
    public int countPaths(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int[][] visited = new int[grid.length][grid[0].length];
        return countPaths(grid, 0, 0, visited);
    }
    public int countPaths(int[][] grid, int r, int c, int[][] visited){
        if(Math.min(r,c)<0 || r==rows || c==cols || visited[r][c]==1 || grid[r][c]==1){
            return 0;
        }
        if(r==rows-1 && c==cols-1){
                return 1;
        }

        visited[r][c] = 1;
        int count = 0;

        count += countPaths(grid, r+1, c, visited);
        count += countPaths(grid, r-1, c, visited);
        count += countPaths(grid, r, c+1, visited);
        count += countPaths(grid, r, c-1, visited);

        visited[r][c] = 0;
        return count;
    }
}
