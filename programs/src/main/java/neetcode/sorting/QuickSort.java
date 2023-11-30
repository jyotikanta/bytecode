package neetcode.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    public static void main(String[] args) {
        List<Pair> originalList = new ArrayList<>();
        originalList.add(new Pair(3,"Cat"));
        originalList.add(new Pair(2,"Dog"));
        originalList.add(new Pair(3,"Bird"));
        QuickSort qs = new QuickSort();
        qs.quickSort(originalList);
        for (Pair p:originalList
             ) {
            System.out.println(p.key +" : "+ p.value);
        }
    }
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSortHelper(pairs,0,pairs.size()-1);
        return pairs;
    }

    public void quickSortHelper(List<Pair> pairs, int s, int e) {
        if(e-s+1<=1){
            return;
        }
        int left = s;
        Pair pivot = pairs.get(e);

//        9 2 7 5 1 6;
//        2 9 7 5 1 6;
        for(int i = s; i < e; i++){
            if(pairs.get(i).key<pivot.key){
                Pair temp = pairs.get(left);
                pairs.set(left, pairs.get(i));
                pairs.set(i, temp);
                left++;
            }
        }
        pairs.set(e, pairs.get(left));
        pairs.set(left, pivot);


        quickSortHelper(pairs,s,left-1);
        quickSortHelper(pairs,left+1,e);
    }
}
