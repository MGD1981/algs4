import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

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
            System.out.println("Does not yet percolate.");
            i = generator.nextInt(grid.grid_size) + 1;
            j = generator.nextInt(grid.grid_size) + 1;
            if (grid.isOpen(i, j) == false) {
                grid.open(i, j);
                open_sites++;
                System.out.println("Opening " + i + ", " + j);
            }
        }
        System.out.println(Arrays.toString(grid.grid_array));
        System.out.println(open_sites);
    }
}
