public class UF {
    public int[] id;
    public int[] sz;
    
    public UF(int[] array) {
        id = new int[array.length + 2]; // size+1 is top, +2 is bottom 
        for (int i : id) {
            id[i] = i;
        }
        sz = new int[id.length];
        for (int i : sz) {
            id[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    public boolean find(int p, int q) {
       return root(p) == root(q); 
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q]; // TODO
    }

    public void count(int p) {

    }

}
            
