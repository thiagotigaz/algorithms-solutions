package br.com.supercloud.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {

    // https://www.hackerrank.com/challenges/frequency-queries/problem

    static List<Integer> freqQuery(int[][] queries) {
        Map<Integer, Integer> keyByFreq = new HashMap<>();
        Map<Integer, Integer> freqByKeys = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int op = query[0];
            int val = query[1];
            int valFreq;
            if (op == 1) {
                valFreq = keyByFreq.merge(val, 1, Integer::sum);
                updateFrequenciesMap(val, valFreq, valFreq - 1, freqByKeys);
            } else if (op == 2 && keyByFreq.containsKey(val) && keyByFreq.get(val) > 0) {
                valFreq = keyByFreq.merge(val, -1, Integer::sum);
                updateFrequenciesMap(val, valFreq, valFreq + 1, freqByKeys);
            } else if (op == 3) {
                result.add(freqByKeys.containsKey(val) && freqByKeys.get(val) > 0 ? 1 : 0);
            }
        }
        return result;
    }

    private static void updateFrequenciesMap(int val, int curValFreq, int previousValFreq,
            Map<Integer, Integer> freqByKeys) {
        Integer freq = freqByKeys.getOrDefault(previousValFreq, 0);
        if (freq > 0) {
            if (freq - 1 > 0) {
                freqByKeys.put(previousValFreq, freq - 1);
            } else {
                freqByKeys.remove(previousValFreq);
            }
        }
        freqByKeys.merge(curValFreq, 1, Integer::sum);
    }

    public static void main(String[] args) {
        freqQuery(
                new int[][]{
                        new int[]{3, 4},
                        new int[]{2, 1003},
                        new int[]{1, 16},
                        new int[]{3, 1}
                }
        ).forEach(System.out::println);
    }

}
