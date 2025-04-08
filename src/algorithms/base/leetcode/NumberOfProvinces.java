package algorithms.base.leetcode;

import java.util.HashSet;

public class NumberOfProvinces {
    public int findCircleNumBadFunction(int[][] isConnected) {
        int length = isConnected.length;
        //这里定义一个父节点数组
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < length; i++) {
            int[] ints = isConnected[i];
            //这里对于矩阵，只需要计算上半部分
            for (int j = 0; j < ints.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isConnected[i][j] == 1) {
                    //这里并没有寻找根节点，而是直接复制，可能会在2棵树合并的时候，导致一颗树中间节点指向另外另外一颗树的父节点，但是这棵树的其他节点都没有更新
                    //从而导致计算出来的连通分量要多
                    arr[j] = arr[i];
                }
            }
        }

        HashSet root = new HashSet();
        for (int i : arr) {
            //这里直接计算节点，没有去寻找父节点，那对于4->1->0,这种情况下，就会出错，因为你只计算不同的节点，而没有去深入的计算父节点
            root.add(i);
        }

        return root.size();

    }

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        //这里定义一个父节点数组
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isConnected[i][j] == 1) {
                    int rootI = findRoot(i, arr);
                    int rootJ = findRoot(j, arr);
                    if (rootJ != rootI) {
                        arr[rootJ] = rootI;
                    }
                }
            }
        }

        HashSet root = new HashSet();
        for (int i = 0; i < length; i++) {
            root.add(findRoot(i, arr));
        }

        return root.size();

    }

    private int findRoot(int num, int[] parent) {
        if (num == parent[num]) {
            return num;
        }
        return findRoot(parent[num], parent);
    }

}
