package br.com.supercloud.dynamic;

public class WildCardMatching {

    static boolean strmatchFaster(String text, String pattern) {
        char[] txt = text.toCharArray();
        char[] pat = pattern.toCharArray();
        int txtLen = text.length();
        int patLen = pattern.length();
        if (patLen == 0) {
            return txtLen == 0;
        }

        int i = 0, j = 0, txtIdx = -1, patIdx = -1;
        while (i < txtLen) {
            if (j < patLen && txt[i] == pat[j]) {
                i++;
                j++;
            } else if (j < patLen && pat[j] == '?') {
                i++;
                j++;
            } else if (j < patLen && pat[j] == '*') {
                txtIdx = i;
                patIdx = j;
                j++;
            } else if (patIdx != -1) {
                j = patIdx + 1;
                i = txtIdx + 1;
                txtIdx++;
            } else {
                return false;
            }
        }

        while (j < patLen && pat[j] == '*') {
            j++;
        }

        return j == patLen;
    }

    static int removeDuplicates(char[] ptr) {
        int idx = 0;
        boolean first = true;
        for (int i = 0; i < ptr.length; i++) {
            if (ptr[i] == '*') {
                if (first) {
                    ptr[idx] = ptr[i];
                    first = false;
                    idx++;
                }
            } else {
                ptr[idx] = ptr[i];
                first = true;
                idx++;
            }
        }
        return idx;
    }

    static boolean strmatchWithRemoveDuplicates(String s, String p) {
        char[] str = s.toCharArray();
        char[] ptr = p.toCharArray();
        int writeIdx = removeDuplicates(ptr);

        boolean[][] t = new boolean[str.length + 1][writeIdx + 1];
        t[0][0] = true;
        t[0][1] = writeIdx > 0 && ptr[0] == '*'; // * == ''

        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {
                if (ptr[j - 1] == '?' || ptr[j - 1] == str[i - 1]) {
                    t[i][j] = t[i - 1][j - 1];
                } else if (ptr[j - 1] == '*') {
                    t[i][j] = t[i - 1][j] || t[i][j - 1];
                }
            }
        }

        return t[str.length][writeIdx];
    }


    public static void main(String[] args) {
//        System.out.println(strmatch("baaabab", "*****ba*****ab"));
//        System.out.println(strmatch("baaabab", "a*****ab"));
        System.out.println(strmatch("thiago", "t*ag*"));
    }

    private static boolean strmatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        char[] str = s.toCharArray();
        char[] ptr = p.replaceAll("[\\*]+", "*").toCharArray();
        boolean[][] t = new boolean[str.length + 1][ptr.length + 1];
        t[0][0] = true;
        t[0][1] = ptr[0] == '*';
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {
                if (ptr[j - 1] == '?' || ptr[j - 1] == str[i - 1]) {
                    t[i][j] = t[i - 1][j - 1];
                } else if (ptr[j - 1] == '*') {
                    t[i][j] = t[i - 1][j] ||  t[i][j - 1];
                }
            }
        }

        return t[str.length][ptr.length];
    }
}
