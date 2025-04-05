package algorithms.base;

public class WeightQuickUnionUnionFind {
    //这里是将什么进行了抽象？触点、连通分量、连接
    private int count;
    private int[] id;

    //给每棵树的高度定义了变量
    private int[] sz;

    public WeightQuickUnionUnionFind(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
        sz = new int[count];
        for (int i = 0; i < count; i++) {
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connect(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        //这里的id[p]代表什么意思
        while (id[p] != p) {
            p = id[p];
        }
        //这里返回的p是什么
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        //这个多出来的判断操作是为了干什么
        if (sz[pRoot] > sz[qRoot]) {
            id[qRoot] = pRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        count--;
    }
}
