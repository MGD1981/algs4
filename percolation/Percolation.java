public class Percolation {
    public int grid_size;
    public int[] grid_array;
    public UF uf_grid;    

    public Percolation(int N) { // create N-by-N grid, with all sites blocked
        grid_size = N;
        grid_array = new int[N*N];
        for (int square : grid_array) {
            grid_array[square] = 1; // 1 is blocked, 0 is open
        }
        uf_grid = new UF(grid_array);
        
    }
        
    public void open(int i, int j) { // open site (row i, column j) if it is 
                                     // not already
        this.checkBounds(i, j);
        grid_array[(i * (grid_size-1)) + j] = 0; 
    }
            
    public boolean isOpen(int i, int j) { // is site (row i, column j) open?
        this.checkBounds(i, j);       
        if (grid_array[(i * (grid_size-1)) + j] == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isFull(int i, int j) { // is site (row i, column j) full?
        this.checkBounds(i, j);
        if (grid_array[(i * (grid_size-1)) + j] == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean percolates() { // does the system percolate?
        return uf_grid.connected(
            grid_size * grid_size + 1, grid_size * grid_size + 2);
    }
    
    private void checkBounds(int i, int j) {
        if (i < 1 || i > grid_size || j < 1 || j > grid_size) {
            throw new java.lang.IndexOutOfBoundsException();
        }
    }
        
}

