package oa1;

public class Digits {
    public static int countDigits(int num) {
        int count = 0;
        int tmp = num;
        while (tmp != 0) {
            tmp = tmp/=10;
            count++;
        }
        return num%count;
    }

    public static void main(String[] args) {
        System.out.println(countDigits(1234));
    }
}
