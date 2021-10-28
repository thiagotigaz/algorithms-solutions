package br.com.supercloud.strings;

public class WrapCount {

    public static void main(String[] args) {
        System.out.println(wrapCount("the quick brownfox jumped over the lazy dog", 19));
    }

    private static int wrapCount(String phrase, int n) {
        int nLines = 0;
        int curIdx = 0;
        int lastSpaceIdx = -1;
        for (int i = 0; i < phrase.length(); i++) {
            curIdx++;
            if (phrase.charAt(i) == ' ') {
                lastSpaceIdx = i;
            } else if (curIdx >= n) {
                nLines++;
                curIdx = 0;
                i = lastSpaceIdx + 1;
            }
        }
        if (curIdx > 0) {
            nLines++;
        }
        return nLines;
    }
}
