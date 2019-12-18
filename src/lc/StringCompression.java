package lc;

public class StringCompression {
    public int compress(char[] chars) {
        int idxAns = 0;
        int index = 0;
        while (index<chars.length) {
            char curr = chars[index];
            int count = 0;
            while (index<chars.length && chars[index] == curr) {
                index++;
                count++;
            }
            chars[idxAns] = curr;
            idxAns++;
            if (count != 1) {
                for (char c: Integer.toString(count).toCharArray()) {
                    chars[idxAns] = c;
                    idxAns++;
                }
            }

        }
        return idxAns;
    }
}
