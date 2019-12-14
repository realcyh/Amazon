package lc;

import java.util.*;

public class StringToInteger {
    public int myAtoi(String str) {
        int result = 0;
        int mark = 1;
        int spaceMark = 0;
        int numMark = 0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (spaceMark == 1) break;
                if (numMark == 1) break;
                continue;
            }
            if (str.charAt(i) == '-') {
                spaceMark = 1;
                if (numMark == 1) break;
                if (mark == -1 || mark == 2) break;
                mark = -1;
                continue;
            }
            if (str.charAt(i) == '+') {
                spaceMark = 1;
                if (numMark == 1) break;
                if (mark == -1 || mark == 2) break;
                mark = 2;
                continue;
            }
            int val = str.charAt(i) - '0';
            if (val>=0 && val <10) {
                spaceMark = 1;
                numMark = 1;
                if (Integer.MAX_VALUE / 10 <result || Integer.MAX_VALUE/10 == result && Integer.MAX_VALUE%10 < val) {
                    return mark == 1 || mark == 2 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result*10 + val;
            } else {
                break;
            }
        }
        mark = mark == 2 ? 1 : mark;
        return mark*result;
    }

    public static void main(String[] args) {
        String s1 = "  -42";
        StringToInteger s = new StringToInteger();
        int res = s.myAtoi(s1);
        System.out.println(res);

    }
}
