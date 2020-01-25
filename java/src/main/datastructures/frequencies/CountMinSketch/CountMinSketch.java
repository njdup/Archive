package datastructures.frequencies.CountMinSketch;

/*
 * --------------------------------
 *   Count-min Sketch Implementation
 * --------------------------------
 *
 * The following is an implementation of the count-min sketch
 * data structure for the frequency estimation problem.
 *
 */
import java.util.Random;

// TODO: Figure out if I can make this generic
public final class CountMinSketch implements FrequencyEstimator {

  // TODO: Find reasonable default values for these parameters
  //       maybe allow for random seed
  private static final double DEFAULT_ACCURACY = 0.5;
  private static final double DEFAULT_CONFIDENCE = 0.8;

  private static final long PRIME_MOD = (1 << 31) - 1;

  // Instance variables
  private int[] hashes;
  private int[][] frequencyTable;
  private int depth;
  private int width;

  //
  public CountMinSketch() {
    this(DEFAULT_ACCURACY, DEFAULT_CONFIDENCE);
  }

  public CountMinSketch(double accuracy, double confidence) {
    width = (int)Math.ceil(Math.E/accuracy);
    depth = (int)Math.ceil(Math.log(1/confidence)/Math.log(Math.E));
    System.out.println(width);
    System.out.println(depth);
    hashes = createHashes(depth);
    frequencyTable = new int[width][depth];
  }

  public void increment(int element) {
    for(int row = 0; row < depth; row++) {
      frequencyTable[row][hash(element, row)]++;
    }
  }

  public int estimate(int element) {
    int result = Integer.MAX_VALUE;
    for (int row = 0; row < depth; row++) {
      result = Math.min(result, frequencyTable[row][hash(element, row)]);
    }
    return result;
  }

  // TODO: Implement this clear function
  public void clear() {
    // Nothing yet...
  }

  /*
   * ----------------------------
   *
   * Private helper methods below
   *
   * ----------------------------
   */

  private static int[] createHashes(int numHashes) {
    int[] result = new int[numHashes];
    Random rand = new Random();

    for (int i = 0; i < numHashes; i++) {
      result[i] = rand.nextInt(Integer.MAX_VALUE);
    }
    return result;
  }

  private int hash(int element, int hashNum) {
    int hashVal = hashes[hashNum]*element;
    hashVal += hashVal >> 32;
    hashVal &= PRIME_MOD;
    return hashVal % width;
  }

}
