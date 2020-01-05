package com.beauty.algorithm.thought.backtrack;

public class EightQueens {

    /** 小标表示行，值表示queen存储在哪一列 */
    private int[] result = new int[8];

    /**
     * 调用方式：cal8queens(0)
     * @param row
     */
    public void cal8queens(int row) {
        // 8个棋子都放置好了，打印结果
        if (row == 8) {
            printQueens(result);
            // 8行棋子都放好了，已经没法再往下递归了，所以就return
            return;
        }
        // 每一行都有8种放法
        for (int column = 0; column < 8; column++) {
            // 有些放法不满足要求
            if (isOk(row, column)) {
                // 第row行的棋子放到了column列
                result[row] = column;
                // 考察下一行
                cal8queens(row + 1);
            }
        }
    }

    /**
     * 判断row行column列放置是否合适
     * @param row
     * @param column
     * @return
     */
    private boolean isOk(int row, int column) {
        int leftup = column - 1;
        int rightup = column + 1;
        for (int i = row-1; i >= 0; i--) {
            // 第i行的column列有棋子吗
            if (result[i] == column) {
                return false;
            }
            // 考察左上角对角线：第i行leftup列有棋子吗
            if (leftup >= 0 && result[i] == leftup) {
                return false;
            }
            // 考察右上角对角线：第i行rightup列有棋子吗
            if (rightup < 8 && result[i] == rightup) {
                return false;
            }
            leftup--;
            rightup++;
        }
        return true;
    }

    /**
     * 打印出一个二维矩阵
     * @param result
     */
    private void printQueens(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
