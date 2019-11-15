package lc;

public class UglyNum {
    public boolean isUgly(int num) {
        while (num>1) {
            if (num % 2 != 0) break;
            num /= 2;
        }
        while (num>1) {
            if (num % 3 != 0) break;;
            num /= 3;
        }
        while (num>1) {
            if (num % 5 != 0) break;
            num /= 5;
        }
        if (num == 1) return true;
        else return false;

    }
}
