package br.com.supercloud.arrays;

import static java.util.stream.Collectors.counting;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SherlockAndTheValidString {

    // https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem

    static String isValid(String s) {
        if (s.length() == 1) {
            return "YES";
        }
        int[] frequency = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : s.toCharArray()) {
            int charNumber = getCharNumber(c);
            if (charNumber != -1) {
                frequency[charNumber]++;
            }
        }

        boolean oneOff = false;
        int[] filteredArray = Arrays.stream(frequency).filter(x -> x > 0).toArray();
        int mostCommonFreq = Arrays.stream(filteredArray)
                .boxed() // Convert to Integer
                .collect(Collectors.groupingBy(Function.identity(),
                        counting())) // Group to map frequency value/count of letters with the frequency value
                .entrySet() // Get the map entryset to stream and get max
                .stream()
                .max((x, y) -> (int) (x.getValue() - y
                        .getValue())) // Get the maximum common frequency between all letters
                .get()
                .getKey(); // Return the key which should be used as base
        for (int freq : filteredArray) {
            if (freq == mostCommonFreq + 1 || freq == mostCommonFreq - 1 || (freq == 1 && mostCommonFreq > 1)) {
                if (oneOff) {
                    return "NO";
                }
                oneOff = true;
            } else if (freq > mostCommonFreq + 1 || freq < mostCommonFreq - 1) {
                return "NO";
            }
        }
        return "YES";
    }

    private static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(isValid("aabbccddeefghi")); // NO
        System.out.println(isValid("abcdefghhgfedecba")); // YES
        System.out.println(isValid("aabbc")); // YES
        System.out.println(
                isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd")); // YES
    }
}
