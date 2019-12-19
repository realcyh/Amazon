package lc;

import java.util.*;

public class PalindromicNum {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        String s = Integer.toString(x);
        char[] c = s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while (i<j) {
            if (c[i] != c[j]) return false;
            else {
                i++; j--;
            }
        }
        return true;

        // just number
        // if (x<0 || (x!=0 && x%10==0)) return false;
        // int rev = 0;
        // while (x>rev){
        // 	rev = rev*10 + x%10;
        // 	x = x/10;
        // }
        // return (x==rev || x==rev/10);
    }
}
