
public class Percolation {
    public int grid_size;
    public int[] grid_array;
    public UF uf_grid;    

    public Percolation(int N) { // create N-by-N grid, with all sites blocked
        grid_size = N;
        grid_array = new int[N*N];
        for (int square=0; square < grid_array.length; square++) {
            grid_array[square] = 1; // 1 is blocked, 0 is open
        }
        uf_grid = new UF(N*N+2);
        for (int x=0; x < grid_size; x++) {
            uf_grid.union(N*N, x);
            uf_grid.union(N*N+1, N*N-1-x);
        }
        
    }
        
    public void open(int i, int j) { // open site (row i, column j) if it is 
                                     // not already
        this.checkBounds(i, j);
        grid_array[(i * (grid_size-1)) + j -1] = 0;
        if (i > 1) {
            if (this.isOpen(i-1, j)) {
                uf_grid.union((grid_size-1)*i + j - 1, grid_size*(i-1) + j - 1);
            }
        }
        if (i < grid_size) {
            if (this.isOpen(i+1, j)) {
                uf_grid.union((grid_size-1)*i + j - 1, grid_size*(i+1) + j - 1);
            }
        }
        if (j > 1) {
            if (this.isOpen(i, j-1)) {
                uf_grid.union((grid_size-1)*i + j - 1, grid_size*i + j - 2);
            }
        }
        if (j < grid_size) {
            if (this.isOpen(i, j+1)) {
                uf_grid.union((grid_size-1)*i + j, grid_size*i + j);
            }
        }
    }
            
    public boolean isOpen(int i, int j) { // is site (row i, column j) open?
        this.checkBounds(i, j);       
        if (grid_array[(i * (grid_size-1)) + j - 1] == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isFull(int i, int j) { // is site (row i, column j) full?
        this.checkBounds(i, j);
        if (grid_array[(i * (grid_size-1)) + j - 1] == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean percolates() { // does the system percolate?
        return uf_grid.connected(
            grid_size * grid_size, grid_size * grid_size + 1);
    }
    
    private void checkBounds(int i, int j) {
        if (i < 1 || i > grid_size || j < 1 || j > grid_size) {
            System.out.println("i, j, max = "+ i +", "+ j +", "+ grid_size);
            throw new java.lang.IndexOutOfBoundsException();
        }
    }
        
}

