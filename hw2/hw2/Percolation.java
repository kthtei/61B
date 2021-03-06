package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private int length;
    private boolean[][] grid;
    private int numOpen;
    private int virtualTop;
    private int virtualBottom;

    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("Grid should be greater than 0");
        }

        weightedQuickUnionUF = new WeightedQuickUnionUF(N * N + 2);
        length = N;
        virtualTop = N * N;
        virtualBottom = N * N + 1;
        grid = new boolean[N][N];
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 0 || row >= this.length * this.length || col < 0 || col >= this.length * this.length) {
            throw new IndexOutOfBoundsException("Row and column index should be between 0 and N - 1");
        }

        if (!isOpen(row, col)) {
            grid[row][col] = true;
            numOpen++;
        }

        // virtual top
        if (row == 0) {
            weightedQuickUnionUF.union(virtualTop, xyTo1D(row, col));
        }

        // virtual bottom
        if (row == length - 1 && !percolates()) {
            weightedQuickUnionUF.union(virtualBottom, xyTo1D(row, col));
        }

        if (row - 1 >= 0 && isOpen(row - 1, col)) {
            weightedQuickUnionUF.union(xyTo1D(row, col), xyTo1D(row - 1, col));
        }
        if (row + 1 < length && isOpen(row + 1, col)) {
            weightedQuickUnionUF.union(xyTo1D(row, col), xyTo1D(row + 1, col));
        }
        if (col - 1 >= 0 && isOpen(row, col - 1)) {
            weightedQuickUnionUF.union(xyTo1D(row, col), xyTo1D(row, col - 1));
        }
        if ( col + 1 < length && isOpen(row, col + 1)) {
            weightedQuickUnionUF.union(xyTo1D(row, col), xyTo1D(row, col + 1));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col)  {
        return grid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return weightedQuickUnionUF.connected(virtualTop, xyTo1D(row, col));
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numOpen;
    }

    // does the system percolate?
    public boolean percolates()  {
        return weightedQuickUnionUF.connected(virtualTop, virtualBottom);
    }

    // turn xy to 1D number
    public int xyTo1D(int row, int col) {
        return (row * this.length) + (col);
    }

    // use for unit testing (not required)
    public static void main(String[] args) {
        Percolation percolation = new Percolation(6);
        percolation.open(0, 5);
        percolation.open(1, 5);
        percolation.open(2, 5);
        percolation.open(3, 5);
        percolation.open(4, 5);
        percolation.open(4, 4);
        percolation.open(3, 3);
        percolation.open(2, 3);
        percolation.open(1, 3);
        percolation.open(1, 2);
        percolation.open(1, 1);
        percolation.open(1, 0);
        percolation.open(2, 0);
        percolation.open(3, 0);
        percolation.open(4, 0);
        percolation.open(4, 1);
        percolation.open(5, 1);
        percolation.open(4, 3);
        System.out.println(percolation.percolates());
    }
}
