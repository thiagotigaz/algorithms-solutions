package br.com.supercloud.dynamic;

public class Abbreviation {
    // https://www.hackerrank.com/challenges/abbr/problem

    public static void main(String[] args) {
//        System.out.println(execAbbreviation("aABC", "ABC")); // YES
//        System.out.println(execAbbreviation("daBcd", "ABC")); // YES
//        System.out.println(execAbbreviation("AbcDE", "ABDE")); // YES
//        System.out.println(execAbbreviation("AbcDE", "AFDE")); // NO
//        System.out.println(execAbbreviation("KXzQ", "K")); // NO
        System.out.println(execAbbreviation(
                "OPZFFVQLADBQFBXLOSUMZZWQUKASCUVQZZVWfPIRTytlvpijddqegbwitkhhsbuehtnpndvcandzjzyepvlnkayfkwzegvbratvwezddjqxrxocqgcghuohlmsondvicocltqhvqfqjpctxfomjoukrheijhhndcbipiobvpbskemgykepokluwqhhejdaimvdvlegfyrrwckgojsbsxmsvhhrlnvcrxfaxinjzsjgvvrlcczqlkvgtftsvktvhtfpaklumhkovphilrappbvkarfhvwxxtrugypracozyqyvaqjityoiyemyavpbchaoagrvujocpueczsgcqdjvkjckxhmnaseshjgecusrxozuxgeieleewwskmiprlqnshvmcp",
                "OPZFFVQLADBQFBXLOSUMZZWQUKASCUVQZZVWPIRT")
        ); // NO
    }

    private static boolean execAbbreviation(String input, String target) {
        if (target.equals("") && input.matches("[a-z]*")) return true;
        if (input.length() < target.length()) return false;

        String iSub = input.substring(0, 1);
        if (target.isEmpty() && iSub.matches("[A-Z]+")) {
            return false;
        }
        String tSub = target.substring(0, 1);
        if (iSub.matches("[A-Z]{1}") && iSub.equals(tSub)) {
            return execAbbreviation(input.substring(1), target.substring(1));
        }
        if (iSub.matches("[a-z]{1}") ) {
            if (iSub.toUpperCase().equals(tSub)) {
                return execAbbreviation(input.substring(1), target.substring(1))  || execAbbreviation(input.substring(1), target);
            } else {
                return execAbbreviation(input.substring(1), target);
            }
        }
        return false;
    }

//    private static boolean abbreviation(String input, String target) {
//        if (target.equals("")) return true;
//
//        for (int i = 1; i <= input.length(); i++) {
//            String substr = input.substring(0, i);
//            String targetSubstr = target.substring(0, i);
//            if (substr.matches("[A-Z]+")) {
//                System.out.println(substr);
//                return abbreviation(input.substring(i), target.substring(i));
//            }
//        }
//        return false;
//    }
}
