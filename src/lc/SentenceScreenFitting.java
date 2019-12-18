package lc;

public class SentenceScreenFitting {
    public int sentenceScreen(int rows, int cols, String[] sentence) {
        // 2 5
        // i am tom
        int index = 0;
        int count = 0;

        for (int i=0; i<rows; i++) {
            int flag = 0;
            while (index<sentence.length) {
                if (sentence[index].length() <= cols - flag) {
                    index++;
                    flag += sentence[index].length()+1;
                } else break;
            }
            if (index == sentence.length) {
                count++;
                index = 0;
            }
        }
        return count;

        //i-am
        //tom
    }
}
