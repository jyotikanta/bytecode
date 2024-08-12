package neetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LSWRC {

    public static void main(String[] args) {
        HashSet<Character> s = new HashSet<>();
        System.out.println(lengthOfLongestSubstring("abbca"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        char[] charArr = s.toCharArray();
        int len=0;
        int L=0;
        boolean duplicatePresent = false;
        for(int R=0;R<charArr.length;R++){

            if(charSet.contains(charArr[R])){
                while(charArr[L]!=charArr[R]){
                    charSet.remove(charArr[L]);
                    L++;
                }

                charSet.remove(charArr[L]);
                L++; //Edge case when the element is present at the very first place.

                duplicatePresent = true;
            }
            charSet.add(charArr[R]);
            len = Math.max(len, R-L+1);
        }
        if(duplicatePresent)
            return len;
        return s.length();
    }
}
