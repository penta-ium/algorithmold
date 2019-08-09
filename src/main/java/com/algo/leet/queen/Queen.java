package com.algo.leet.queen;

public class Queen {

    public static int Q_NUM = 8;
    public static int[][] arry = new int[Q_NUM][Q_NUM];//棋盘，放皇后
    public static int map = 0;//存储方案结果数量

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(String.format("%d皇后问题", Q_NUM));
        findQueen(0);
        System.out.println(String.format("%d皇后问题共有：%d种可能", Q_NUM, map));
    }

    /**
     * 在第i层，寻找合适的位置
     * @param row
     */
    public static void findQueen(int row) {//寻找皇后节点
        if (row > (Q_NUM - 1)) {//八皇后的解
            map++;
            print();//打印八皇后的解
            return;
        }

        for (int col = 0; col < Q_NUM; col++) {//深度回溯,递归算法
            if (check(row, col)) {//检查皇后摆放是否合适
                arry[row][col] = 1;
                findQueen(row + 1);
                arry[row][col] = 0;//清零，以免回溯的时候出现脏数据
            }
        }
    }

    /**
     * 总之只需要检查当前所在行上面和同一列
     * @param row
     * @param col
     * @return
     */
    public static boolean check(int row, int col) {//判断节点是否合适
        //System.out.println(String.format("检查行：%d，列：%d", row, col));
        //不用检查所在行--所在行只有自己，肯定不会有冲突
        //左下角对角线不用检查，以为那里还没有安排
        //右下角对角线不用检查，那里还没有安排
        //检查所在列
        for (int i = 0; i < Q_NUM; i++) {//检查行列冲突
            if (arry[i][col] == 1) {
                return false;
            }
        }
        //检查左上角对角线
        for (int i = row - 1, m = col - 1; i >= 0 && m >= 0; i--, m--) {//检查左对角线
            if (arry[i][m] == 1) {
                return false;
            }
        }
        //检查右上角对角线
        for (int i = row - 1, m = col + 1; i >= 0 && m <= Q_NUM - 1; i--, m++) {//检查右对角线
            if (arry[i][m] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void print() {//打印结果
        System.out.print("方案" + map + ":" + "\n");
        for (int i = 0; i < Q_NUM; i++) {
            for (int m = 0; m < Q_NUM; m++) {
                if (arry[i][m] == 1) {
                    //System.out.print("皇后"+(i+1)+"在第"+i+"行，第"+m+"列\t");
                    System.out.print("● ");
                } else {
                    System.out.print("○ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
