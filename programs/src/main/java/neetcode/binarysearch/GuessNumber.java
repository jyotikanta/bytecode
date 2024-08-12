package neetcode.binarysearch;

public class GuessNumber {
    public static void main(String[] args) {
        System.out.println(guessNumber(2126753390));
    }
    public static int guessNumber(int n) {
        int left = 1, right = n;
        while(true){
            int mid = left+(right-left) / 2;
            int guess = guess(mid);
            if(guess==-1){
                right = mid-1;
            }else if(guess == 1){
                left = mid+1;
            }
            else {
                return mid;
            }
        }
    }

    public static int guess(int guess){
        int target = 1702766719;
        if(guess == target){
            return 0;
        }else if(guess>target){
            return -1;
        }else{
            return 1;
        }
    }
}
