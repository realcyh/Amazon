package lc;

import java.util.*;

public class PrintAllStringOfLengthK {
    public List<String> printAllString(char[] set, int K) {
        List<String> list = new ArrayList<>();
        print(set, list, "", K);
        return list;
    }

    public void print(char[] set, List<String> list, String s, int k) {
        if (k==0) {
            list.add(s);
            return;
        }
        for (int i=0; i<set.length; i++) {
            print(set, list, s+set[i], k-1);
        }
    }

    public static void main(String[] args) {
        PrintAllStringOfLengthK p = new PrintAllStringOfLengthK();
        char[] set = {'a','b','c','d'};
        int K = 2;
        List<String> res = p.printAllString(set, K);
        System.out.println(res);
    }

}
