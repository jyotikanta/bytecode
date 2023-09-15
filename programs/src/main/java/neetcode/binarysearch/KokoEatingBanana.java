package neetcode.binarysearch;

public class KokoEatingBanana {
    public static void main(String[] args) {
        KokoEatingBanana ceb = new KokoEatingBanana();
        System.out.println(ceb.minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 1;

        for(int i=0;i<piles.length;i++)
        {
            r = Math.max(r, piles[i]);
        }
        int minEatSpeed = r;
        while (l<=r)
        {
            int newMinEatSpeed = (l+r)/2;
            int hourSpent = 0;
            for(int i=0;i<piles.length;i++)
            {
                hourSpent += (piles[i]+newMinEatSpeed-1)/newMinEatSpeed;
            }
            if(hourSpent<=h)
            {
                minEatSpeed = Math.min(newMinEatSpeed,minEatSpeed);
                r =  (newMinEatSpeed-1);
            }
            else
            {
                l =  (newMinEatSpeed + 1);
            }

        }
        return minEatSpeed;
    }
}
