package neetcode.sorting;

import java.util.ArrayList;
import java.util.List;

public class DemoArrayList {

    public static void main(String[] args) {
        List<Pair> originalList = new ArrayList<>();
        originalList.add(new Pair(1,"Apple"));
        originalList.add(new Pair(2,"Banana"));
        originalList.add(new Pair(6,"Orange"));
        originalList.add(new Pair(3,"Grapes"));
        originalList.add(new Pair(5,"Mango"));
        originalList.add(new Pair(4,"Lemon"));

        //System.out.println("Sublist: " + originalList.subList(0,originalList.size()/2));
        //System.out.println("Sublist: " + originalList.subList(originalList.size()/2,originalList.size()));
    }

    public List<Pair> mergeSort(List<Pair> pairs) {
        if(pairs.size() == 1){
            return pairs;
        }
        mergeSort(pairs.subList(0,pairs.size()/2));
        mergeSort(pairs.subList(pairs.size()/2,pairs.size()));

        merge(pairs, 0, pairs.size()/2, pairs.size());
        return pairs;
    }

    public void merge(List<Pair> pairs, int s, int m, int e) {
        System.out.println("Original List: " + pairs);
    }
}
