package neetcode.slidingwindow;
public class CountSubstring3258 {
    public static void main(String[] args) {
        System.out.println(countKConstraintSubstrings("10101", 1));
    }
    public static int countKConstraintSubstrings(String s, int k) {
        int totalOne=0;
        int totalZero=0;
        int L=0;
        int count = 0;
        for(int R=L;R<s.length();R++){
            if(s.charAt(R)=='0'){
                totalZero++;
            }else{
                totalOne++;
            }
            while(totalZero>k && totalOne>k){
                if(s.charAt(L)=='0'){
                    totalZero--;
                }else{
                    totalOne--;
                }
                L++;
            }
            count+=(R-L+1);
        }
        return count;
    }
}
