package com.algo.backtracking.queen;

public class MyQueen {

    static int NUM = 12;
    static int[][] BOARD = new int[NUM][NUM];

    static int totalPlans = 0;

    public static void main(String[] args) {


        new MyQueen().findQueen(0);
    }

    void findQueen(int row) {
        if (row >= NUM) {
            totalPlans++;
            printPlan();
            return;
        }

        for (int i = 0; i < NUM; i++) {
            if (check(row, i)) {
                BOARD[row][i] = 1;
                findQueen(row + 1);
                //等到从下层退出来的时候，不管是否有合适位置，都要置位0！
                //目的是找到所有方案，置为0去寻找所有方案
                BOARD[row][i] = 0;
            }
        }
    }

    boolean check(int row, int col) {
        //检查相同行
        //for ()

        //检查相同列
        for (int i = 0; i < NUM; i++) {
            if(BOARD[i][col] == 1)
                return false;
        }

        //检查左上角
        for (int i = row - 1, j = col - 1; i >=0 && j >= 0; i--, j--) {
            if(BOARD[i][j] == 1)
                return false;
        }

        //检查右上角
        for (int i = row - 1, j = col + 1; i >=0 && j < NUM; i--, j++) {
            if (BOARD[i][j] == 1)
                return false;
        }

        return true;
    }

    void printPlan() {
        System.out.println(String.format("%d种方案", totalPlans));
        for (int i = 0; i < NUM; i++) {
            for (int j = 0; j < NUM; j++) {
                if (BOARD[i][j] == 1) {
                    System.out.print("● ");
                } else {
                    System.out.print("○ ");
                }
                //BOARD[i][j] = 0;
            }
            System.out.println();
        }
        System.out.println();
    }

}
