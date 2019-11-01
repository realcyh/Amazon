package oa1;

public class DrawPattern {
    public static void printPattern(int n) {
        int i, j, print = 1;
        for (i=1; i<=n; i++){
            for (j=1; j<=i*2; j++) {
                System.out.print((print));  // remove ; //(())
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPattern(1);

    }

}
