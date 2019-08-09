package com.algo.uf;

public class UF_friend {

    int size = 18;
    int[] pre = new int[size];
    int[] rank = new int[size];

    public UF_friend() {
        for (int i = 0; i < size; i++) {
            pre[i] = -1;
            rank[i] = -1;
        }
    }

    public void init(int x) {
        pre[x] = x;
        rank[x] = 1;
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (rank[px] <= rank[py])
            pre[px] = py;
        else
            pre[py] = px;
    }

    public int find (int x) {

        //LinkedList<Integer> list = new LinkedList<>();
        //list.addLast(x);
        int fx = x;
        while (fx !=  pre[fx]) {
            fx = pre[fx];
            //list.add(fx);
        }

/*        while (list.peekFirst() != null) {
            int qx = list.pollFirst();
            pre[qx] = fx;
            rank[qx] = 1;
        }*/

        return fx;
    }

    public boolean inter(int x, int y) {

        return false;
    }

    public int getIndex(char[][] grid, int i, int j) {

        return i * grid[i].length + j;
    }

    public int count() {
        int count = 0;
        for (int i = 0; i < pre.length; i++) {
            if (pre[i] != -1 && i == pre[i])
                count ++;
        }

        return count;

    }

    public static void main(String[] args) {
        //岛屿个数
        UF_friend uf = new UF_friend();
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '1', '0'},
                {'1', '1', '0', '1', '0', '1'},
                {'0', '0', '1', '0', '1', '1'},
        };
        print(grid);
        //uf.init(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char value = grid[i][j];
                if (value == '0')
                    continue;

                int index = uf.getIndex(grid, i, j);
                uf.init(index);
            }
        }
        //print(uf.pre);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char value = grid[i][j];
                int index = uf.getIndex(grid, i, j);
                //uf.init(index);
                if (value == '0')
                    continue;

                //connect right
                if (j + 1 < grid[i].length && grid[i][j + 1] == '1') {
                    uf.union(uf.getIndex(grid, i, j), uf.getIndex(grid, i, j + 1));
                }
                //connect down
                if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                    uf.union(uf.getIndex(grid, i, j), uf.getIndex(grid, i + 1, j));
                }

            }
        }
        //print(uf.pre);

        System.out.println("岛屿为：" + uf.count());
    }

    static void print(char[][] grid) {
        System.out.println();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void print(int[] pre) {
        System.out.println();
        for (int i = 0; i < pre.length; i++)
            System.out.print(i + ":" + pre[i] + ", ");
        System.out.println();
    }

}
