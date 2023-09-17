package neetcode.twopointers;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        StringBuilder sb = sanitize(s);
        int si = 0, ei = sb.length()-1;
        while(si < ei)
        {
            if(sb.charAt(si)!=sb.charAt(ei))
                return false;
            si++;
            ei--;
        }
        return true;
    }

    private static StringBuilder sanitize(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c:chars){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }
        return sb;
    }

    public static void main(String[] args) {
        String s = "s";
        System.out.println(isPalindrome(s));
    }
}
