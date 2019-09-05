package br.com.supercloud.strings;

public class Base62 {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = ALPHABET.length();

    public static String fromBase10(int id) {
        StringBuilder sb = new StringBuilder();
        if (id == 0) {
            return "a";
        }
        while (id > 0) {
            int rem = id % BASE;
            sb.append(ALPHABET.charAt(rem));
            id = id / BASE;
        }
        return sb.reverse().toString();
    }

    public static int toBase10(String s) {
        char[] chars = new StringBuilder(s).reverse().toString().toCharArray();
        int n = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            n += ALPHABET.indexOf(chars[i]) * Math.pow(BASE, i);
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(fromBase10(1000)); // qi
        System.out.println(toBase10("qi")); // 1000
        System.out.println(fromBase10(99999)); // Aa3
        System.out.println(toBase10("Aa3")); // 99999
        System.out.println(fromBase10(9999999)); // P7Ct
        System.out.println(toBase10("P7Ct")); // 9999999
        System.out.println(fromBase10(999999999)); // bfP3Qp
        System.out.println(toBase10("bfP3Qp")); // 999999999
    }

}
