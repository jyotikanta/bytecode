package neetcode.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Insert {
    public static void main(String[] args) {
        Insert heap = new Insert();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(null,12,6,40,30,5,35,10,15,45));
        //[null, 45, 40, 15, 35, 10, 12, 6, 5, 30]
        //[null, 35, 10, 5, 6, 30, 15, 45, 40, 12]
        //[null, 45, 40, 35, 30, 10, 5, 15, 6, 12]
        //Collections.shuffle(a);
        System.out.println(a);
        for(int i=2;i<a.size();i++){
            heap.insertIntoHeap(a, i);
        }
        System.out.println(a);
    }

    public void insertIntoHeap(ArrayList<Integer> a, int index){
        while(index>1 && a.get(index)>=a.get(index/2)){
            int tmp = a.get(index);
            a.set(index, a.get(index/2));
            a.set(index/2, tmp);
            index/=2;
        }
    }
}
