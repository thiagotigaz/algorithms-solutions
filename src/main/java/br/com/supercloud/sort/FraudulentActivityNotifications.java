package br.com.supercloud.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class FraudulentActivityNotifications {

    // https://www.hackerrank.com/challenges/fraudulent-activity-notifications
    public static int activityNotifications(List<Integer> expenditure, int d) {
        int totalNotifications = 0;
        boolean even = d % 2 == 0;
        int[] medianArr = new int[201];
        // pre fill medianArr for first interaction;
        for (int i = 0; i < d; i++) {
            medianArr[expenditure.get(i)]++;
        }
        for (int i = d; i < expenditure.size(); i++) {
            int first = 0;
            int second = 0;
            int sum = 0;
            for (int j = 0; j < medianArr.length; j++) {
                sum += medianArr[j];
                if (first == 0 && sum >= d / 2) {
                    first = j;
                }
                if (sum >= (d / 2 + 1)) {
                    second = j;
                    break;
                }
            }
            int value = even ? first + second : second * 2;
            Integer exp = expenditure.get(i);
            if (exp >= value) {
                totalNotifications++;
            }
            medianArr[expenditure.get(i - d)]--;
            medianArr[expenditure.get(i)]++;
        }
        return totalNotifications;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(activityNotifications(Arrays.asList(2, 3, 4, 2, 3, 6, 8, 4, 5), 5)); // 2
        System.out.println(activityNotifications(Arrays.asList(10, 20, 30, 40, 50), 3)); // 1
        System.out.println(activityNotifications(Arrays.asList(2, 3, 4, 2, 3, 6, 8, 4, 5), 5)); // 2
        System.out.println(activityNotifications(Arrays.asList(1, 2, 3, 4, 4), 5)); // 0
        System.out.println(activityNotifications(Arrays.asList(1, 200, 2, 200, 200), 4)); // 0
        System.out.println(activityNotifications(Arrays.asList(4, 4, 1, 4, 8, 1), 4)); // 1

        String[] strings = readFile().replace("\n", "").split(" ");
        List<Integer> values = Arrays.stream(strings).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        System.out.println(activityNotifications(values, 10000)); // 633
    }

    private static String readFile() throws IOException {
        Class<FraudulentActivityNotifications> clazz = FraudulentActivityNotifications.class;
        InputStream inputStream = clazz.getResourceAsStream("/fraudulentactivity.txt");
        return readFromInputStream(inputStream);
    }

    private static String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
