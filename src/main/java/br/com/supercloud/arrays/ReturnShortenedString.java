package br.com.supercloud.arrays;

public class ReturnShortenedString {

    public static String solution(String message, int K) {
        // just return the message if the length is small or equal to K
        if (message.length() <= K) {
            return message;
        }

        if (message.charAt(K) == ' ') {
            // When there is a space after letter K, it means that K-1 is the last letter of a word, we can assume that
            // because we don't have consecutive spaces
            return message.substring(0, K);
        }

        // Otherwise we go backwards until we find the first space and then do the substring
        for (int i = K - 1; i >= 0; i--) {
            if (message.charAt(i) == ' ') {
                return message.substring(0, i);
            }
        }
        // In the last case it means we haven't found a space and K is smaller than the length of the big word, so we
        // just return an empty string
        return "";
    }

    public static void main(String[] args) {
        System.out.println(solution("Codility We test coders", 12));
        System.out.println(solution("Codility We test coders", 13));
        System.out.println(solution("Codility We test coders", 14));
        System.out.println(solution("Codility We test coders", 15));
        System.out.println(solution("Codility We test coders", 16));
        System.out.println(solution("Codility We test coders", 17));
        System.out.println(solution("Codility We test coders", 18));
        System.out.println(solution("Codility We test coders", 23));
        System.out.println(solution("Why not", 100));
        System.out.println(solution("The quick brown fox jumps over the lazy dog", 38));
        System.out.println(solution("Thisisabigbigbigbigbigword", 26));

        System.out.println("Thiag oo".substring(0,6));
    }

}
