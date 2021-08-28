package br.com.supercloud.arrays;
/*
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique positive integer identifier.

For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:
         20
         |
1   2    4   15
 \ /   / | \ /
  3   5  8  9
   \ / \     \
    6   7    11


Sample input/output (pseudodata):

parentChildPairs = [
    (1, 3), (2, 3), (3, 6), (5, 6), (15, 9), (20, 4),
    (5, 7), (4, 5), (4, 8), (4, 9), (9, 11)
]


Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.


Output may be in any order:

findNodesWithZeroAndOneParents(parentChildPairs) => [
  [1, 2, 15, 20],       // Individuals with zero parents
  [4, 5, 7, 8, 11]        // Individuals with exactly one parent
]

Complexity Analysis variables:

n: number of pairs in the input
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tinder {


    public static List<Set<Integer>> findNodesWithZeroAndOneParents(int[][] parentChildPairs) {
        Set<Integer> zeroParents = new HashSet<>();
        Set<Integer> exactlyOneParent = new HashSet<>();
        Set<Integer> children = new HashSet<>();
        List<Set<Integer>> result = Arrays.asList(zeroParents, exactlyOneParent);

        for (int[] pair : parentChildPairs) {
            int parent = pair[0];
            int child = pair[1];
            if (children.contains(child)) {
                exactlyOneParent.remove(child);
            } else {
                exactlyOneParent.add(child);
                zeroParents.remove(child);
            }
            if (children.contains(parent)) {
                zeroParents.remove(parent);
            } else {
                zeroParents.add(parent);
            }
            children.add(child);
        }
        return result;
    }

    public static void main(String[] argv) {
        int[][] parentChildPairs = new int[][]{
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {15, 9}, {5, 7}, {20, 4},
                {4, 5}, {4, 8}, {4, 9}, {9, 11}
        };
        List<Set<Integer>> result = findNodesWithZeroAndOneParents(parentChildPairs);
        Set<Integer> zeroParents = result.get(0);
        System.out.println("Zero Parents:");
        zeroParents.forEach(System.out::println);
        System.out.println();
        Set<Integer> exactlyOneParent = result.get(1);
        System.out.println("Exactly One Parent:");
        exactlyOneParent.forEach(System.out::println);
    }
}
