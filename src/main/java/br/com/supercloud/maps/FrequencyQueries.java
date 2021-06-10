package br.com.supercloud.maps;

import java.util.*;

public class FrequencyQueries {
    private static final int ADD = 1;
    private static final int REMOVE = 2;
    private static final int CHECK = 3;

    // https://www.hackerrank.com/challenges/frequency-queries/problem

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> keyByFreq = new HashMap<>();
        Map<Integer, Integer> freqByKey = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (List<Integer> query : queries) {
            int op = query.get(0);
            int val = query.get(1);
            if (op == ADD) {
                Integer curFreq = keyByFreq.merge(val, 1, Integer::sum);
                updateFreqByKey(freqByKey, curFreq, curFreq -1);
            }
            if (op == REMOVE && keyByFreq.containsKey(val) && keyByFreq.get(val) > 0) {
                Integer curFreq = keyByFreq.merge(val, -1, Integer::sum);
                updateFreqByKey(freqByKey, curFreq, curFreq + 1);
            }
            if (op == CHECK) {
                result.add(freqByKey.getOrDefault(val, 0) > 0 ? 1 : 0);
            }
        }
        return result;
    }

    private static void updateFreqByKey(Map<Integer, Integer> freqByKey, Integer curFreq, Integer prevFreq) {
        if (prevFreq > 0 && freqByKey.get(prevFreq) > 0) {
            freqByKey.merge(prevFreq, -1, Integer::sum);
        }
        freqByKey.merge(curFreq, 1, Integer::sum);
    }


    public static void main(String[] args) {
        freqQuery(
                Arrays.asList(
                        Arrays.asList(3, 4),
                        Arrays.asList(1, 4),
                        Arrays.asList(2, 1003),
                        Arrays.asList(1, 16),
                        Arrays.asList(1, 16),
                        Arrays.asList(3, 2),
                        Arrays.asList(3, 1)
                )
        ).forEach(System.out::println);
    }

}
