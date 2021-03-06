package datastructures.frequencies.FenwickTree;

import org.junit.Test;
import static org.junit.Assert.*;

public class FenwickTreeTest {

  @Test
  public void testIncrementBasic() {
    FenwickTree testTree = new FenwickTree(10);

    testTree.increment(5, 25);
    assertEquals(25, testTree.cumulativeFreq(5), 0.001);
  }

}
