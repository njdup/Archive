package njdup.FenwickTree;

/*
 * --------------------------------
 *   Fenwick Tree Implementation
 * --------------------------------
 *
 * The following is an implementation of the fenwick tree data structure
 *
 */

public final class FenwickTree {
  private int size;
  private double[] cumulativeFreqs;

  public FenwickTree(int desiredSize) {
    size = desiredSize;
    cumulativeFreqs = new double[desiredSize + 1]; // +1 to allow 1-indexing
  }

  public void increment(int index, double amount) {
    for (int curr = index; curr <= size; curr += (curr & -curr)) {
      cumulativeFreqs[curr] += amount;
    }
  }

  public double cumulativeFreq(int index) {
    double result = 0;
    for (int curr = index; curr > 0; curr -= (curr & -curr)) {
      result += cumulativeFreqs[curr];
    }
    return result;
  }

}
