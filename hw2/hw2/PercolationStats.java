package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    Percolation percolation;
    int[] totalOpenSite;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("N and T should be greater than 0");
        }
        totalOpenSite = new int[T];

        int i = 0;
        while (T > 0) {
            percolation = pf.make(N);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                percolation.open(row, col);
            }
            totalOpenSite[i] = percolation.numberOfOpenSites();
            T--;
            i++;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(totalOpenSite);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(totalOpenSite);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return mean() - (1.96 * (stddev() / Math.sqrt(totalOpenSite.length)));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + (1.96 * (stddev() / Math.sqrt(totalOpenSite.length)));
    }

    public static void main(String[] args) {
        PercolationFactory percolationFactory = new PercolationFactory();
        PercolationStats percolationStats = new PercolationStats(20, 20, percolationFactory);
        double mean = 0;
        for (int i = 0; i < 20; i++) {
            System.out.println(percolationStats.totalOpenSite[i]);
            mean += percolationStats.totalOpenSite[i];
        }


        System.out.println("mean " + percolationStats.mean());
        System.out.println("deviation " + percolationStats.stddev());

    }
}

