package leetcode.contests;

import java.util.*;

public class Solutions {
    public static void main(String[] args) {
        System.out.println(winningPlayerCount(4,new int[][]{{0,8},{0,3}}));
        System.out.println(minFlips(new int[][]{{1,0,0},{0,0,0},{0,0,1}}));
        System.out.println(minFlips(new int[][]{{1},{0}}));
    }
    public static int winningPlayerCount(int n, int[][] pick) {




        System.out.println(Character.getNumericValue('7'));
        HashMap<Integer, HashMap<Integer,Integer>> pmap = new HashMap<>();
        int totalWinner = 0;
        HashSet<Integer> winner = new HashSet<>();
        for(int[] player:pick){
            Integer xi = player[0];
            Integer yi = player[1];
            HashMap<Integer,Integer> cmap = pmap.getOrDefault(xi, new HashMap<>());
            pmap.put(xi,pmap.getOrDefault(xi,cmap));
            cmap.put(yi,pmap.get(xi).getOrDefault(yi,0)+1);
            pmap.put(xi, cmap);
            if(player[0]<pmap.get(xi).get(yi)){
                winner.add(xi);
            }
        }
        return winner.size();

    }

    public static int minFlips(int[][] grid) {
        int totalMinRow = 0;
        for(int[] gridRow: grid){
            int i=0;
            int j=gridRow.length-1;
            int min = 0;
            while(i<j){
                if(gridRow[i]!=gridRow[j]){
                    min++;
                }
                i++;
                j--;
            }
            totalMinRow+=min;
        }
        int totalMinCol = 0;
        int row = grid.length;
        for(int c=0;c<grid[0].length;c++)
        {
            int i = 0;
            int j = row-1;
            int min = 0;
            while(i<j){
                if(grid[i][c]!=grid[j][c]){
                    min++;
                }
                i++;
                j--;
            }
            totalMinCol+=min;
        }
        return Math.min(totalMinRow, totalMinCol);
    }
}