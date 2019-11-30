package lc;

public class ReverseString {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i=0; i<n/2; i++) {
            char tmp = s[i];
            s[i] = s[n-i-1];
            s[n-i-1] = tmp;
        }
    }

    public static void main(String[] args) {
        ReverseString r = new ReverseString();
        char[] s = {'a', 'b', 'c', 'd'};
        r.reverseString(s);
        System.out.println(s);

    }


}
