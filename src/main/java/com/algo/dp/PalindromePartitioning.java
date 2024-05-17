package com.algo.dp;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    // Given a string s, partition s such that every
    //substring
    // of the partition is a
    //palindrome
    //. Return all possible palindrome partitioning of s.
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        backtrack(output, currentList, s, 0);
        return output;
    }

    private void backtrack(List<List<String>> output, List<String> currentList, String s, int i) {
        if (i == s.length()) {
            output.add(new ArrayList<>(currentList));
        } else {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    currentList.add(s.substring(i, j + 1));
                    backtrack(output, currentList, s, j + 1);
                    currentList.remove(currentList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        List<List<String>> output = palindromePartitioning.partition("aab");
        for (List<String> list : output) {
            System.out.println(list);
        }
    }
}
