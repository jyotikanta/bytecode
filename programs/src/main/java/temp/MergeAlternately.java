package temp;

public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        int lw1 = word1.length();
        int lw2 = word2.length();
        int min = Math.min(lw1,lw2);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i< min; i++)
        {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }

        if(lw1 < lw2)
        {
            sb.append(word2.substring(min));
        }
        else
        {
            sb.append(word1.substring(min));
        }

        return new String(sb);
    }
}
