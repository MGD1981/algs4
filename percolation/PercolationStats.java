
public class PercolationStats {
    double[] ratio_array;
    double times_run;

    public PercolationStats(int N, int T) {
    /** perform T independent computational experiments on an N-by-N grid */
        ratio_array = new double[T];
        this.times_run = T;
        if (N <= 0 || T <= 0) {
           throw new java.lang.IllegalArgumentException();
        }
 
        for (int i=0; i < T; i++) {
            this.ratio_array[i] = MonteCarlo.play(N); 
        }
    }

    public double mean() {
    /** sample mean of percolation threshold */
        return StdStats.mean(this.ratio_array);
    }

    public double stddev() {
    /** sample standard deviation of percolation threshold */
        return StdStats.stddev(this.ratio_array);
    }

    public double confidenceLo() {
    /** returns lower bound of the 95% confidence interval */
        return (mean() - ((1.96 * stddev())/Math.sqrt(this.times_run)));
    }

    public double confidenceHi() {
    /** returns upper bound of the 95% confidence interval */
        return (mean() + ((1.96 * stddev())/Math.sqrt(this.times_run)));
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        int T = StdIn.readInt();
        PercolationStats stats = new PercolationStats(N, T);
        System.out.println("mean = " + stats.mean());
        System.out.println("stddev = " + stats.stddev());
        System.out.println("95% confidence interval = " + 
            stats.confidenceLo() + ", " + stats.confidenceHi());
    }
}
