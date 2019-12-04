package lc;
import java.util.*;

public class FindStringIntersectionUnion {
    public void findIntersectionUnion(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Set<Character> seta = new HashSet<>();
        Set<Character> setIntersection = new HashSet<>();
        Set<Character> setUnion = new HashSet<>();

        for (char c: a ) {
            seta.add(c);
            setUnion.add(c);
        }
        for (char c: b) {
            setUnion.add((c));
            if (seta.contains(c)) {
                setIntersection.add(c);
            }
        }
        System.out.println(setIntersection);
        System.out.println(setUnion);

    }

    public static void main(String[] args) {
        String s1 = "abcddefg";
        String s2 = "deefghijk";
        FindStringIntersectionUnion f = new FindStringIntersectionUnion();
        f.findIntersectionUnion(s1, s2);
    }
}
