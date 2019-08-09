package com.algo.trie;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TrieSolution {

    //构建Trie
    Trie trie = new Trie(' ');

    public List<String> search(char[][] board, String[] words) {

        for (String word : words) {
            trie.insert(word);
            //System.out.println(trie.search(word));
        }

        List<String> result = new ArrayList<>();
        //深度遍历二位数组，每一个元素构造出的字符串是否能在字典树中匹配到
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char ch = board[i][j];
                solve(board, String.valueOf(""), result, i, j, new ArrayList<String>());
            }
        }

        return result;
    }
    public void solve (char[][] board, String midRes, List<String> result, int row, int col, List<String> visited) {

        String currentLoc = new StringBuilder().append("(").append(row).append(",").append(col).append(")").toString();
        String currentWord = midRes + String.valueOf(board[row][col]);

        if(visited.contains(currentLoc)){
            return;
        }

        if (!trie.startsWith(currentWord)) {
            return;
        }

        if (trie.search(currentWord)) {
            result.add(currentWord);
/*            List<String> steps = new ArrayList<>();
            steps.addAll(visited);
            steps.add(currentLoc);
            System.out.println(String .format("currentWord: %s, visited: %s, result: %s",
                    currentWord,
                    steps.toString(),
                    result.toString()));*/
            //return;
        }

        //这一步骤类似于在【N皇后问题】把当前为置为1
        visited.add(currentLoc);

        if (col - 1 >= 0)
            solve(board, currentWord, result, row, col - 1, visited);//left
        if (col + 1 < board[row].length)
            solve(board, currentWord, result, row, col + 1, visited);//right
        if (row - 1 >= 0)
            solve(board, currentWord, result, row - 1, col, visited);//up
        if (row + 1 < board.length)
            solve(board, currentWord, result, row + 1, col, visited);//down

        //这一步骤类似于在【N皇后问题】把当前为置为0，目的是为了找到更多的解
        visited.remove(currentLoc);

    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = new String[]{"oath", "pea", "eat", "rain", "oathk", "eate"};

/*        char[][] board = new char[][]{
                {'o', 'a', 'a', 'f'},
                {'e', 'a', 'a', 'e'},
                {'i', 'h', 'e', 'f'},
                {'i', 'f', 'l', 'v'}
        };

        //String[] words = new String[]{"oaaaef", "pea", "eat", "rain"};
        String[] words = new String[]{"oaaaef", "faae"};*/
        System.out.println(new TrieSolution().search(board, words));
    }
}
