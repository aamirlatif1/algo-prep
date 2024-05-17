package com.algo.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();

        if (numRows == 0) {
            return output;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        output.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = output.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currentRow.add(1);
            output.add(currentRow);
        }
        return output;
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> output = pascalsTriangle.generate(5);
        for (List<Integer> row : output) {
            System.out.println(row);
        }
    }
}
