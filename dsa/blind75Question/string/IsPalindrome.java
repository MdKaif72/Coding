package dsa.blind75Question.string;

public class IsPalindrome {

    public static boolean validPalindrome(int x){
        String s=String.valueOf(x);


        int left = 0;
        int right=s.length()-1;

        while(left<right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;

            }
            else
                return false;
        }
        return true;
    }
}
