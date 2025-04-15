package algorithms.base.leetcode;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        NumberOfIslands numberOfIslands=new NumberOfIslands();

        System.out.println(numberOfIslands.numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    int current = i * cols + j;
                    int rootP = unionFind.find(current);
                    if (j < cols - 1) {
                        if (grid[i][j + 1] == '1') {
                            int right = current + 1;
                            int rootQ = unionFind.find(right);
                            unionFind.union(rootP, rootQ);
                        }
                    }
                    if (i < rows - 1) {
                        if (grid[i + 1][j] == '1') {
                            int down = (i + 1) * cols + j;
                            int rootQ = unionFind.find(down);
                            unionFind.union(rootP, rootQ);
                        }
                    }
                }
            }
        }
        return unionFind.count;

    }


    public static class UnionFind {
        private int[] parent;

        private int[] rank;

        private int count;

        public UnionFind(char[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            parent = new int[rows * cols];
            rank = new int[rows * cols];
            count = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1') {
                        int index = i * cols + j;
                        parent[index] = index;
                        rank[index] = 1;
                        count++;
                    }
                }
            }
        }

        public int find(int num) {
            if (num != parent[num]) {
                //这里为什么要进行赋值，不直接递归查找
                parent[num]=find(parent[num]);
            }
            return num;
        }

        public void union(int rootP, int rootQ) {
            if (rootP == rootQ) {
                return;
            }

            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;

            } else if(rank[rootP] < rank[rootQ]){
                parent[rootP] = rootQ;
            }else {
                //这里当秩相等时，固定合并方向（例如将右侧或下方的根合并到当前根）
                parent[rootQ] = rootP;
                rank[rootP]++;
            }

            count--;
        }
    }
}
