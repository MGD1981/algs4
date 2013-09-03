public class UF {
    public int[] uf_array;
    
    public UF(int[] array) {
        uf_array = new int[array.length + 2];
        for (int i : uf_array) {
            uf_array[i] = i;
        }
    }

    public void union(int p, int q) {

    }

    public void find(int p, int q) {

    }

    public boolean connected(int p, int q) {
        return true; // TODO
    }

    public void count(int p) {

    }

}
            
