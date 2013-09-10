import java.util.Scanner;
import java.util.Random;

public class MonteCarlo {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Percolation grid;
        int n;
        int i;
        int j;
        int open_sites = 0;
        Random generator = new Random();
        n = scanner.nextInt(); 
        grid = new Percolation(n);
        while (grid.percolates() == false) {
            i = generator.nextInt(grid.grid_size) + 1;
            j = generator.nextInt(grid.grid_size) + 1;
            if (grid.isOpen(i, j) == false) {
                grid.open(i, j);
                open_sites++;
            }
        }
        System.out.println(open_sites + " / " + 
            (grid.grid_size * grid.grid_size) + 
            " sites to percolate (" + 
            ((double)open_sites / (grid.grid_size * grid.grid_size)) + ").");
    }
}
