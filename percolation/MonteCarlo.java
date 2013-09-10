
public class MonteCarlo {

    static double play(int n) {
        Percolation grid;
        int i;
        int j;
        int open_sites = 0;
        grid = new Percolation(n);
        while (grid.percolates() == false) {
            i = StdRandom.uniform(grid.grid_size) + 1;
            j = StdRandom.uniform(grid.grid_size) + 1;
            if (grid.isOpen(i, j) == false) {
                grid.open(i, j);
                open_sites++;
            }
        }
        return ((double)open_sites / (grid.grid_size * grid.grid_size));
    }
}
