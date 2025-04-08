package algorithms.base.book;

public class QuickFindUnionFind {
    //这里是将什么进行了抽象？触点、连通分量、连接
    private int count;
    private int[] id;

    public QuickFindUnionFind(int count) {
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
        //这里返回的代表什么意思
        return id[p];
    }

    public void union(int p, int q) {
        int pId=id[p];
        int qId=id[q];
        if(pId==qId){
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if(id[i]==pId){
                id[i]=qId;
            }
        }
        //这里的count为什么要放在外面进行--
        count--;
    }
}
