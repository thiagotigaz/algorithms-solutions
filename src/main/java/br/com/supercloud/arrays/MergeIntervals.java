package br.com.supercloud.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    static class Interval {
        int begin;
        int end;

        public Interval(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public String toString() {
            return "{" + begin + ", " + end + '}';
        }
    }

    /*
     * Consider the concept of 'sorted, non-overlapping interval list',
     * which is an array of intervals that don't overlap with each other and are sorted by interval start.
     * Given two of these interval lists, return a 3rd interval list that is the union of the input interval lists.
     * For Example:
     * Input:
     * {[1,2], [3,9]}
     * {[4,6], [8,10], [11,12]}
     * Output should be:
     * {[1,2], [3,10], [11,12]}
     * */
    static List<Interval> mergeIntervals(List<Interval> intervalsA, List<Interval> intervalsB) {
        LinkedList<Interval> result = new LinkedList<>();
        mergeIntervalToResult(intervalsA, result);
        mergeIntervalToResult(intervalsB, result);
        return result;
    }

    private static void mergeIntervalToResult(List<Interval> intervalsA, LinkedList<Interval> result) {
        for (Interval interval : intervalsA) {
            if (result.isEmpty()) {
                result.add(interval);
            }
            Interval last = result.getLast();
            if (overlap(last, interval)) {
                updateInterval(last, interval);
            } else {
                result.add(interval);
            }
        }
    }

    private static void updateInterval(Interval last, Interval current) {
        last.begin = Math.min(last.begin, current.begin);
        last.end = Math.max(last.end, current.end);
    }

    private static boolean overlap(Interval last, Interval current) {
        return current.begin >= last.begin && current.begin <= last.end;
    }

    public static void main(String[] args) {
        List<Interval> intervalsA = Arrays.asList(new Interval(1, 2), new Interval(3, 9));
        List<Interval> intervalsB = Arrays.asList(new Interval(4, 6), new Interval(8, 10), new Interval(11, 12));
        System.out.println(mergeIntervals(intervalsA, intervalsB));
    }
}
