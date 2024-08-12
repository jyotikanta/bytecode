package neetcode.slidingwindow;

import java.util.HashMap;

public class PermutaionInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> s1Map = new HashMap<>();
        char[] s1Arr = s1.toCharArray();
        for(int i=0;i<s1.length();i++){
            s1Map.put(s1Arr[i], s1Map.getOrDefault(s1Arr[i],0)+1);
        }

        char[] s2Arr = s2.toCharArray();
        HashMap<Character,Integer> s2Map = new HashMap<>();
        int L=0;
        for(int R=0;R<s2.length();R++){
            s2Map.put(s2Arr[R], s2Map.getOrDefault(s2Arr[R],0)+1);
            if(R-L+1==s1.length()){
                //check if both map has same number of elements
                if(s1Map.equals(s2Map)){
                    return true;
                }
                else{
                    s2Map.put(s2Arr[L], s2Map.get(s2Arr[L])-1);
                    L++;
                }
            }

        }
        return false;
    }
}
