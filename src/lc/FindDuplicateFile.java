package lc;

import java.util.*;
import java.util.regex.*;

public class FindDuplicateFile {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String path: paths) {
            String[] s = path.split(" ");
            String addr = s[0];

            for (int i=1; i<s.length; i++) {
                String[] text = s[i].split("\\(");
                String key = text[1].replace(")", "");
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList());
                }
                map.get(key).add(addr+"/"+text[0]);
            }
        }
        for (String key: map.keySet()) {
            if (map.get(key).size() >1) {
                res.add(map.get(key));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "(abc)(def)(asd)";
        String[] a = s.split("()");
        System.out.println(a[6]);

        FindDuplicateFile f = new FindDuplicateFile();
        String[] paths = {"a 111(asdf) 222(asdf)", "b 333(efdg)"};
        f.findDuplicate(paths);


    }
}
