package br.com.supercloud.strings;

public class Abbreviation {

    // https://www.hackerrank.com/challenges/abbr/problem

    static String abbreviation(String a, String b) {
        int idxA = 0, idxB = 0;
        while (idxA < a.length() && idxB < b.length()) {
            char charA = a.charAt(idxA);
            char charB = b.charAt(idxB);
            if (charA == charB || Character.toUpperCase(charA) == charB) {
                idxB++;
            }
            idxA++;
        }
        return idxB == b.length() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        System.out.println(abbreviation("Pi", "P"));
        System.out.println(abbreviation("AfPZN", "APZNC"));
        System.out.println(abbreviation("LDJAN", "LJJM"));
        System.out.println(abbreviation("UMKFW", "UMKFW"));

        System.out.println(abbreviation("KXzQ", "K"));
        System.out.println(abbreviation("LIT", "LIT"));
        System.out.println(abbreviation("QYCH", "QYCH"));
        System.out.println(abbreviation("DFIQG", "DFIQG"));
        System.out.println(abbreviation("sYOCa", "YOCN"));
        System.out.println(abbreviation("JHMWY", "HUVPW"));
    }
}
