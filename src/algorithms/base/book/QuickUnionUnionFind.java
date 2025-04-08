package algorithms.base.book;

public class QuickUnionUnionFind {
    //这里是将什么进行了抽象？触点、连通分量、连接
    private int count;
    private int[] id;

    public QuickUnionUnionFind(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
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
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        //这里为什么是id[pid]而不是id[p]
        id[pId] = qId;
        count--;
    }
}
